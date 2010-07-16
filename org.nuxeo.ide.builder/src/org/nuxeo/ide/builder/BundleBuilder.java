package org.nuxeo.ide.builder;

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

public class BundleBuilder extends IncrementalProjectBuilder  {

	public final static String BUILDER_ID = BundleBuilder.class.getCanonicalName();

	protected DotResourcesSyncher dotSyncher = DotResourcesSyncher.mainResourcesSyncher();

	@Override
	protected IProject[] build(int kind, Map args, IProgressMonitor monitor)
			throws CoreException {
		IProject project = getProject();
		switch(kind) {
		case AUTO_BUILD:
		case INCREMENTAL_BUILD:
			IResourceDelta delta = getDelta(project);
			if (dotSyncher.needsSynchronization(project, delta)) {
				dotSyncher.copyToResources(project, delta, monitor);
			}
			return new IProject[] { project };
		case FULL_BUILD:
			dotSyncher.eraseAndCopyToResources(project, monitor);
			return new IProject[] { project };
		case CLEAN_BUILD:
		    clean(monitor);
		    break;
		default:
		    return new IProject[] {};
		}
		return new IProject[] { project };
	}

	@Override
	protected void clean(IProgressMonitor monitor) throws CoreException {
		IProject project = getProject();
	    dotSyncher.eraseAndCopyFromResources(project, monitor);
	}
}
