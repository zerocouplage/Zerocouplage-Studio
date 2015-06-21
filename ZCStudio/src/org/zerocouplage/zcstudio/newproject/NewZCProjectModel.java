package org.zerocouplage.zcstudio.newproject;

import java.io.IOException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;

public class NewZCProjectModel {
	public static final String copyright = "(c)Copyright 2015 ZCStudio";

	// Project Name
	protected String projectName;

	// New Project Selection
	protected String selectedExample;

	// choice of JRE
	protected boolean executionJRE;
	GetProjectLocation locations = new GetProjectLocation();

	// Create a new project
	public void creatProject() throws CoreException, IOException {

		locations.copyExampleToWorkspace(projectName, selectedExample);
		// import the project into Eclipse

		IProject project = ResourcesPlugin.getWorkspace().getRoot()
				.getProject(projectName);

		// if the project already exist it doesn't be create and gives an error
		// on the log
		if (!project.exists()) {

			project.create(null);
		} else {
			System.out.println("Projet déjà éxistant");
		}

		project.open(null);

	}

}
