/*
 * Copyright 2017 Michael Hoffer <info@michaelhoffer.de>. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are
 * permitted provided that the following conditions are met:
 *
 *    1. Redistributions of source code must retain the above copyright notice, this list of
 *       conditions and the following disclaimer.
 *
 *    2. Redistributions in binary form must reproduce the above copyright notice, this list
 *       of conditions and the following disclaimer in the documentation and/or other materials
 *       provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY Michael Hoffer <info@michaelhoffer.de> "AS IS" AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL Michael Hoffer <info@michaelhoffer.de> OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * The views and conclusions contained in the software and documentation are those of the
 * authors and should not be interpreted as representing official policies, either expressed
 * or implied, of Michael Hoffer <info@michaelhoffer.de>.
 */
package edu.gcsc.vrl.vr;

import eu.mihosoft.vrl.system.InitPluginAPI;
import eu.mihosoft.vrl.system.PluginAPI;
import eu.mihosoft.vrl.system.PluginIdentifier;
import eu.mihosoft.vrl.system.VPluginAPI;
import eu.mihosoft.vrl.system.VPluginConfigurator;
import eu.mihosoft.vrl.system.PluginDependency;

/**
 * Registry for components
 */
public class VRNPluginConfigurator extends VPluginConfigurator {

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

  @Override
  public void register(PluginAPI api) {
    // register plugin with canvas
    if (api instanceof VPluginAPI) {
      VPluginAPI vapi = (VPluginAPI) api;
      vapi.addComponent(MeshGenerator.class);
      vapi.addComponent(VRNBundler.class);
    }
  }

  @Override
  public void unregister(PluginAPI api) {
    // nothing to unregister
  }

  @Override
  public void init(InitPluginAPI iApi) {
    // nothing to init
  }
}
