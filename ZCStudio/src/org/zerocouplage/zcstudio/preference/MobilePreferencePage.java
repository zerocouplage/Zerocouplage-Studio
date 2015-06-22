package org.zerocouplage.zcstudio.preference;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.zerocouplage.zcstudio.Activator;

public class MobilePreferencePage extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage {
	public static final String copyright = "(c)Copyright 2015 ZCStudio";

	public MobilePreferencePage() {
		super(GRID);

	}

	/**
	 * @see org.eclipse.jface.preference.FieldEditorPreferencePage#createFieldEditors()
	 *      this method add a field in desktop preference page to enter SDK
	 *      Mobile location
	 */

	public void createFieldEditors() {
		addField(new DirectoryFieldEditor(PreferenceConstants.ZCMobile,
				"&Mobile SDK Location:", getFieldEditorParent()));
		addField(new BooleanFieldEditor(
				PreferenceConstants.IsClientServeurMobile,
				"&Application Client/Serveur", getFieldEditorParent()));

	}

	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Ajouter la location du SDK Mobile");
	}

}
