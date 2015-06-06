package org.zerocouplage.zcstudio.newproject;

import java.io.IOException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
//import org.eclipse.ui.wizards.datatransfer.ImportOperation;




public class NewZCProjectModel
{
	public static final String copyright = "(c)Copyright 2015 ZCStudio";
		
	


	
	// Project Name
	protected String projectName;
	
	// choice of JRE
	protected boolean executionJRE;
Copy cp=new Copy();

	// flag is set if a folder called Discounts is selected 
	// when the wizard is started; a discount is offered in this case
	boolean discounted = false;	

//	public String toString()
//	{
//	String s= "pr le test";
//	IWorkspace workspace = ResourcesPlugin.getWorkspace();
//
//	String workspaceDirectory = workspace.getRoot().getLocation().toFile().toString();
//
//
//	return workspaceDirectory;
//			
//	}
	
//Crean an empty  project 	
	public void creatEmptyProject() throws CoreException, IOException{

		cp.copy(projectName);
		//Programmatically import the project into Eclipse		

        IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);

				project.create(null);
			
				project.open(null);
	}			    
}

			
	
	

