package org.zerocouplage.zcstudio.newproject;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.EnumSet;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.preference.IPreferenceStore;
import org.zerocouplage.zcstudio.Activator;
import org.zerocouplage.zcstudio.preference.PreferenceConstants;

public class GetProjectLocation implements IHandler {
	// get values of preferences
	public static IPreferenceStore prefStore = Activator.getDefault()
			.getPreferenceStore();
	public static String ZCSDK = prefStore.getString(PreferenceConstants.ZCSDK);
	public static Boolean IsClientServeurMobile = prefStore
			.getBoolean(PreferenceConstants.IsClientServeurMobile);
	public static Boolean IsClientServeurDesktop = prefStore
			.getBoolean(PreferenceConstants.IsClientServeurDesktop);
	public static String JDK = prefStore
			.getString(PreferenceConstants.ZCDesktop);
	public static String ZCAndroid = prefStore
			.getString(PreferenceConstants.ZCMobile);
	public static String tomcat = prefStore
			.getString(PreferenceConstants.ZCWeb);

	// copy an example project from the SDK to the workspace and rename it
	public void copyExampleToWorkspace(String projectName,
			String selectedProject) throws IOException {

		// work space location
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		File workspaceDirectory = workspace.getRoot().getLocation().toFile();

		// copy the existing project example from SDK to the current workspace
		java.nio.file.Path source = Paths.get(ZCSDK + "\\examples\\"
				+ selectedProject);
		java.nio.file.Path target = Paths.get(workspaceDirectory + "\\"
				+ projectName);
		Files.walkFileTree(source, EnumSet.of(FileVisitOption.FOLLOW_LINKS),
				Integer.MAX_VALUE, new CopyDirectory(source, target));
	}

	@Override
	public void addHandlerListener(IHandlerListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public Object execute(ExecutionEvent arg0) throws ExecutionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isHandled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeHandlerListener(IHandlerListener arg0) {
		// TODO Auto-generated method stub

	}
}