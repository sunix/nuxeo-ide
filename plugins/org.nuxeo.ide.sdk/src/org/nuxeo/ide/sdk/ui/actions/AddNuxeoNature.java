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
 *     bstefanescu
 *     Vladimir Pasquier <vpasquier@nuxeo.com>
 */
package org.nuxeo.ide.sdk.ui.actions;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.nuxeo.ide.common.AddNaturesAction;
import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.sdk.SDKRegistry;
import org.nuxeo.ide.sdk.java.ClasspathEditor;
import org.nuxeo.ide.sdk.templates.Constants;
import org.nuxeo.ide.sdk.ui.NuxeoNature;
import org.nuxeo.ide.sdk.ui.SDKClassPathContainer;

/**
 * Fake add nature - used as an example
 * 
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class AddNuxeoNature extends AddNaturesAction {

    public AddNuxeoNature() {
        super(NuxeoNature.ID);
    }

    @Override
    public void install(IProject project, String natureId,
            IProgressMonitor monitor) throws CoreException {
        super.install(project, natureId, monitor);
        if (!SDKRegistry.getWorkspacePreferences().getBoolean(
                "useSDKClasspath", Boolean.TRUE))
            return;
        applyClasspath(project);
    }

    protected void createSourceFolder(IProject project, String path,
            IProgressMonitor monitor) throws CoreException {
        IFolder folder = project.getFolder(path);
        if (!folder.exists()) {
            folder.create(true, false, monitor);
        }
    }

    protected void applyClasspath(IProject project) throws CoreException {
        ClasspathEditor editor = new ClasspathEditor(project);
        // Add Nuxeo Containers
        List<String> containers = new LinkedList<String>();
        containers.add(SDKClassPathContainer.ID);
        containers.add(SDKClassPathContainer.ID_TESTS);
        editor.addContainers(containers);
        editor.flush();
        // Add Linked Resource for browsing the SDK
        CreateSDKLinkResource(project);
    }

    /**
     * Create SDK link resource for browsing it
     * 
     * @param project
     * @throws CoreException
     */
    public void CreateSDKLinkResource(IProject project) throws CoreException {
        try {
            IWorkspace workspace = ResourcesPlugin.getWorkspace();
            IFolder sdkLink = project.getFolder(Constants.NXSDK_BROWSER_LINK_FOLDER);
            IPath location = new Path(Constants.NXSDK_BROWSER_LINK_FOLDER);
            // Recreate linked resource if exists (in case of updating the SDK)
            if (sdkLink.isLinked()) {
                sdkLink.delete(true, null);
            }
            if (workspace.validateLinkLocation(sdkLink, location).isOK()) {
                sdkLink.createLink(location, IResource.DERIVED, null);
            }
        } catch (Exception e) {
            UI.showError("Unable to create link resource for sdk because of "
                    + e);
        }
    }
}
