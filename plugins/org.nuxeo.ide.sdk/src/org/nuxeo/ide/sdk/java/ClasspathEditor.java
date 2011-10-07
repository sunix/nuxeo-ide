package org.nuxeo.ide.sdk.java;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;

/**
 * 
 * @author matic
 * @since 1.1
 */

public class ClasspathEditor {
    
    public ClasspathEditor(IProject project) throws JavaModelException {
        java = JavaCore.create(project);
        entries = Arrays.asList(java.getRawClasspath());
    }
    
    protected final IJavaProject java;

    protected final List<IClasspathEntry> entries;
    
    public boolean extendClasspath(String name)
            throws JavaModelException {
        IProject project = java.getProject();
        IFolder folder = project.getFolder("src/main/" + name);
        IPackageFragmentRoot root = java.getPackageFragmentRoot(folder);
        if (root.exists()) {
            return false;
        }
        // extend project class path
        IFolder binFolder = project.getFolder("bin/" + name);
        IClasspathEntry newEntry = JavaCore.newSourceEntry(folder.getFullPath(),
                new IPath[0], new IPath[0], binFolder.getFullPath());
        entries.add(newEntry);
        return true;
    }

    public void flush() throws JavaModelException {
        java.setRawClasspath(entries.toArray(new IClasspathEntry[entries.size()]), null);
    }
}
