package org.zerocouplage.zcstudio.shortcuts;

import org.eclipse.debug.ui.ILaunchShortcut;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;

public class zcdesktopAction implements ILaunchShortcut {

	public zcdesktopAction()  {

		System.out.println("Desktop App");
		// TODO Auto-generated constructor stub
	}


	@Override
	public void launch(ISelection arg0, String arg1) {
		// TODO Auto-generated method stub
		System.out.println("OK ZCDesktop");
		
	}

	@Override
	public void launch(IEditorPart arg0, String arg1) {
		// TODO Auto-generated method stub
		System.out.println("OK ZCDesktop");
		
	}



}
