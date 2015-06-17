package org.zerocouplage.zcstudio.exports;

import org.eclipse.core.resources.IFolder;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;


public class ExportZCDesktopApp extends Wizard implements INewWizard {
	
	public static final String copyright = "(c) Copyright 2015 ZCStudio";	
	// wizard pages
	ExportWizardMainPage exportZCProjectPage;
	ExportWizardModel model;
	protected IStructuredSelection selection;
	protected boolean creationCompleted = false;
	protected IWorkbench workbench;

	public ExportZCDesktopApp() {
		// TODO Auto-generated constructor stub
	}
	
	public void addPages()
	{
		exportZCProjectPage = new ExportWizardMainPage(workbench, selection);
		addPage(exportZCProjectPage);
		
		
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		if (selection != null && !selection.isEmpty()) {
			Object obj = selection.getFirstElement();
			if (obj  instanceof IFolder) {
				IFolder folder = (IFolder) obj;				
				if (folder.getName().equals("Discounts"))
					model.discounted = true;				
			}
		}
		
	}
	public boolean canFinish()
	{
		// cannot complet the wizard from the first page
		if (this.getContainer().getCurrentPage() == exportZCProjectPage) 
			return false;
		return true;  //return false;
	}

	@Override
	public boolean performFinish() {
		// TODO Auto-generated method stub
		try {
			model.creatEmptyProject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		return true;
	}

}
