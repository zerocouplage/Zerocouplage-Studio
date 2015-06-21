package org.zerocouplage.zcstudio.newproject;

import java.io.IOException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
//import org.eclipse.ui.wizards.datatransfer.ImportOperation;




public class NewZCProjectModel
{
	public static final String copyright = "(c)Copyright 2015 ZCStudio";
		
	


	
	// Project Name
	protected String projectName;
	// New Project Selection
	protected String selectedExample;
	
	// choice of JRE
	protected boolean executionJRE;
GetProjectLocation cp=new GetProjectLocation();

	// flag is set if a folder called Discounts is selected 
	// when the wizard is started; a discount is offered in this case
	boolean discounted = false;	
//.........................
//	public String toString()
//	{
//	
//
//
//	return selectedExample;
//			
//	}
	//..................................
//Crean an empty  project 	
	public void creatProject() throws CoreException, IOException{

		cp.copy(projectName,selectedExample);
		//Programmatically import the project into Eclipse		
		
        IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
        
        //if the project already exist it doesn't be create 
        if (!project.exists()) {
			
				project.create(null);
        
				project.open(null);
	                         }			   
      
	}
	
	
}

			
	
	

