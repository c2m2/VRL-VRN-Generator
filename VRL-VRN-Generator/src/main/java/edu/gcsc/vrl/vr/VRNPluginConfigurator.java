package edu.gcsc.vrl.vr;

import eu.mihosoft.vrl.system.InitPluginAPI;
import eu.mihosoft.vrl.system.PluginAPI;
import eu.mihosoft.vrl.system.PluginIdentifier;
import eu.mihosoft.vrl.system.VPluginAPI;
import eu.mihosoft.vrl.system.VPluginConfigurator;
import eu.mihosoft.vrl.system.PluginDependency;
import eu.mihosoft.vrl.system.VMessage;
import eu.mihosoft.vrl.visual.MessageType;
import eu.mihosoft.vrl.io.IOUtil;
import eu.mihosoft.vrl.system.ProjectTemplate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.awt.image.BufferedImage;

/**
 * Registry for visual mesh generation components in workflow
 */
public class VRNPluginConfigurator extends VPluginConfigurator {
  /**
   * Plugin configurator specifiying name, author, version and dependencies
   */
  public VRNPluginConfigurator() {
    // specify the plugin name and version 
    setIdentifier(new PluginIdentifier("VRL-VRN-Generator", "0.0.1"));

    // exported by using the exportPackage() method:
    exportPackage("edu.gcsc.vrl.vr");

    // describe the plugin
    setDescription(
      "VRL project for mesh generation and bundling of meshes for VR projects in Unity"
    );

    // copyright info
    setCopyrightInfo(
      "VRL-VRN-MeshGenerator",
      "(c) Stephan Grein",
      "c2m2vr.wordpress.com",
      "License Name to be added here",
      "License Text to be added here"
    );

    // specify dependencies
    addDependency(new PluginDependency("VRL", "0.4.0", "0.5.0"));
  }

  /**
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
   */
  @Override
  public void unregister(PluginAPI api) {
    // nothing to unregister
  }

  /**
   * 
   */
  @Override
  public void init(InitPluginAPI iApi) {
      PathProvider.plugin = iApi.getResourceFolder();

      /// Install pipeline script
      final File templatePipelineScript = new File(iApi.getResourceFolder(), "pipeline_vr.sh");

      InputStream in = VRNPluginConfigurator.class.getResourceAsStream("/edu/gcsc/vrl/vr/pipeline_vr.sh");

      saveProjectTemplate(in, templatePipelineScript);

      // add template project files
      final File templateProject = new File(iApi.getResourceFolder(), "mesh_generation.vrlp");
     
      in = VRNPluginConfigurator.class.getResourceAsStream("/edu/gcsc/vrl/vr/mesh-generation.vrlp");
         
      saveProjectTemplate(in, templateProject);

      // register as project templates with VRL
      iApi.addProjectTemplate(new ProjectTemplate()
         {
             @Override
             public String getName()
             {
                 return "Mesh generation - Example Workflow";
             }

             @Override
             public File getSource()
             {
                 return templateProject;
             }

             @Override
             public String getDescription()
             {
                 return "template for mesh generation and bundling for VR";
             }

             @Override
             public BufferedImage getIcon()
             {
                 return null;
             }
         }
      );
 }

   /**
     * @brief saves the project templates
     */
    private void saveProjectTemplate(InputStream in, File outFile)
    {
        try
        {
            IOUtil.saveStreamToFile(in, outFile);
        }
        catch (FileNotFoundException ex)
        {
          VMessage.exception("Resource file not found", ex.toString());

        }
        catch (IOException ex)
        {
          VMessage.exception("Resource file could not be loaded", ex.toString());
        }
    }

}
