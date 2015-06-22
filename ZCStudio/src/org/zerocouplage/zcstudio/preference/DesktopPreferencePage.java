package org.zerocouplage.zcstudio.preference;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.zerocouplage.zcstudio.Activator;

public class DesktopPreferencePage extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage {
	public static final String copyright = "(c)Copyright 2015 ZCStudio";

	public DesktopPreferencePage() {
		super(GRID);

	}

	/**
	 * @see org.eclipse.jface.preference.FieldEditorPreferencePage#createFieldEditors()
	 *      this method add a field in desktop preference page to enter jdk
	 *      location
	 */
	public void createFieldEditors() {
		addField(new DirectoryFieldEditor(PreferenceConstants.ZCDesktop,
				"&JDK Location:", getFieldEditorParent()));
		/**
		 * @see org.eclipse.jface.preference.FieldEditorPreferencePage#createFieldEditors()
		 *      add a field in desktop preference page to tell if it is a
		 *      client/server app
		 */
		addField(new BooleanFieldEditor(
				PreferenceConstants.IsClientServeurDesktop,
				"&Application Client/Serveur", getFieldEditorParent()));
	}

	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Ajouter la location de votre JDK");
	}
}
