package edu.gcsc.vrl.vr;

import eu.mihosoft.vrl.annotation.ComponentInfo;
import eu.mihosoft.vrl.annotation.ParamInfo;
import eu.mihosoft.vrl.annotation.MethodInfo;
import eu.mihosoft.vrl.annotation.OutputInfo;
import java.io.File;
import java.io.Serializable;

/**
 * UG runtime configurator component
 */
@ComponentInfo(name = "UG Configurator", category = "VR/")
public class UGConfigurator implements Serializable {
  /// necessary for session serialization
  private static final long serialVersionUID = 1L;

  /**
   * UG runtime configuration
   */
  public class UGConfiguration {
    private String pathToBinary = "ugshell";
    private String pathToScript = "";
    /**
     * Constructs a UG runtime configuration
     * @param pathToBin path to ugshell binary on local filesystem 
     * @param pathToScr path to mesh generation pipeline script on local filesystem
     */
    public UGConfiguration(String pathToBin, String pathToScr) {
      pathToBinary = pathToBin;
      pathToScript = pathToScr;
    }

    /**
     * @return String
     */
    public String getBinaryPath() {
      return pathToBinary;
    }

    /**
     * @return String
     */
    public String getScriptPath() {
      return pathToScript;
    }
  }
  
  @MethodInfo(name = "Configure UG binary",valueTypeName="UG configuration", valueName="UG configuration")
  @OutputInfo(name = "Configuration", style="default", typeName="UG configuration")
  /**
   * Setup the UG runtime configuration
   * @param binary path to ugshell binary
   * @param script path to mesh generation pipeline script
   * @return UGConfiguration
   */
  public UGConfiguration setup
  (
    @ParamInfo(name = "Path to ug binary", style="load-dialog") File binary,
    @ParamInfo(name = "Path to pipeline script", style="load-dialog") File script
  ) {
     return new UGConfiguration(binary.toString(), script.toString());
  }

  /**
   * Setup the UG runtime configuration
   * @param binary path to ugshell binary
   * Note that the pipeline script will be included in the resource folder
   * @return UGConfiguration
   */
  @MethodInfo(name = "Configure UG binary",valueTypeName="UG configuration", valueName="UG configuration")
  @OutputInfo(name = "Configuration", style="default", typeName="UG configuration")
  public UGConfiguration setup
  (
    @ParamInfo(name = "Path to ug binary", style="load-dialog") File binary
  ) {
    File pathToScript = new File(PathProvider.plugin, "pipeline_vr.sh");
    return new UGConfiguration(binary.toString(), pathToScript.toString());
  }
}