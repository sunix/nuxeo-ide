/*
 * (C) Copyright 2006-2012 Nuxeo SAS (http://nuxeo.com/) and contributors.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * Contributors:
 *     slacoin
 *     Vladimir Pasquier <vpasquier@nuxeo.com>
 *     Sun Seng David TAN <stan@nuxeo.com>
 */
package org.nuxeo.ide.sdk.java;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IAccessRule;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.sdk.NuxeoSDK;
import org.nuxeo.ide.sdk.model.PomModel;

/**
 *
 * @author matic
 * @since 1.1
 */
public class ClasspathEditor {

    public ClasspathEditor(IProject project) throws JavaModelException {
        this.project = project;
        java = JavaCore.create(project);
        entries.addAll(Arrays.asList(java.getRawClasspath()));
    }

    protected final IJavaProject java;

    protected final IProject project;

    protected final List<IClasspathEntry> entries = new ArrayList<IClasspathEntry>();

    boolean dirty = false;

    /**
     * Extends classpath target project with src folder
     *
     * @param name
     * @throws JavaModelException
     */
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

    /**
     * Adding containers to the project classpath
     *
     * @param containers
     * @throws JavaModelException
     */
    public void addContainers(List<String> containers)
            throws JavaModelException {
        for (String container : containers) {
            IClasspathEntry classPathEntry = JavaCore.newContainerEntry(
                    new Path(container), new IAccessRule[0], null, false);
            entries.add(classPathEntry);
        }
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

    /**
     * Removing containers to the project classpath
     *
     * @param containers
     * @throws JavaModelException
     */
    public void removeContainers(List<String> containers) {
        for (String container : containers) {
            IClasspathEntry classPathEntry = JavaCore.newContainerEntry(
                    new Path(container), new IAccessRule[0], null, false);
            entries.remove(classPathEntry);
        }
        dirty = true;
    }

    /**
     * Removing classpath entries that are in already in the containers. This
     * method is intended to be called after a mvn eclipse:eclipse
     *
     * @param containers
     * @throws Exception
     */
    public void removeDuplicates(List<String> containers) throws Exception {
        // Get the classpath entries "lib"
        // get only the one that are in the m2libs
        // convert them as Dependency objects
        // check if they are part of the containers, if yes, remove
        Map<String, IClasspathEntry> mavenentries = new HashMap<String, IClasspathEntry>();
        for (IClasspathEntry iClasspathEntry : entries) {
            String libFileName = JavaCore.getResolvedClasspathEntry(
                    iClasspathEntry).getPath().toString();
            if (libFileName.endsWith(".jar")) {
                // checking if this is comming from the m2repository
                File pom = new File(libFileName.substring(0,
                        libFileName.length() - 3)
                        + "pom");
                if (pom.isFile()) {
                    try {
                        PomModel model = new PomModel(pom);
                        // mavendependencies.add(new Dependency(
                        mavenentries.put(
                                model.getGroupId() + ":"
                                        + model.getArtifactId() + ":"
                                        + model.getArtifactVersion(),
                                iClasspathEntry);
                    } catch (Exception e) {
                        UI.showError("Failed to parse associated pom", e);
                    }
                }
            }
        }

        Collection<String> artifactIndex = NuxeoSDK.getDefault().getArtifactIndex().getIndex().values();

        for (String indexArtifactEntry : artifactIndex) {
            // The index looks like
            // "artifactId:groupId:version:other:maven:info", get the index of
            // the third ':' character to match our key
            // "artifactId:groupId:version"
            int twoDotIndex = 0;
            for (int i = 0; i < 3; i++) {
                twoDotIndex = indexArtifactEntry.indexOf(':', twoDotIndex + 1);
            }
            CharSequence mavenid = indexArtifactEntry.subSequence(0,
                    twoDotIndex);

            // Removing duplicates
            if (mavenentries.containsKey(mavenid)) {
                entries.remove(mavenentries.get(mavenid));
                dirty = true;
            }
        }
    }

}
