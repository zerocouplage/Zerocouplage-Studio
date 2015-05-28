package org.zerocouplage.zcstudio.preference;


import org.eclipse.jface.preference.*;
import org.eclipse.jface.util.PropertyChangeEvent;

import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.zerocouplage.zcstudio.Activator;

 

public class DesktopPreferencePage  extends FieldEditorPreferencePage implements
IWorkbenchPreferencePage {

public DesktopPreferencePage () {
super(GRID);

}
public static final  String ZCDesktopDirectory="JDK_PATH";
public static final  String IsClientServeur="IsClientServeur";
private StringFieldEditor fieldEditor; 

public void createFieldEditors() {
addField(new DirectoryFieldEditor(ZCDesktopDirectory, "&JDK Location:",
    getFieldEditorParent()));
addField(new BooleanFieldEditor(IsClientServeur,
        "&Application Client/Serveur", getFieldEditorParent()));
}
//protected void checkState() {
//    super.checkState();
//    if(fieldEditor.getStringValue()!= null && !fieldEditor.getStringValue().equals("")){
//              setErrorMessage(null);
//          setValid(true);
//    }else{
//              setErrorMessage("JDK Location cannot be blank!");
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
setDescription("Ajouter la location de votre JDK");
}
} 
