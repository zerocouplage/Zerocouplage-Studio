package org.zerocouplage.zcstudio.exports;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;


public class ExportWizardMainPage extends WizardPage implements Listener {

	public static final String copyright = "(c) Copyright 2015 ZCStudio";

	IWorkbench workbench;
	IStructuredSelection selection;
	Text projectNameText;
	Text DirectoryText;
	
	Button executionJREButton;
	
	/*Device device= new Device();
	Image i = new Image(device, "icons/ZCIcon.png");
	String image ="icons/ZCIcon.png";
	public static ImageDescriptor Img ;
	Img.createFromURL(url);
*/
	public ExportWizardMainPage(IWorkbench workbench,
			IStructuredSelection selection) {
		super("Page1");
		setTitle("Create a ZC Project");
		setDescription("Create a ZC project in the workspace or in an external location");
		this.workbench = workbench;
		this.selection = selection;
	}

	@Override
	public void createControl(Composite parent) {
		GridData gd;
		Composite composite = new Composite(parent, SWT.NULL);

		GridLayout gl = new GridLayout();
		int ncol = 2;
		gl.numColumns = ncol;
		composite.setLayout(gl);

		// Project Name
		new Label(composite, SWT.NONE).setText("Package:");
		DirectoryText = new Text(composite, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = ncol - 1;
		DirectoryText.setLayoutData(gd);

		new Label(composite, SWT.NONE).setText("Project Name:");
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

	private void addListeners() {
		executionJREButton.addListener(SWT.Selection, this);

		projectNameText.addListener(SWT.KeyUp, this);
	}
	public void handleEvent(Event event) {
		  
		getWizard().getContainer().updateButtons();
	}
	
	private void createLine(Composite parent, int ncol) 
	{
		Label line = new Label(parent, SWT.SEPARATOR|SWT.HORIZONTAL|SWT.BOLD);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan = ncol;
		line.setLayoutData(gridData);
	}
	private void saveDataToModel()
	{
	    // Gets the model
		ExportZCDesktopApp wizard = (ExportZCDesktopApp)getWizard();
		ExportWizardModel model = wizard.model;

//		IProject[] projects = root.getProjects();
//		// Loop over all projects
//		for (IProject project : projects) {
//			System.out.println(project.getName());
//		}
	    // Saves the user choices in the model
		model.projectName = projectNameText.getText();
		model.executionJRE = executionJREButton.getSelection();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public Control getControl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void performHelp() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDescription(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setImageDescriptor(ImageDescriptor arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTitle(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setVisible(boolean arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean canFlipToNextPage() {
		if (getErrorMessage() != null) return false;
		if (isTextNonEmpty(DirectoryText)
			 &&
			(executionJREButton.getSelection() ))
			return true;
		return false;
	}
	
	private static boolean isTextNonEmpty(Text t)
	{
		String s = t.getText();
		if ((s!=null) && (s.trim().length() >0)) return true;
		return false;
	}	

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWizardPage getNextPage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWizardPage getPreviousPage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWizard getWizard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPageComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setPreviousPage(IWizardPage arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setWizard(IWizard arg0) {
		// TODO Auto-generated method stub

	}

}
