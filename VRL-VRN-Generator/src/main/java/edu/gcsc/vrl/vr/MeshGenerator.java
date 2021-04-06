package edu.gcsc.vrl.vr;

import eu.mihosoft.vrl.annotation.ComponentInfo;
import eu.mihosoft.vrl.annotation.MethodInfo;
import eu.mihosoft.vrl.annotation.OutputInfo;
import eu.mihosoft.vrl.annotation.ParamInfo;
import eu.mihosoft.vrl.system.VMessage;
import eu.mihosoft.vrl.visual.MessageType;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.AclEntryPermission;
import java.nio.file.attribute.AclEntryType;
import java.nio.file.attribute.AclFileAttributeView;
import java.util.List;

/**
 * Mesh Generator component to generate inflated and refined meshes
 */
@ComponentInfo(name = "Mesh Generator", category = "VR/")
/**
 * Mesh Generator visual component
 */
public class MeshGenerator implements Serializable {

  /// necessary for session serialization
  private static final long serialVersionUID = 1L;

  /// Windows 
  private static final boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");

  /**
   * Generate 1D and 2D meshes
   * @param file input file name of file type .swc
   * @param inflation factor of inflation for 2D mesh
   * @param refinement number of 1D mesh refinements
   * @param smooth if true mesh is pre-refined otherwise not
   * @param segLength segment length for 1D mesh regularization in physiological units (µm)
   * @param config run configuration for the ugshell binary which executes the mesh generation pipeline
   * @return input file
   */
  @MethodInfo(
    name = "Mesh folder",
    valueTypeName = "Mesh folder",
    valueName = "Mesh folder"
  )
  @OutputInfo(name = "Mesh folder", style = "default", typeName = "Mesh folder")
  public File generate(
    @ParamInfo(
      name = "Input file",
      style = "load-dialog",
      options = "endings=[\"swc\"]; description=\"SWC files (.swc)\""
    ) final File file,
    @ParamInfo(
      name = "Inflation factor 2D",
      options = "value=1;min=1;max=100",
      style = "slider"
    ) final int inflation,
    @ParamInfo(
      name = "Number of 1D Refinements",
      options = "value=0;min=0;max=10",
      style = "slider"
    ) final int refinement,
    @ParamInfo(name = "Pre-smooth") final boolean smooth,
    @ParamInfo(
      name = "Segment length",
      options = "value=4;min=1;max=255"
    ) final int segLength,
    @ParamInfo(name = "UG configuration") final UGConfigurator.UGConfiguration config
  ) {
    VMessage.msg(
      "Generating meshes",
      "Mesh inflations and refinements are being created",
      MessageType.INFO
    );
      /// Make mesh generation script executable
      makeExecutable(config);

      /// Configure mesh generation script parameters with values
      MeshingParameter meshingParameters = 
        new MeshingParameterBuilder()
          .setSmoothing(smooth)
          .setRefinement(refinement)
          .setInflation(inflation)
          .setSegLength(segLength)
          .build();

      /// Run mesh generation script with parameter values
      runExecutable(config, file, meshingParameters);

      /// Allow to pass input file to mesh bundler in workflow
      return file;
  }

  /**
   * Make script executable specified in ug runtime configuration
   * @param config ug runtime configuration
   */
  private void makeExecutable(final UGConfigurator.UGConfiguration config) {
      try {
        AclFileAttributeView view = Files.getFileAttributeView(config.getScriptPath().toPath(), AclFileAttributeView.class);
        AclEntry entry = AclEntry.newBuilder()
         .setType(AclEntryType.ALLOW)
         .setPrincipal(Files.getOwner(config.getScriptPath().toPath()))
         .setPermissions(AclEntryPermission.EXECUTE)
         .build();

        /// All OS supporting ACLs
        if (view != null) {
          List<AclEntry> acl = view.getAcl();
          acl.add(0, entry);
          view.setAcl(acl);
        } else {
          if (!isWindows) {
           /// Linux or OSX
           Runtime.getRuntime().exec("chmod u+x " + config.getScriptPath().toString());
          } else {
           /// Windows WSL
           Runtime.getRuntime().exec("cmd.exe /c sh -c \"chmod u+x\" " + config.getScriptPath().toString().replace("\\", "\\\\"));
          }
        }
    } catch (IOException ioe) {
      VMessage.msg("Mesh generation failed: Pipeline script not executable. Check console for details.", ioe.toString(), MessageType.ERROR);
    }
  }

  /**
   * Run executable to generate mesh with supplied file and ug runtime configuration
   * @param config ug runtime configuration
   * @param file geometry file
   * @param meshingParameters values for parameters of mesh generation script
   */
  private void runExecutable(final UGConfigurator.UGConfiguration config, final File file, final MeshingParameter meshingParameters) {
    try {
      Path path = config.getScriptPath().toPath();
      Charset charset = StandardCharsets.UTF_8;

      String content = new String(Files.readAllBytes(path), charset);
      content = content.replace("$BINARY", config.getBinaryPath().getAbsolutePath().replace("\\", "\\\\"));
      Files.write(path, content.getBytes(charset));

      ProcessBuilder builder;
      if (!isWindows) {
        /// OSX and Linux
        builder =
          new ProcessBuilder(
            config.getScriptPath().toString(),
            "-i" + file.getName(),
            "-o" + file.getName().replace(".swc", "")
          );
      } else {
        /// Windows WSL (Getopts not guaranteed to be available on WSL-enabled devices)
        content = content.replace("FILE_PATTERN=", "FILE_PATTERN=" + file.getName().replace("\\", "\\\\"));
        content = content.replace("FOLDERNAME=", "FOLDERNAME=" + file.getName().replace(".swc", "").replace("\\", "\\\\"));
        builder =
          new ProcessBuilder(
            "cmd.exe",
            "/c sh",
            config.getScriptPath().getAbsolutePath().replace("\\", "\\\\")
          );

          /// Temporary debug output for Windows builds
          System.err.println("cmd.exe /c sh" + config.getScriptPath().getAbsolutePath().replace("\\", "\\\\") +
          "-i" + file.getName().replace("\\", "\\\\") +   "-o" + file.getName().replace(".swc", "").replace("\\", "\\\\"));

          VMessage.msg("cmd.exe /c sh" + config.getScriptPath().getAbsolutePath().replace("\\", "\\\\") +
          "-i" + file.getName().replace("\\", "\\\\") +   "-o" + file.getName().replace(".swc", "").replace("\\", "\\\\"), "", MessageType.INFO);
      }
 
      builder = builder.directory(new File(file.getParent()));
      Process process = builder.start();
      InputStream is = process.getInputStream();
      InputStreamReader isr = new InputStreamReader(is);
      BufferedReader br = new BufferedReader(isr);
      String line;

      while ((line = br.readLine()) != null) {
        System.out.println(line);
      }

    } catch (IOException ioe) {
      VMessage.msg("Mesh generation failed: Pipeline script couldn't be run. Check console for details.", ioe.toString(), MessageType.ERROR);
    }
  }
}
