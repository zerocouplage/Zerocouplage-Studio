package org.zerocouplage.zcstudio.newproject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;

/**
 * Class representing the first page of the wizard
 */

public class NewZCProjectMainPage extends WizardPage implements Listener
{

	public static final String copyright = "(c) Copyright 2015 ZCStudio";	
	
	IWorkbench workbench;
	IStructuredSelection selection;
	
	// widgets on this page 
	


	Text projectNameText;
	Text PackageText;
	


	Button executionJREButton;

	
	
	
	// holds an error if project name is invalid
	public static IStatus projectNameStatus;
	public static Status status;
	 private Pattern pattern;
	  private Matcher matcher;
		
	



	
	/**
	 * Constructor for ZCNewProjectMainPage.
	 */
	public NewZCProjectMainPage(IWorkbench workbench, IStructuredSelection selection) {
		super("Page1");
		setTitle("Create a ZC Project");
		setDescription("Create a ZC project in the workspace or in an external location");
		this.workbench = workbench;
		this.selection = selection;
		
		
	}

	/**
	 * @see IDialogPage#createControl(Composite)
	 */
	public void createControl(Composite parent) {

	    // create the composite to hold the widgets
		GridData gd;
		Composite composite =  new Composite(parent, SWT.NULL);

	    // create the desired layout for this wizard page
		GridLayout gl = new GridLayout();
		int ncol = 2;
		gl.numColumns = ncol;
		composite.setLayout(gl);

	
		// Project Name				
				new Label (composite, SWT.NONE).setText("Package:");				
				PackageText = new Text(composite, SWT.BORDER);
				gd = new GridData(GridData.FILL_HORIZONTAL);
				gd.horizontalSpan = ncol - 1;
				PackageText.setLayoutData(gd);
				
				new Label (composite, SWT.NONE).setText("Project Name:");				
				projectNameText = new Text(composite, SWT.BORDER);
				gd = new GridData(GridData.FILL_HORIZONTAL);
				gd.horizontalSpan = ncol - 1;
				projectNameText.setLayoutData(gd);

				createLine(composite, ncol);
                createLine(composite, ncol);

		
		

		// Choice of JRE		
		executionJREButton = new Button(composite, SWT.RADIO);
		executionJREButton.setText("Use an execution environment JRE");
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = ncol;
		executionJREButton.setLayoutData(gd);
		executionJREButton.setSelection(true);
		
		
		
		
	    // set the composite as the control for this page
		setControl(composite);		
		addListeners();
	}
	
	private void addListeners()
	{
		executionJREButton.addListener(SWT.Selection, this);
		
		projectNameText.addListener(SWT.KeyUp, this);
		}

	
	/**
	 * @see Listener#handleEvent(Event)
	 */
	
	public void handleEvent(Event event) {
	
	    pattern = Pattern.compile("^[^.][a-zA-Z0-9_-]{1,15}[^.]$");
	    matcher = pattern.matcher(projectNameText.getText());
		  
	 // Initialize a variable with the no error status
	    status = new Status(IStatus.OK, "not_used", 0, "", null);
	  
	    if (!matcher.matches()) {
	        
	            status = new Status(IStatus.ERROR, "not_used", 0, 
	                "Erreur : invalid nom de projet", null);        
	            projectNameStatus = status;
	    }
	    projectNameStatus = status;
	    // Show the most serious error
	    applyToStatusLine(findMostSevere());
	 
		getWizard().getContainer().updateButtons();
	}

	/**
	 * Applies the status to the status line of a dialog page.
	 */
	private void applyToStatusLine(IStatus status) {
		String message= status.getMessage();
		if (message.length() == 0) message= null;
		switch (status.getSeverity()) {
			case IStatus.OK:
				setErrorMessage(null);
				setMessage(message);
				break;
			case IStatus.WARNING:
				setErrorMessage(null);
				setMessage(message, WizardPage.WARNING);
				break;				
			case IStatus.INFO:
				setErrorMessage(null);
				setMessage(message, WizardPage.INFORMATION);
				break;			
			default:
				setErrorMessage(message);
				setMessage(null);
				break;		
		}
	}
	private IStatus findMostSevere()
	{
		
		if (projectNameStatus.matches(IStatus.ERROR))
			return projectNameStatus;
		
		else return projectNameStatus;	
	}
	/*
	 * Returns the next page.
	 * Saves the values from this page in the model associated 
	 * with the wizard. Initializes the widgets on the next page.
	 */
	
	public IWizardPage getNextPage()
	{    		
		saveDataToModel();		
		if (executionJREButton.getSelection()) {
			
			NewZCProjectSettingsPage page = ((NewZCProjectWizard)getWizard()).settingsPage;
			page.onEnterPage();
			return page;
		}

		return null;
	}

	/**
	 * @see IWizardPage#canFlipToNextPage()
	 */
	public boolean canFlipToNextPage()
	{
		if (getErrorMessage() != null) return false;
		if (isTextNonEmpty(projectNameText)
			 &&
			(executionJREButton.getSelection() ))
			return true;
		return false;
	}
	
	/*
	 * Saves the uses choices from this page to the model.
	 * Called on exit of the page
	 */
	private void saveDataToModel()
	{
	    // Gets the model
		NewZCProjectWizard wizard = (NewZCProjectWizard)getWizard();
		NewZCProjectModel model = wizard.model;

//		IProject[] projects = root.getProjects();
//		// Loop over all projects
//		for (IProject project : projects) {
//			System.out.println(project.getName());
//		}
	    // Saves the user choices in the model
		model.projectName = projectNameText.getText();
		model.executionJRE = executionJREButton.getSelection();
	}

	/**
	 * Applies the status to the status line of a dialog page.
	 */

	
	private static boolean isTextNonEmpty(Text t)
	{
		String s = t.getText();
		if ((s!=null) && (s.trim().length() >0)) return true;
		return false;
	}	

	private void createLine(Composite parent, int ncol) 
	{
		Label line = new Label(parent, SWT.SEPARATOR|SWT.HORIZONTAL|SWT.BOLD);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan = ncol;
		line.setLayoutData(gridData);
	}	

	/**
	 * @return true if all fields of the return dates are set
	 */

	
	


}

