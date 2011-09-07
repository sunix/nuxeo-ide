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
package org.nuxeo.ide.connect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.QualifiedName;
import org.nuxeo.ide.common.StringUtils;
import org.nuxeo.ide.connect.studio.StudioProject;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class StudioProjectBinding implements IResourceChangeListener {

    private static QualifiedName STUDIO_BINDING_P = new QualifiedName(
            "org.nuxeo.ide", "studio.binding");

    public static void unbind(IProject project) throws CoreException {
        // ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
        project.setPersistentProperty(STUDIO_BINDING_P, null);
        project.setSessionProperty(STUDIO_BINDING_P, null);
    }

    public static StudioProjectBinding get(IProject project)
            throws CoreException {
        StudioProjectBinding binding = (StudioProjectBinding) project.getSessionProperty(STUDIO_BINDING_P);
        if (binding == null) {
            String listRef = project.getPersistentProperty(STUDIO_BINDING_P);
            if (listRef != null) {
                String[] ar = StringUtils.split(listRef, ',');
                binding = new StudioProjectBinding(ar);
                project.setSessionProperty(STUDIO_BINDING_P, binding);
                binding.projectPath = project.getFullPath();
                // ResourcesPlugin.getWorkspace().addResourceChangeListener(binding);
            }
        }
        return binding;
    }

    protected IPath projectPath;

    protected String[] projectIds;

    /**
     * Cache of schema paths.
     */
    private volatile String[] xpaths;

    public StudioProjectBinding(String... projectIds) {
        this.projectIds = projectIds;
    }

    public void bind(IProject project) throws CoreException {
        if (projectIds.length == 0) {
            unbind(project);
        } else {
            project.setPersistentProperty(STUDIO_BINDING_P,
                    StringUtils.join(projectIds, ','));
            project.setSessionProperty(STUDIO_BINDING_P, this);
        }
    }

    public IPath getProjectPath() {
        return projectPath;
    }

    public IProject getProject() {
        if (projectPath == null) {
            return null;
        }
        return ResourcesPlugin.getWorkspace().getRoot().getProject(
                projectPath.lastSegment());
    }

    public String[] getProjectIds() {
        return projectIds;
    }

    public StudioProject[] getProjects() throws Exception {
        ArrayList<StudioProject> projects = new ArrayList<StudioProject>(
                projectIds.length);
        HashSet<String> set = new HashSet<String>();
        for (String pid : projectIds) {
            set.add(pid);
        }
        StudioProject[] allProjects = ConnectPlugin.getStudioProvider().getProjects();
        for (StudioProject project : allProjects) {
            if (set.contains(project.getId())) {
                projects.add(project);
            }
        }
        return projects.toArray(new StudioProject[projects.size()]);
    }

    public String[] xpaths() {
        String[] _xpaths = xpaths;
        if (_xpaths == null) {
            synchronized (this) {
                if (xpaths == null) {
                    HashSet<String> result = new HashSet<String>();
                    collectXPaths(result);
                    xpaths = result.toArray(new String[result.size()]);
                    Arrays.sort(xpaths);
                }
                _xpaths = xpaths;
            }
        }
        return _xpaths;
    }

    private void collectXPaths(Set<String> result) {
        // TODO collect xpaths
    }

    public String[] getSchemaPaths() {
        return xpaths();
    }

    @Override
    public void resourceChanged(IResourceChangeEvent event) {
        if (projectPath != null) {
            if (projectPath.equals(event.getResource().getFullPath())) {
                int type = event.getType();
                if (type == IResourceChangeEvent.PRE_CLOSE
                        || type == IResourceChangeEvent.PRE_DELETE) {
                    dispose();
                }
            }
        }
    }

    public void dispose() {
        ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
        projectIds = null;
        projectPath = null;
        xpaths = null;
    }

}
