package edu.gcsc.vrl.vr;

import eu.mihosoft.vrl.annotation.ComponentInfo;
import eu.mihosoft.vrl.annotation.MethodInfo;
import eu.mihosoft.vrl.annotation.ParamInfo;
import eu.mihosoft.vrl.system.VMessage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

@ComponentInfo(name="PathProvider", category="VR/")
public class PathProvider implements Serializable
{
    private static final long serialVersionUID = 1L;
    public static File plugin;
    
    /**
     * Get a file from the resource folder
     * @param fName
     * @return File
     */
    @MethodInfo(name="Get Resource file", valueName="File")
    public File getResourceFile
    (
        @ParamInfo(name="Filename") String fName
    )
    {
        File f = new File(plugin, fName);
        
        if (!f.exists())
        {
            VMessage.exception("File not found",
                "The file '"+plugin.getAbsolutePath()+File.separator+fName+"' can not be found.");
            
            return null;
        }
        
        return f;
    }
    
    /**
     * @brief Create a file in the resource folder
     * @param fName
     * @return File
     */
    @MethodInfo(name="Create Resource file", valueName="File")
    public File createResourceFile
    (
        @ParamInfo(name="file name") String fName
    )
    {
        File f = new File(plugin, fName);
        
        try
        {
            f.createNewFile();
        }
        catch (IOException ex)
        {
            VMessage.exception("File creation error",
            "I/O error while trying to create file '"
            +plugin.getAbsolutePath()+fName+"': "+ex.getMessage());
        }
        catch (SecurityException ex)
        {
            VMessage.exception("File creation error",
            "No access granted to file '"
            +plugin.getAbsolutePath()+fName+"' : "+ex.getMessage());
        }
        
        return f;
    }
}