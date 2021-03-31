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

  /**
   * Generate 1D and 2D meshes
   * @param file input file name of file type .swc
   * @param inflation factor of inflation for 2D mesh
   * @param refinement number of 1D mesh refinements
   * @param smooth if true mesh is pre-refined otherwise not
   * @param segLength segment length for 1D mesh regularization in physiological units (µm)
   * @param config run configuration for the ugshell binary which executes the mesh generation pipeline
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
    ) File file,
    @ParamInfo(
      name = "Inflation factor 2D",
      options = "value=1;min=1;max=100",
      style = "slider"
    ) int inflation,
    @ParamInfo(
      name = "Number of 1D Refinements",
      options = "value=0;min=0;max=10",
      style = "slider"
    ) int refinement,
    @ParamInfo(name = "Pre-smooth") boolean smooth,
    @ParamInfo(
      name = "Segment length",
      options = "value=4;min=1;max=255"
    ) int segLength,
    @ParamInfo(name = "UG configuration") UGConfigurator.UGConfiguration config
  ) {
    VMessage.msg(
      "Generating meshes",
      "Mesh inflations and refinements are being created",
      MessageType.INFO
    );
    try {
      Path path = config.getScriptPath().toPath();
      Charset charset = StandardCharsets.UTF_8;

      String content = new String(Files.readAllBytes(path), charset);
      content = content.replaceAll("\\$BINARY", config.getBinaryPath().getAbsolutePath().replace("\\", "\\\\\\"));
      content =
        content.replaceAll("BINARY.*", "BINARY=" + config.getBinaryPath().getAbsolutePath().replace("\\", "\\\\\\"));
      Files.write(path, content.getBytes(charset));
      boolean isWindows = System
        .getProperty("os.name")
        .toLowerCase()
        .startsWith("windows");

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
          /// Linux or OSX
          if (!isWindows) {
            Runtime.getRuntime().exec("chmod u+x " + config.getScriptPath().toString());
          /// Windows
          } else {
            Runtime.getRuntime().exec("cmd.exe /c sh -c \"chmod u+x\" " + config.getScriptPath().toString().replace("\\", "\\\\\\"));
          }
      }

      ProcessBuilder builder;
      if (!isWindows) {
        builder =
          new ProcessBuilder(
            config.getScriptPath().toString(),
            "-i " + file.getName(),
            "-o" + file.getName().replace(".swc", "")
          );
      } else {
        builder =
          new ProcessBuilder(
            "cmd.exe",
            "/c sh",
            config.getScriptPath().toString().replace("\\", "\\\\"),
            "-i " + file.getName().replace("\\", "\\\\"),
            "-o " + file.getName().replace(".swc", "").replace("\\", "\\\\")
          );
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
      VMessage.msg("Mesh generation failed", ioe.toString(), MessageType.ERROR);
    }
    return file;
  }
}
