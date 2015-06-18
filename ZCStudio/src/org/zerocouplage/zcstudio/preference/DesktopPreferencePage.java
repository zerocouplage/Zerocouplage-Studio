package org.zerocouplage.zcstudio.preference;


import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.zerocouplage.zcstudio.Activator;

 

public class DesktopPreferencePage  extends FieldEditorPreferencePage implements
IWorkbenchPreferencePage {

public DesktopPreferencePage () {
super(GRID);

}

public void createFieldEditors() {
addField(new DirectoryFieldEditor(PreferenceConstants.ZCDesktop, "&JDK Location:",
    getFieldEditorParent()));
addField(new BooleanFieldEditor(PreferenceConstants.IsClientServeurDesktop,
        "&Application Client/Serveur", getFieldEditorParent()));
}
          



@Override
public void init(IWorkbench workbench) {
setPreferenceStore(Activator.getDefault().getPreferenceStore());
setDescription("Ajouter la location de votre JDK");
}
} 
