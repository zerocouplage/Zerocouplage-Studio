package org.zerocouplage.zcstudio.newproject;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.EnumSet;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;






public  class Copy {

	// standard Java I/O means to copy an existing example project
	public void copy(String projectName) throws IOException{
	   
		   
		   //work space location
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			File workspaceDirectory = workspace.getRoot().getLocation().toFile();
			
			
			//copy the existing project example from SDK to the workspace of eclipse 
			java.nio.file.Path source =Paths.get("C:/Users/Doaae K/Desktop/Douaae");
		    java.nio.file.Path target =Paths.get(workspaceDirectory+"\\"+projectName);
		    Files.walkFileTree(source, EnumSet.of(FileVisitOption.FOLLOW_LINKS),
			          Integer.MAX_VALUE, new CopyDirectory(source, target));
	}
}