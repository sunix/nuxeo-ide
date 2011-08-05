/*
 * (C) Copyright 2006-2010 Nuxeo SAS (http://nuxeo.com/) and contributors.
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
 *     bstefanescu
 */
package org.nuxeo.dev.ide.launcher;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.URIUtil;
import org.eclipse.jdt.core.IJavaModel;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class JdtHelper {

    public static IJavaModel getJavaModel() {
        return JavaCore.create(ResourcesPlugin.getWorkspace().getRoot());
    }

    public static IJavaProject getJavaProject(String name) {
        if (name == null || name.trim().length() < 1) {
            return null;
        }

        IJavaProject javaProject = getJavaModel().getJavaProject(name);

        if (javaProject == null || !javaProject.exists()) {
            return null;
        }
        return javaProject;

    }

    public static Set<IJavaProject> getDependencyProjects(IJavaProject project)
            throws JavaModelException {
        HashSet<IJavaProject> result = new HashSet<IJavaProject>();
        collectDependencyProjects(project, result);
        return result;
    }

    public static void collectDependencyProjects(IJavaProject project,
            Set<IJavaProject> projects) throws JavaModelException {
        for (String name : project.getRequiredProjectNames()) {
            IJavaProject p = getJavaProject(name);
            if (p != null) {
                projects.add(p);
                collectDependencyProjects(p, projects);
            }
        }
    }

    public static Set<File> getOutputDirectories(IJavaProject project)
            throws JavaModelException {
        HashSet<File> result = new HashSet<File>();
        collectOutputDirectories(project, result);
        return result;
    }

    /**
     * 
     * @param project
     * @param files
     * @throws JavaModelException
     */
    public static void collectOutputDirectories(IJavaProject project,
            Set<File> files) throws JavaModelException {
        File file = getBuildDirectory(project);
        if (file != null) {
            files.add(file);
        }
        for (String name : project.getRequiredProjectNames()) {
            IJavaProject p = getJavaProject(name);
            if (p != null) {
                collectOutputDirectories(p, files);
            }
        }
    }

    /**
     * Only the default output location is returned. Per source package location
     * is not supported.
     * 
     * @param project
     * @return
     */
    public static File getBuildDirectory(IJavaProject project)
            throws JavaModelException {
        IPath path = project.getOutputLocation();
        if (path == null) {
            return null;
        }
        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        IResource resource = root.findMember(path);
        if (resource != null) {
            return URIUtil.toFile(resource.getRawLocationURI());
        }
        return null;
    }

}
