package org.zerocouplage.zcstudio.preference.handler;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;
import org.zerocouplage.zcstudio.*;
import org.zerocouplage.zcstudio.preference.PreferenceConstants;
public class ValeursPreferencesHandler implements IHandler {
@Override
public void addHandlerListener(IHandlerListener handlerListener) {
}
@Override
public void dispose() {
// TODO Auto-generated method stub
}
@Override
public Object execute(ExecutionEvent event) throws ExecutionException {
IPreferenceStore prefStore = Activator.getDefault().getPreferenceStore();

String ZCSDK= prefStore.getString(PreferenceConstants.ZCSDK);
Boolean IsClientServeurMobile=prefStore.getBoolean(PreferenceConstants.IsClientServeurMobile);
Boolean IsClientServeurDesktop=prefStore.getBoolean(PreferenceConstants.IsClientServeurDesktop);
String JDK= prefStore.getString(PreferenceConstants.ZCDesktop);
String ZCAndroid= prefStore.getString(PreferenceConstants.ZCMobile);
String tomcat= prefStore.getString(PreferenceConstants.ZCWeb);

return null; }
@Override
public boolean isEnabled() {
// TODO Auto-generated method stub
return true; }
@Override
public boolean isHandled() {
// TODO Auto-generated method stub
return true; }
@Override
public void removeHandlerListener(IHandlerListener handlerListener) {
// TODO Auto-generated method stub
}
}
