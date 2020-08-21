package edu.gcsc.vrl.vr;

import eu.mihosoft.vrl.annotation.ComponentInfo;
import eu.mihosoft.vrl.annotation.ParamInfo;
import java.io.Serializable;
import java.io.File;

/**
 * @brief Mesh Generator component to generate and bundle meshes for VR in Unity
 */
@ComponentInfo(name = "VRN Bundler", category = "VR/")
public class VRNBundler implements Serializable {
  /// necessary for session serialization
  private static final long serialVersionUID = 1L;

  /**
   * @brief Bundle all mesh files to VRN file format (.vrn container format)
   * @param file output file name (VRN)
   */
  public void bundle
  (
    @ParamInfo(name = "Ouput file", style="save-dialog") File file
  )
  {
    /// TODO: Bundle for VR in .vrn container format
  }
}
  