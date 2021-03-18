package edu.gcsc.vrl.vr;

import eu.mihosoft.vrl.annotation.ComponentInfo;
import eu.mihosoft.vrl.annotation.ParamInfo;
import eu.mihosoft.vrl.annotation.MethodInfo;
import eu.mihosoft.vrl.annotation.OutputInfo;
import java.io.File;
import java.io.Serializable;

@ComponentInfo(name = "UG Configurator", category = "VR/")
public class UGConfigurator implements Serializable {
  /// necessary for session serialization
  private static final long serialVersionUID = 1L;

  public class UGConfiguration {
    private String pathToBinary = "ugshell";
    private String pathToScript = "";
    public UGConfiguration(String pathToBin, String pathToScr) {
      pathToBinary = pathToBin;
      pathToScript = pathToScr;
    }
    public String getBinaryPath() {
      return pathToBinary;
    }
  }
  
  @MethodInfo(name = "Configure ug4 binary",valueTypeName="ug config", valueName="ug config")
  @OutputInfo(name = "Configuration", style="default", typeName="ug config")
  public UGConfiguration setup
  (
    @ParamInfo(name = "Path to ug binary", style="load-dialog") File binary,
    @ParamInfo(name = "Path to pipeline script", style="load-dialog") File script
  ) {
    return new UGConfiguration(binary.toString(), script.toString());
  }
}