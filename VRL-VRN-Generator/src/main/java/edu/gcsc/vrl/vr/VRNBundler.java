package edu.gcsc.vrl.vr;

import eu.mihosoft.vrl.annotation.ComponentInfo;
import eu.mihosoft.vrl.annotation.ParamInfo;
import eu.mihosoft.vrl.annotation.MethodInfo;
import java.io.Serializable;
import java.io.File;

/**
 * Mesh Generator component to generate and bundle meshes for VR in Unity
 */
@ComponentInfo(name = "VRN Bundler", category = "VR/")
public class VRNBundler implements Serializable {
  /// necessary for session serialization
  private static final long serialVersionUID = 1L;

  /**
   * Bundle all mesh files to VRN file format (.vrn container format)
   * @param file output file name (VRN)
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
  