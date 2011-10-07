/*
 * (C) Copyright 2006-2011 Nuxeo SAS (http://nuxeo.com/) and contributors.
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
 */
package org.nuxeo.ide.sdk.server;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.internal.preferences.Base64;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.nuxeo.ide.common.IOUtils;
import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.sdk.DeploymentChangedListener;
import org.nuxeo.ide.sdk.NuxeoSDK;
import org.nuxeo.ide.sdk.SDKPlugin;
import org.nuxeo.ide.sdk.deploy.Deployment;
import org.nuxeo.ide.sdk.java.ClasspathEditor;
import org.nuxeo.ide.sdk.ui.NuxeoNature;

/**
 * 
 * @author matic
 * @since 1.1
 */
public class SeamHotReloader implements DeploymentChangedListener,
        IResourceChangeListener {

    @Override
    public void resourceChanged(IResourceChangeEvent event) {
        IResourceDelta delta = event.getDelta();
        if (delta == null) {
            return;
        }
        try {
            delta.accept(new IResourceDeltaVisitor() {

                @Override
                public boolean visit(@SuppressWarnings("hiding") IResourceDelta delta) throws CoreException {
                    IResource resource = delta.getResource();
                    if (resource.getType() == IResource.ROOT) {
                        return true;
                    }
                    int flags = delta.getFlags();
                    if ((flags & IResourceDelta.OPEN) == 0) {
                        return false;
                    }
                    final IProject project = (IProject) resource;
                    if (project.getNature(NuxeoNature.ID) == null) {
                        return false;
                    }
                    IFolder seamSource = project.getFolder("src/main/seam");
                    if (!seamSource.exists()) {
                        return false;
                    }

                    final ClasspathEditor editor = new ClasspathEditor(project);
                    
                    WorkspaceJob job = new WorkspaceJob("set seam classpath") {
                        
                        @Override
                        public IStatus runInWorkspace(IProgressMonitor monitor)
                                throws CoreException {
                            editor.extendClasspath("seam");
                            editor.extendClasspath("i18n");
                            editor.flush();
                            return new Status(IStatus.OK, SDKPlugin.PLUGIN_ID, "seam classpath set on " + project.getName());
                        }
                    };
                    
                    job.schedule();

                    return false;
                }
            });
        } catch (CoreException e) {
            UI.showError("Cannot visit delta", e);
        }
    }

    @Override
    public void deploymentChanged(NuxeoSDK sdk, Deployment deployment) {
        Map<String, List<File>> i18nFiles = new HashMap<String, List<File>>();
        // set target
        File targetWeb = new File(sdk.getInstallDirectory(), "nxserver");
        File targetBinaries = new File(targetWeb, "nuxeo.war/WEB-INF/dev");

        IOUtils.deleteTree(targetBinaries);
        targetBinaries.mkdir();

        // visit projects
        for (IProject project : deployment.getProjects()) {
            try {
                IJavaProject java = JavaCore.create(project);
                copyBinaries(java, targetBinaries);
                copyWebFiles(java, targetWeb);
                collectI18N(java, targetWeb, i18nFiles);
            } catch (Exception e) {
                UI.showError(
                        "Cannot synch seam components of " + project.getName()
                                + " to " + sdk.getLocation(), e);
            }
        }

        // append i18n resource bundles
        try {
            appendI18N(i18nFiles, targetWeb);
        } catch (Exception e) {
            UI.showError("Cannot append i18n resource bundles", e);
        }

        // ask server for reloading
        try {
            postSeamReload(sdk);
        } catch (IOException e) {
            UI.showError("Cannot request seam reload", e);
        }
    }

    protected void copyBinaries(IJavaProject java, File target)
            throws CoreException, IOException {
        IProject project = java.getProject();
        IFolder source = project.getFolder("src/main/seam");
        IPackageFragmentRoot root = java.getPackageFragmentRoot(source);
        if (root == null || !root.exists()) {
            return; // no seam components
        }
        IClasspathEntry cpe = root.getRawClasspathEntry();
        IPath binPath = cpe.getOutputLocation();
        IFolder binFolder = project.getParent().getFolder(binPath);
        for (IResource m : binFolder.members()) {
            IOUtils.copyTree(m.getRawLocation().toFile(), target);
        }
    }

    protected void copyWebFiles(IJavaProject java, File target)
            throws CoreException, IOException {
        IFolder web = java.getProject().getFolder("src/main/resources/web");
        if (!web.exists()) {
            return; // no web files
        }
        for (IResource m : web.members()) {
            IOUtils.copyTree(m.getRawLocation().toFile(), target);
        }
    }

    protected void collectI18N(IJavaProject java, File target,
            Map<String, List<File>> i18nFiles) throws CoreException,
            IOException {
        IFolder i18n = java.getProject().getFolder(
                "src/main/i18n/web/nuxeo.war/WEB-INF/classes");
        if (!i18n.exists()) {
            return; // no i18n resources bundles
        }
        for (IResource m : i18n.members()) {
            File contribution = m.getRawLocation().toFile();
            String name = contribution.getName();
            if (!i18nFiles.containsKey(name)) {
                i18nFiles.put(name, new ArrayList<File>());
            }
            i18nFiles.get(name).add(contribution);
        }
    }

    protected void appendI18N(Map<String, List<File>> i18nfiles, File target)
            throws IOException {
        File i18n = new File(target, "nuxeo.war/WEB-INF/classes");
        for (String name : i18nfiles.keySet()) {
            File original = new File(i18n, name);
            File backup = new File(i18n, name + "~bak");
            if (!backup.exists()) {
                IOUtils.copyFile(original, backup);
            }
            IOUtils.copyFile(backup, original);
            for (File file : i18nfiles.get(name)) {
                IOUtils.appendFile(original, file);
            }
        }
    }

    protected void postSeamReload(NuxeoSDK sdk) throws IOException {
        URL location = sdk.getRemoteLocation("restAPI/seamReload");
        HttpURLConnection connection = (HttpURLConnection) location.openConnection();
        String authorization = new String(
                Base64.encode("Administrator:Administrator".getBytes()));
        connection.setRequestProperty("Authorization", "Basic " + authorization);
        connection.setRequestMethod("POST");
        connection.getResponseCode();
    }

}
