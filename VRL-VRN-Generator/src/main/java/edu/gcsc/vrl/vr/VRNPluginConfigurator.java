package edu.gcsc.vrl.vr;

import eu.mihosoft.vrl.system.InitPluginAPI;
import eu.mihosoft.vrl.system.PluginAPI;
import eu.mihosoft.vrl.system.PluginIdentifier;
import eu.mihosoft.vrl.system.VPluginAPI;
import eu.mihosoft.vrl.system.VPluginConfigurator;
import eu.mihosoft.vrl.system.PluginDependency;

/**
 * Registry for visual mesh generation components in workflow
 */
public class VRNPluginConfigurator extends VPluginConfigurator {
  /**
   * Plugin configurator specifiying name, author, version and dependencies
   */
  public VRNPluginConfigurator() {
    // specify the plugin name and version (semantic versioning)
    setIdentifier(new PluginIdentifier("VRL-VRN-Generator", "0.0.1"));

    // exported by using the exportPackage() method:
    exportPackage("edu.gcsc.vrl.vr");

    // describe the plugin
    setDescription(
      "VRL project for mesh generation and bundling of meshes for VR projects in Unity"
    );

    // copyright info
    setCopyrightInfo(
      "MeshGenerator",
      "(c) Stephan Grein",
      "c2m2 url",
      "License Name",
      "License Text..."
    );

    // specify dependencies
    addDependency(new PluginDependency("VRL", "0.4.0", "0.5.0"));
  }

  /**
   * @see PluginApi.register(PluginAPI)
   */
  @Override
  public void register(PluginAPI api) {
    // register plugin with canvas
    if (api instanceof VPluginAPI) {
      VPluginAPI vapi = (VPluginAPI) api;
      vapi.addComponent(MeshGenerator.class);
      vapi.addComponent(VRNBundler.class);
      vapi.addComponent(UGConfigurator.class);
    }
  }

  /**
   * @see PluginAPI.unregister(PluginAPI)
   */
  @Override
  public void unregister(PluginAPI api) {
    // nothing to unregister
  }

  /**
   * @see PluginAPI.init(InitPluginAPI)
   */
  @Override
  public void init(InitPluginAPI iApi) {
    // nothing to init
  }
}
