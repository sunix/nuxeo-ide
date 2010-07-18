package org.nuxeo.ide.manifests;

import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class ReformatManifestAction implements IObjectActionDelegate {

	ISelection selection;

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
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
			IFile file = null;
			if (element instanceof IFile) {
				file = (IFile) element;
			} else if (element instanceof IAdaptable) {
				file = (IFile) ((IAdaptable) element).getAdapter(IFile.class);
			}
			if (file == null) {
				continue;
			}
			if (!"MANIFEST.MF".equals(file.getName())) {
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
