package org.nuxeo.ide.builder.manifest;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.statushandlers.StatusManager;
import org.nuxeo.ide.builder.Activator;

public class ReformatManifestRunner {
	
	ManifestFormater formater = new ManifestFormater();
	
	public void process(final IFile mf) {
		IWorkspaceRunnable runnable = new IWorkspaceRunnable() {
			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				try {
					formater.format(mf.getLocation().toFile());
				} catch (IOException e) {
					IStatus error = new Status(IStatus.ERROR,
							Activator.PLUGIN_ID, "Cannot format", e);
					StatusManager.getManager()
							.handle(error, StatusManager.SHOW);
				}
				mf.touch(monitor);
			}
		};
		try {
			ResourcesPlugin.getWorkspace().run(runnable, null);
		} catch (CoreException e) {
			StatusManager.getManager().handle(e, Activator.PLUGIN_ID);
		}
	}
	
}
