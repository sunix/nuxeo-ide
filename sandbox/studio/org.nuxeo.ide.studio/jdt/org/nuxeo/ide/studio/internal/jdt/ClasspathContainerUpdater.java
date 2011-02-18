package org.nuxeo.ide.studio.internal.jdt;

import java.util.Arrays;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.ui.statushandlers.StatusManager;
import org.nuxeo.ide.studio.StudioConstants;

public class ClasspathContainerUpdater {
    
    public ClasspathContainerUpdater(String name, IProgressMonitor monitor) {
        this.name = name;
        this.monitor = monitor;
    }
    
    protected final String name;
    protected final IProgressMonitor monitor;
    
    public void refreshWorkspace() {
        IWorkspace ws = ResourcesPlugin.getWorkspace();
        for (IProject prj:Arrays.asList(ws.getRoot().getProjects())) {
            IJavaProject java = JavaCore.create(prj);
            if (java == null) {
                continue;
            }
            try {
                refreshClasspath(java, java.getRawClasspath());
            } catch (JavaModelException e) {
                StatusManager.getManager().handle(e, StudioConstants.PLUGIN_ID);
            }
        }
    }

    protected void refreshClasspath(IJavaProject ctx, IClasspathEntry[] entries) throws JavaModelException {
        IPath containerPath = new Path(StudioConstants.CLASSPATH_CONTAINER_ID);
        for (IClasspathEntry entry:entries) {
            if (!containerPath.equals(entry.getPath())) {
                continue;
            }
            IProject prj = ctx.getProject();
            try {
                prj.refreshLocal(0, null); // TODO refresh only referencing projets
            } catch (CoreException e) {
                throw new Error("Cannot refresh " + prj.getName());
            }
            // refreshClasspathContainer(ctx, JavaCore.getClasspathContainer(entry.getPath(), ctx));            
        }
    }
    
    protected void refreshClasspathContainer(IJavaProject ctx, IClasspathContainer cont) {
        IClasspathEntry[] entries = cont.getClasspathEntries();
        for (IClasspathEntry entry:entries) {
            IPath path = entry.getPath();
            if (!name.equals(path.lastSegment())) {
                continue;
            }
            try {
                ctx.getProject().refreshLocal(0, null);
            } catch (CoreException e) {
                StatusManager.getManager().handle(e, StudioConstants.PLUGIN_ID);
            } finally {
                if (monitor != null) {
                    monitor.worked(1);                
                }
            }
        }
    }
}
