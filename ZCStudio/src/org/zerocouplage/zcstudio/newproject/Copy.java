package org.zerocouplage.zcstudio.newproject;

 
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EnumSet;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;






public  class Copy {
	
	//get object which represents the workspace 
	IWorkspace workspace = ResourcesPlugin.getWorkspace();
	 
	//get location of workspace (java.io.File)
	String workspaceDirectory = workspace.getRoot().getLocation().toFile().toString(); //.replaceAll("\\", "/")
 
//	  String s= workspaceDirectory.replaceAll("\\", "/");
	
	
	// standard Java I/O means to copy and unzip an existing example project
	public void copy(){
	   try {
	    	  Path source =Paths.get("C:/Users/Doaae K/Desktop/Douaae");
		      Path target =Paths.get("C:/Users/Doaae K/Desktop/ws/ana");
	          Files.walkFileTree(source, EnumSet.of(FileVisitOption.FOLLOW_LINKS),
	              Integer.MAX_VALUE, new CopyDirectory(source, target));
	        } catch (IOException ex) {
	          ex.printStackTrace();
	        }
	}
}
