package org.zerocouplage.zcstudio.shortcuts;

import org.eclipse.debug.ui.ILaunchShortcut;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.zerocouplage.zcstudio.webLauncherAction.LaunchWebApp;

public class zcwebAction implements ILaunchShortcut {

	String [] args;
	public zcwebAction()  {
		// TODO Auto-generated constructor stub
		System.out.println("Ok ZCWeb");
	}

	@Override
	public void launch(ISelection arg0, String arg1) {
		// TODO Auto-generated method stub
		System.out.println("Ok launch");
		LaunchWebApp.main(args);
		
	}

	@Override
	public void launch(IEditorPart arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

}
