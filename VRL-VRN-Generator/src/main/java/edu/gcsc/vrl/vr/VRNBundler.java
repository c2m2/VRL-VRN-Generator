package edu.gcsc.vrl.vr;

import eu.mihosoft.vrl.annotation.ComponentInfo;
import eu.mihosoft.vrl.annotation.ParamInfo;
import eu.mihosoft.vrl.annotation.MethodInfo;
import eu.mihosoft.vrl.system.VMessage;
import eu.mihosoft.vrl.visual.MessageType;
import java.io.Serializable;
import java.io.File;
import java.nio.file.Path;
import static java.nio.file.StandardCopyOption.*;
import java.nio.file.Files;
import java.io.IOException;


/**
 * VRN Bundler component to compile generated meshes into an archive of custom container format
 */
@ComponentInfo(name = "VRN Bundler", category = "VR/")
public class VRNBundler implements Serializable {
  /// necessary for session serialization
  private static final long serialVersionUID = 1L;

  /**
   * Compiles respectively bundles the meshes into an .vrn archive file
   * @param file output file name without .vrn extension
   */
  @MethodInfo(name="Bundle as .vrn file")
  public void bundle
  (
    @ParamInfo(name = "Ouput file", style="save-dialog", options = "endings=[\"vrn\"]; description=\"VRN files (.vrn)\"") File oFile,
    @ParamInfo(name = "Mesh folder") File iFile
  )
  {
    VMessage.msg("Bundling mesh", "Meshes are bundled into a .vrn archive from the Mesh folder", MessageType.INFO);
    try {
     Files.copy(new File(iFile.getParent() + File.separator + iFile.getName().replace(".swc", "") + File.separator + iFile.getName().replace(".swc", "") + File.separator + iFile.getName().replace(".swc", "") + ".vrn").toPath(), oFile.toPath(), REPLACE_EXISTING);
    } catch (IOException ioe) {
      String error = "Copying file from " + iFile.getParent() + File.separator + iFile.getName().replace(".swc", "") + File.separator + iFile.getName().replace(".swc", "") + File.separator + iFile.getName().replace(".swc", "") + ".vrn" + " to " + oFile + " failed.";
      VMessage.msg("Copying files failed", error, MessageType.ERROR);
    }
  }
}
  