package org.zerocouplage.zcstudio.exports;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;


public class ExportWizardAction implements IObjectActionDelegate {
	public static final String copyright = "(c) Copyright 2015 ZCStudio";

	IWorkbenchPart part;
	ISelection selection;
	/*
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	@Override
	public void run(IAction arg0) {
		ExportZCDesktopApp wizard = new ExportZCDesktopApp();
		if ((selection instanceof IStructuredSelection) || (selection == null))
		wizard.init(part.getSite().getWorkbenchWindow().getWorkbench(), 
			(IStructuredSelection)selection);
			
		// Instantiates the wizard container with the wizard and opens it
		WizardDialog dialog = new WizardDialog( part.getSite().getShell(), wizard);
		dialog.create();
		dialog.open();
		
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

	@Override
	public void setActivePart(IAction action, IWorkbenchPart part) {
		this.part = part;
		
	}

}
