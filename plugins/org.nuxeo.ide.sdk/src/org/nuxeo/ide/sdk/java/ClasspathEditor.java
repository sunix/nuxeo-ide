package org.nuxeo.ide.sdk.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.core.ClasspathEntry;

/**
 * 
 * @author matic
 * @since 1.1
 */

public class ClasspathEditor {

    public ClasspathEditor(IProject project) throws JavaModelException {
        java = JavaCore.create(project);
        entries.addAll(Arrays.asList(java.getRawClasspath()));
    }

    protected final IJavaProject java;

    protected final List<IClasspathEntry> entries = new ArrayList<IClasspathEntry>();

    boolean dirty = false;

    public void extendClasspath(String name) throws JavaModelException {
        IProject project = java.getProject();
        IFolder folder = project.getFolder("src/main/" + name);
        IPackageFragmentRoot root = java.getPackageFragmentRoot(folder);
        if (root.exists()) {
            IClasspathEntry entry = root.getRawClasspathEntry();
            if (entry.getOutputLocation() != null) {
                return;
            }
            entries.remove(entry);
        }
        // extend project class path
        IFolder binFolder = project.getFolder("bin/" + name);
        IClasspathEntry newEntry = JavaCore.newSourceEntry(
                folder.getFullPath(), new IPath[0], new IPath[0],
                binFolder.getFullPath());
        entries.add(newEntry);
        dirty = true;
    }

    public void addLibrary(IPath path) {
        IClasspathEntry newEntry = JavaCore.newLibraryEntry(path, null, null);
        entries.add(newEntry);
        dirty = true;
    }

    public void removeLibrary(Path path) {
        Iterator<IClasspathEntry> it = entries.iterator();
        while (it.hasNext()) {
            IClasspathEntry entry = it.next();
            if (path.equals(entry.getPath())) {
                it.remove();
                dirty = true;
            }
        }
    }

    public void flush() throws JavaModelException {
        if (dirty) {
            java.setRawClasspath(
                    entries.toArray(new IClasspathEntry[entries.size()]), null);
        }
        dirty = false;
    }

}
