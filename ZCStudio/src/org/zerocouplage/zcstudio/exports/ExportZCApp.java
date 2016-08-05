package org.zerocouplage.zcstudio.exports;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;

/**
 * ExportZCApp
 * @author najlae
 *The class associated with export Wizard
 *initalises the wizard
 *add pages to it
 *say when you can finish
 *To be done in next versions: Associate this class with an ANT script to export projects in different archive types
 */
public class ExportZCApp extends Wizard implements IWorkbenchWizard {

	private ExampleValues values = new ExampleValues();
    private IWizardPage page1 = new ExampleWizardPage(values);
    private IWizardPage specialPage = new ExampleWizardPage(values);
	private IWorkbench workbench;
	protected IStructuredSelection selection;
	
	/**
	 * add multiple pages to the wizard
	 * page on click
	 */
    @Override
    public void addPages() {
        addPage(page1);
        addPage(specialPage);
    }
     /**
      * action associated with the click on Next button on the wizard
      */
    @Override
    public IWizardPage getNextPage(IWizardPage currentPage) {
        if (values.getValue().equals("special")) {
            return specialPage;
        }
        if (currentPage == page1) {
            return page1;
        }
        return null;
    }
    /**
     * boolean decides when it's Ok to finish
     */
	@Override
	public boolean performFinish() {
		// TODO Auto-generated method stub
		return true;
	}
	/**
	 * initialises exportwizard
	 */
	@Override
	public void init(IWorkbench arg0, IStructuredSelection arg1) {
		// TODO Auto-generated method stub
		this.workbench = workbench;
		this.selection = selection;
		
	}

}
