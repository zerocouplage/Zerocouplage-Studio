package org.zerocouplage.zcstudio.exports;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
/**
 * ExampleWizardPage
 * @author najlae
 *creates a single page to the export wizard
 */
public class ExampleWizardPage extends WizardPage {

	private ExampleValues values;
    private Text text;
    Text archiveNameText;
    Button serverClientApp;

/**
 * constructor
 * @param values
 * sets the title and the description of the page in question
 */
    public ExampleWizardPage(ExampleValues values) {
        super("wizardPage");
        setTitle("Name the archive");
        setDescription("The name of the archive");
        this.values = values;
    }

/**
 * creates the components of the page
 */
	public void createControl(Composite parent) {
	    GridData gd;
		Composite composite =  new Composite(parent, SWT.NULL);
		
		GridLayout gl = new GridLayout();
		int ncol = 2;
		gl.numColumns = ncol;
		composite.setLayout(gl);
		
		
        text = new Text(parent, SWT.BORDER);
        setControl(text);


        new Label (composite, SWT.NONE).setText("Archive Name:");				
		archiveNameText = new Text(composite, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = ncol - 1;
		archiveNameText.setLayoutData(gd);

		createLine(composite, ncol);
        createLine(composite, ncol);
		
		serverClientApp = new Button(composite, SWT.RADIO);
		serverClientApp.setText("Is a Client Server Application");
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = ncol;
		serverClientApp.setLayoutData(gd);
		serverClientApp.setSelection(true);
		
        text.addModifyListener(new ModifyListener() {

            @Override
            public void modifyText(ModifyEvent e) {
                values.setValue(archiveNameText.getText());
            }

        });
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible) {
            text.setText(values.getValue());
        }
    }
    
    private void createLine(Composite parent, int ncol) 
	{
		Label line = new Label(parent, SWT.SEPARATOR|SWT.HORIZONTAL|SWT.BOLD);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan = ncol;
		line.setLayoutData(gridData);
	}	

}