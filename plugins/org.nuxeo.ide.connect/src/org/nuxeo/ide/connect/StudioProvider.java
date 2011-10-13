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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ListenerList;
import org.nuxeo.ide.common.IOUtils;
import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.connect.studio.StudioProject;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class StudioProvider {
    
    protected File file;

    protected StudioProject[] projects;

    protected ListenerList listeners;

    protected BindingManager bindingManager;
    
    protected RepositoryManager repositoryManager;

    public StudioProvider(File root) {
        this.file = new File(root, "studio.projects");
        this.listeners = new ListenerList();
        repositoryManager = new RepositoryManager(root);
        bindingManager = new BindingManager(repositoryManager);
        addStudioListener(bindingManager);
        addStudioListener(repositoryManager);
        try {
            reload(false);
        } catch (Exception e) {
            UI.showError(
                    "Failed to load studio provider service. Nuxeo Studio integration will not work! ",
                    e);
            projects = new StudioProject[0];
        }
    }

    public void dispose() {
        repositoryManager.dispose();
        bindingManager.dispose();
        bindingManager = null;
        listeners = null;
        projects = null;
        file = null;
    }

    public void addStudioListener(IStudioListener listener) {
        listeners.add(listener);
    }

    public void removeStudioListener(IStudioListener listener) {
        listeners.remove(listener);
    }

    protected void fireStudioProjectsChanged() {
        for (Object o : listeners.getListeners()) {
            ((IStudioListener) o).handleProjectsUpdate(this);
        }
    }

    public void updateProjects(String json) throws Exception {
        IOUtils.writeFile(file, json);
        reload();
    }

    /**
     * Update the projects from the given input stream. The InputStream will be
     * closed.
     * 
     * @param in
     * @throws Exception
     */
    public void updateProjects(InputStream in) throws Exception {
        try {
            IOUtils.copyToFile(in, file, true);
        } finally {
            in.close();
        }
        reload();
    }

    public void reload() throws IOException {
        reload(true);
    }

    public void reload(boolean fireEvents) throws IOException {
        if (file.exists()) {
            FileInputStream in = new FileInputStream(file);
            List<StudioProject> result = StudioProject.readProjects(in);
            projects = result.toArray(new StudioProject[result.size()]);
            repositoryManager.reload();
        } else {
            projects = new StudioProject[0];
            repositoryManager.erase();
        }
        if (fireEvents) {
            fireStudioProjectsChanged();
        }
    }

    public BindingManager getBindingManager() {
        return bindingManager;
    }

    /**
     * Get the studio binding if exists. Returns null if not binding exists.
     * 
     * @param project
     * @return
     */
    public StudioProjectBinding getBinding(IProject project) {
        return bindingManager.getBinding(project);
    }

    /**
     * Bind the given project to a set of studio projects. Returns the binding.
     * <p>
     * If a binding already existed it will be removed and replaced by the new
     * binding. If the new binding is null an {@link IllegalArgumentException}
     * will be thrown.
     * 
     * @param project
     * @param studioProjects
     * @return
     */
    public StudioProjectBinding setBinding(IProject project,
            String... projectIds) {
        return bindingManager.setBinding(project, projectIds);
    }

    /**
     * Unbind a project from its studio projects if any.
     * 
     * @param project
     * @return
     */
    public void removeBinding(IProject project) throws CoreException {
        bindingManager.removeBinding(project);
    }

    public File getFile() {
        return file;
    }

    public StudioProject[] getProjects() {
        return projects;
    }

    public StudioProject getProject(String id) {
        for (StudioProject project : projects) {
            if (id.equals(project.getId())) {
                return project;
            }
        }
        return null;
    }

    public File[] getLibraries(IProject project) {
        StudioProjectBinding binding = getBinding(project);
        if (binding == null) {
            return new File[0];
        }
        String[] ids = binding.getProjectIds();
        List<File> files = new ArrayList<File>(ids.length);
        for (String id:ids) {
            files.add(repositoryManager.getFile(id));
        }
        return files.toArray(new File[files.size()]);
    }

}
