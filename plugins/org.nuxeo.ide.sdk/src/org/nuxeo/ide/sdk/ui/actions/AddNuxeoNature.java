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
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.nuxeo.ide.common.AddNaturesAction;
import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.sdk.NuxeoSDK;
import org.nuxeo.ide.sdk.SDKRegistry;
import org.nuxeo.ide.sdk.java.ClasspathEditor;
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
        NuxeoSDK sdk = NuxeoSDK.getDefault();
        if (sdk == null) {
            UI.showError("Please configure the Nuxeo SDK to convert the project");
            return;
        }
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
        // Remove libraries
        editor.removeLibraries();
        // Add Nuxeo Containers
        List<String> containers = new LinkedList<String>();
        containers.add(SDKClassPathContainer.ID);
        containers.add(SDKClassPathContainer.ID_TESTS);
        editor.addContainers(containers);
        editor.flush();
        // removes classpath entries that exist in The SDK
        try {
            editor.removeDuplicates(containers);
            editor.flush();
        } catch (Exception e) {
            UI.showError("Errors occured while removing maven duplicates classpath entries", e, "Error cleaning duplicates entries");
        }

    }

}
