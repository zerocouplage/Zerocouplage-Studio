package org.zerocouplage.zcstudio.preference;




import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;

import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.zerocouplage.zcstudio.Activator;



 

public class MainPreferencePage  extends FieldEditorPreferencePage implements
IWorkbenchPreferencePage {

public MainPreferencePage () {
super(GRID);

}

public static final  String ZCSDK="ZCSDK_PATH";
private StringFieldEditor fieldEditor; 
public void createFieldEditors() {
addField(new DirectoryFieldEditor(ZCSDK, "&Mobile SDK Location:",
    getFieldEditorParent()));

}
//protected void checkState() {
//    super.checkState();
//    if(fieldEditor.getStringValue()!= null && !fieldEditor.getStringValue().equals("")){
//              setErrorMessage(null);
//          setValid(true);
//    }else{
//              setErrorMessage("ZC SDK Location cannot be blank!");
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
setDescription("Ajouter la location du SDK du Framework ZeroCouplage");
}
} 
