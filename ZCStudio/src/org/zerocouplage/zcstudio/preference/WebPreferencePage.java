package org.zerocouplage.zcstudio.preference;


import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.zerocouplage.zcstudio.Activator;
public class WebPreferencePage  extends FieldEditorPreferencePage implements
IWorkbenchPreferencePage {
public WebPreferencePage () {
super(GRID);

}



public void createFieldEditors() {
addField(new DirectoryFieldEditor(PreferenceConstants.ZCWeb, "&tomcat Location:",
    getFieldEditorParent()));

}


@Override
public void init(IWorkbench workbench) {
setPreferenceStore(Activator.getDefault().getPreferenceStore());
setDescription("Ajouter la location du serveur tomcat");

}
} 
