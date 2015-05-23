package zcstudio.shortcuts;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.debug.ui.ILaunchShortcut;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

public class zcdesktopAction implements ILaunchShortcut {

	public zcdesktopAction()  {
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
