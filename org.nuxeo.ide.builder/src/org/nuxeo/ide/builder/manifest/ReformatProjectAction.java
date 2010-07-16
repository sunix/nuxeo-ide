package org.nuxeo.ide.builder.manifest;

import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class ReformatProjectAction implements
		IObjectActionDelegate {

	ISelection selection;

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		;
	}
	
	@SuppressWarnings({ "unchecked" })
	@Override
	public void run(IAction action) {
		if (!(selection instanceof IStructuredSelection)) {
			return;
		}

		for (Iterator it = ((IStructuredSelection) selection).iterator(); it
				.hasNext();) {
			Object element = it.next();
			IProject project = null;
			if (element instanceof IProject) {
				project = (IProject) element;
			} else if (element instanceof IAdaptable) {
				project = (IProject) ((IAdaptable) element)
						.getAdapter(IProject.class);
			}
			if (project == null) {
				continue;
			}
			IFile file = project.getFile(new Path("META-INF/MANIFEST.MF"));
			if (!file.exists()) {
				continue;
			}
			new ReformatManifestRunner().process(file);
		}
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

}
