package org.zerocouplage.zcstudio.preference;


import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.jface.util.PropertyChangeEvent;

import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.zerocouplage.zcstudio.Activator;

 

public class MobilePreferencePage  extends FieldEditorPreferencePage implements
IWorkbenchPreferencePage {

public MobilePreferencePage () {
super(GRID);

}

private StringFieldEditor fieldEditor; 

public void createFieldEditors() {
addField(new DirectoryFieldEditor(PreferenceConstants.ZCMobile, "&Mobile SDK Location:",
    getFieldEditorParent()));
addField(new BooleanFieldEditor(PreferenceConstants.IsClientServeurMobile,
        "&Application Client/Serveur", getFieldEditorParent()));

}
//protected void checkState() {
//    super.checkState();
//    if(fieldEditor.getStringValue()!= null && !fieldEditor.getStringValue().equals("")){
//              setErrorMessage(null);
//          setValid(true);
//    }else{
//              setErrorMessage("Mobile SDK Location cannot be blank!");
//          setValid(false);
//    }
//}
//public void propertyChange(PropertyChangeEvent event) {
//    super.propertyChange(event);
//    if (event.getProperty().equals(FieldEditor.VALUE)) {
//              checkState();
//    }        
//}

@Override
public void init(IWorkbench workbench) {
setPreferenceStore(Activator.getDefault().getPreferenceStore());
setDescription("Ajouter la location du SDK Mobile");
}

} 
