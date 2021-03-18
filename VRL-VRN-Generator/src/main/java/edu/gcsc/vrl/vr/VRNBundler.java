package edu.gcsc.vrl.vr;

import eu.mihosoft.vrl.annotation.ComponentInfo;
import eu.mihosoft.vrl.annotation.ParamInfo;
import eu.mihosoft.vrl.annotation.MethodInfo;
import java.io.Serializable;
import java.io.File;

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
    @ParamInfo(name = "Ouput file", style="save-dialog") File file
  )
  {
    /// TODO: Bundle for VR in .vrn container format
  }
}
  