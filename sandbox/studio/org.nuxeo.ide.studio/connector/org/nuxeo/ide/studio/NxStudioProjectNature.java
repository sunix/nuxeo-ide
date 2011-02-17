package org.nuxeo.ide.studio;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.nuxeo.ide.studio.NxStudioConstants;

public class NxStudioProjectNature implements IProjectNature {

    protected IProject project;
    
    @Override
    public void configure() throws CoreException {
        IJavaProject java = JavaCore.create(project);
        List<IClasspathEntry> cp = Arrays.asList(java.getRawClasspath());        
        final Path p = new Path(NxStudioConstants.CLASSPATH_CONTAINER_ID);
        cp.add(JavaCore.newContainerEntry(p));
        java.setRawClasspath(cp.toArray(new IClasspathEntry[cp.size()]), null);
    }

    @Override
    public void deconfigure() throws CoreException {
        IJavaProject java = JavaCore.create(project);
        List<IClasspathEntry> cp = Arrays.asList(java.getRawClasspath());        
        final Path p = new Path(NxStudioConstants.CLASSPATH_CONTAINER_ID);
        cp.remove(p);
        java.setRawClasspath(cp.toArray(new IClasspathEntry[cp.size()]), null);
    }

    @Override
    public IProject getProject() {
        return project;
    }

    @Override
    public void setProject(IProject p) {
       project = p;
    }

}
