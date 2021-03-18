package edu.gcsc.vrl.vr;

import eu.mihosoft.vrl.annotation.ComponentInfo;
import eu.mihosoft.vrl.annotation.ParamInfo;
import eu.mihosoft.vrl.annotation.MethodInfo;
import java.io.Serializable;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @brief Mesh Generator component to generate and bundle meshes for VR in Unity
 */
@ComponentInfo(name = "Mesh Generator", category = "VR/")
/**
 * @brief Mesh Generator visual component
 */
public class MeshGenerator implements Serializable {
  /// necessary for session serialization
  private static final long serialVersionUID = 1L;

  /**
   * @brief Generate 1D and 2D meshes
   * @param file input file name (SWC)
   * @param inflation factor of inflation for 2D mesh
   * @param refinement number of 1D mesh refinements
   */
  @MethodInfo(name="Generate mesh")
  public void generate
  (
    @ParamInfo(name = "Input file", style="load-dialog") File file,
    @ParamInfo(name = "Inflation factor 2D", options="value=1;min=1;max=100", style="slider") int inflation,
    @ParamInfo(name = "Number of 1D Refinements", options="value=0;min=0;max=10", style="slider") int refinement,
    @ParamInfo(name = "Pre-smooth") boolean smooth,
    @ParamInfo(name = "Segment length", options="value=4;min=1;max=255") int segLength,
    @ParamInfo(name = "UG configuration") UGConfigurator.UGConfiguration config
  )
  {
    /// TODO: Refactor and make use of the option (builder pattern) for UGConfigurator
    try {
      Process process = new ProcessBuilder(config.getBinaryPath(), "-call 'print(\"hello world\")'").start();
      InputStream is = process.getInputStream();
      InputStreamReader isr = new InputStreamReader(is);
      BufferedReader br = new BufferedReader(isr);
      String line;

      while ((line = br.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException ioe) {
    /// TODO: Use vrl mihosoft vmessage instead for GUI notification
    System.err.println("Error could not run!");
    }
  }
}
