package edu.gcsc.vrl.vr;

import eu.mihosoft.vrl.annotation.ComponentInfo;
import eu.mihosoft.vrl.annotation.ParamInfo;
import eu.mihosoft.vrl.annotation.MethodInfo;
import java.io.Serializable;
import java.io.File;

/**
 * @brief Mesh Generator component to generate and bundle meshes for VR in Unity
 */
@ComponentInfo(name = "Mesh Generator", category = "VR/")
public class MeshGenerator implements Serializable {
  /// necessary for session serialization
  private static final long serialVersionUID = 1L;

  /**
   * @brief Generate 1D and 2D meshes
   * @param file input file name (SWC)
   * @param inflation factor of inflation for 2D mesh
   * @param refinement number of 1D mesh refinements
   */
  @MethodInfo(name="Generate mesh", hide=true, num=1)
  public void generate
  (
    @ParamInfo(name = "Input file", style="load-dialog") File file,
    @ParamInfo(name = "Inflation factor 2D", options="value=1.0") double inflation,
    @ParamInfo(name = "Number of 1D Refinement", options="value=0;min=0,max=10", style="slider") int refinement
  )
  {
    /// TODO: Add UG API calls to neuro_collections grid generation
  }

  @MethodInfo(name="Run simulation", hide=true, num=1)
  public void simulate
  (
    @ParamInfo(name = "End time [s]", options="value=1.0") double endTime,
    @ParamInfo(name = "minDt [s]", options="value=0.00001") double minDt,
    @ParamInfo(name = "maxDt [s]", options="value=0.001") double maxDt
  ) 
  {
    /// TODO: Add UG API calls to run simulation
  }
}
