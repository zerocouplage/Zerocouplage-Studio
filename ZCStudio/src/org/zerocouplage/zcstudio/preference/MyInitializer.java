package org.zerocouplage.zcstudio.preference;



import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;

import org.eclipse.jface.preference.IPreferenceStore;
import org.zerocouplage.zcstudio.Activator;




public class MyInitializer extends AbstractPreferenceInitializer {

  public MyInitializer() {
  }
  //IPreferenceStore store = Plugin.getPlugin().getPreferenceStore();

  @Override
  public void initializeDefaultPreferences()  {
	  IPreferenceStore store = Activator.getDefault().getPreferenceStore();
store.setDefault(MainPreferencePage.ZCSDK,"C:/ProgramFiles/ZCSDK");
store.setDefault(WebPreferencePage.ZCWeb,"C:/ProgramFiles/ZCSDK");
store.setDefault(DesktopPreferencePage.ZCDesktopDirectory,"C:/ProgramFiles/ZCSDK");
store.setDefault(MobilePreferencePage.ZCMobile,"C:/ProgramFiles/ZCSDK");
}}
 