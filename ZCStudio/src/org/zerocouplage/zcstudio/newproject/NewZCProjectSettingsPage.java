package org.zerocouplage.zcstudio.newproject;

import java.io.File;
import java.io.FileFilter;

import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;



public class NewZCProjectSettingsPage extends WizardPage implements Listener 
{
	public static final String copyright = "(c) Copyright 2015 ZCStudio";
	
	// widgets on this page
	List exampleProjectList;

		
	/**
	 * Constructor for NewZCProjectSettingsPage.
	 */
	protected NewZCProjectSettingsPage(String arg0) {
		super(arg0);
		setTitle("Templates");
		setDescription("Select one of the available templates to generate a fully-functioning ZC project");
	}
	
	
	//verify if file listed in settingsPage are projects
	 public boolean verifyZcProject(File project){
		  
		          
	        	   File [] Files =project.listFiles();
	        	   for(File File : Files){
	        		   
	        		   if(File.getName().equals(".project")){
	        			   return true;
	        		   }
	        	   }
   
	           
	    return false;
 }
	 
//list content of examples directory
	 public void listerRepertoire(String pathname){ 

	      // construction d'un fichier sur ce répertoire
	     File repFile =  new File(pathname) ;

	      // filtrage du contenu de ce répertoire
	      // on passe en paramètre une instance de classe anonyme
	     File [] projects = repFile.listFiles() ;

	         // cette interface n'a qu'une unique méthode
	        
	        	 for (File project : projects) {
	        		
	        		 if(project.isDirectory() && verifyZcProject(project)){
	        			 String fileName = project.getName();
	        			 exampleProjectList.add(fileName);
	        		 }
	  			   }
	        		 
	  			

	        	 
	         }


	/**
	 * @see IDialogPage#createControl(Composite)
	 */
	public void createControl(Composite parent) {

	    // create the composite to hold the widgets
		GridData gd;
		Composite composite = new Composite(parent, SWT.NONE);

	    // create the desired layout for this wizard page
		GridLayout gl = new GridLayout();
		int ncol = 2;
		gl.numColumns = ncol;
		composite.setLayout(gl);
	
	    // flights list
		Label label = new Label (composite, SWT.NONE);
		label.setText("Available Templates :");

		exampleProjectList = new List(composite, SWT.BORDER | SWT.READ_ONLY  );
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan =ncol;
		exampleProjectList.setLayoutData(gd);
		exampleProjectList.addListener(SWT.Selection, this);

		
	    // set the composite as the control for this page
		setControl(composite);		
		setPageComplete(true);
	}

	public boolean canFlipToNextPage()
	{
		// no next page for this path through the wizard
		return false;
	}
	
    /*
     * Process the events: 
     * when the user has entered all information
     * the wizard can be finished
     */
	public void handleEvent(Event e)
	{

		setPageComplete(isPageComplete());
		getWizard().getContainer().updateButtons();
	}
	
	/*
	 * Sets the completed field on the wizard class when all the information 
	 * is entered and the wizard can be completed
	 */	 
	public boolean isPageComplete()
	{
	
		saveDataToModel();
		return true;
	}
	
	private void saveDataToModel()
	{
		NewZCProjectWizard wizard = (NewZCProjectWizard)getWizard();
		wizard.model.selectedExample = exampleProjectList.getSelection()[0];
		wizard.creationCompleted = true;
	}	

	void onEnterPage()
	{
		exampleProjectList.removeAll();
		listerRepertoire(GetProjectLocation.ZCSDK+"\\examples");

	}
}
