package org.zerocouplage.zcstudio.webLauncherAction;




import java.io.File;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.DefaultLogger;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.ProjectHelper;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionService;
import org.zerocouplage.zcstudio.Activator;
import org.zerocouplage.zcstudio.newproject.GetProjectLocation;

public class LaunchWebApp  {
	
	
	
	/**
	 * @return the name of selected project
	 */
	protected static String sampleGetSelectedProject() {
        ISelectionService ss=Activator.getDefault().getWorkbench
().getActiveWorkbenchWindow().getSelectionService();
        String projExpID = "org.eclipse.ui.navigator.ProjectExplorer";
        ISelection sel = ss.getSelection(projExpID);
        Object selectedObject=sel;
        if(sel instanceof IStructuredSelection) {
              selectedObject=((IStructuredSelection)sel).getFirstElement();
        }
        
        if (selectedObject instanceof IAdaptable) {
              IResource res = (IResource) ((IAdaptable) selectedObject)
                          .getAdapter(IResource.class);
            IProject  project = res.getProject();
            return project.getName();
              
        }
        else
		return null;
        
  }

	
	/**
     * To execute the default target specified in the Ant build.xml file
     * 
     * @param buildXmlFileFullPath
     */
    public static boolean executeAntTask(String buildXmlFileFullPath) {
        return executeAntTask(buildXmlFileFullPath, null);
    }
     
    /**
     * To execute a target specified in the Ant build.xml file
     * 
     * @param buildXmlFileFullPath
     * @param target
     */
    public static boolean executeAntTask(String buildXmlFileFullPath, String target) {
        boolean success = false;
        DefaultLogger consoleLogger = getConsoleLogger();
 
        // Prepare Ant project
        Project project = new Project();
//        project.setUserProperty("tomcat","C:/outils/apache-tomcat-6.0.43/apache-tomcat-6.0.43");
//        project.setUserProperty("project.name", "F:/ensa/pfa/workspace/ZCAppsDemo");
        project.setUserProperty("tomcat", GetProjectLocation.tomcat);
        project.setUserProperty("project.name", sampleGetSelectedProject());
       
        File buildFile = new File(buildXmlFileFullPath);
        project.setUserProperty("ant.file", buildFile.getAbsolutePath());
        project.addBuildListener(consoleLogger);
 
        // Capture event for Ant script build start / stop / failure
        try {
            project.fireBuildStarted();
            project.init();
            ProjectHelper projectHelper = ProjectHelper.getProjectHelper();
            project.addReference("ant.projectHelper", projectHelper);
            projectHelper.parse(project, buildFile);
             
            // If no target specified then default target will be executed.
            String targetToExecute = (target != null && target.trim().length() > 0) ? target.trim() : project.getDefaultTarget();
            project.executeTarget(targetToExecute);
            project.fireBuildFinished(null);
            success = true;
        } catch (BuildException buildException) {
            project.fireBuildFinished(buildException);
            throw new RuntimeException("!!! Unable to restart the  App !!!", buildException);
        }
         
        return success;
    }
   
     
    /**
     * Logger to log output generated while executing ant script in console
     * 
     * @return
     */
    private static DefaultLogger getConsoleLogger() {
        DefaultLogger consoleLogger = new DefaultLogger();
        consoleLogger.setErrorPrintStream(System.err);
        consoleLogger.setOutputPrintStream(System.out);
        consoleLogger.setMessageOutputLevel(Project.MSG_INFO);
         
        return consoleLogger;
    }
     
    /**
     * Main method to test code
     * 
     * @param args
     */
    public static void main(String[] args) {
       
 
        System.out.println("-----------------------------");
         
        // Running specified target of ant script
        executeAntTask("src/org/zerocouplage/zcstudio/webLauncherAction/build.xml", "st	rt-tomcat");
        executeAntTask("src/org/zerocouplage/zcstudio/webLauncherAction/build.xml", "war");
        executeAntTask("src/org/zerocouplage/zcstudio/webLauncherAction/build.xml", "undepoly");
        executeAntTask("src/org/zerocouplage/zcstudio/webLauncherAction/build.xml", "remove");
        
        
    }

	

	
}
