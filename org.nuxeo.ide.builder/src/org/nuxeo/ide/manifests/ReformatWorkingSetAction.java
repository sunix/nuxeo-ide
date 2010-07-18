package org.nuxeo.ide.manifests;

import java.io.IOException;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.internal.WorkingSet;
import org.eclipse.ui.statushandlers.StatusManager;
import org.nuxeo.ide.Activator;

@SuppressWarnings("restriction")
public class ReformatWorkingSetAction implements IObjectActionDelegate {

	ISelection selection;

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void run(IAction action) {
		if (!(selection instanceof IStructuredSelection)) {
			return;
		}
		for (Iterator it = ((IStructuredSelection) selection).iterator(); it
				.hasNext();) {
			Object element = it.next();
			WorkingSet ws = null;
			if (element instanceof WorkingSet) {
				ws = (WorkingSet) element;
			} else if (element instanceof IAdaptable) {
				ws = (WorkingSet) ((IAdaptable) element)
						.getAdapter(WorkingSet.class);
			}
			if (ws == null) {
				continue;
			}
			for (IAdaptable child : ws.getElements()) {
				IProject project = (IProject) child.getAdapter(IProject.class);
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
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

}
