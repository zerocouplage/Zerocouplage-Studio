package org.zerocouplage.zcstudio.preference;

import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.zerocouplage.zcstudio.Activator;

public class MainPreferencePage extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage {
	public static final String copyright = "(c)Copyright 2015 ZCStudio";

	public MainPreferencePage() {
		super(GRID);

	}

	/**
	 * @see org.eclipse.jface.preference.FieldEditorPreferencePage#createFieldEditors()
	 *      this method add a field in desktop preference page to enter ZCSDK
	 *      location
	 */
	public void createFieldEditors() {
		addField(new DirectoryFieldEditor(PreferenceConstants.ZCSDK,
				"&ZCSDK Location:", getFieldEditorParent()));

	}

	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Ajouter la location du SDK du Framework ZeroCouplage");
	}
}
