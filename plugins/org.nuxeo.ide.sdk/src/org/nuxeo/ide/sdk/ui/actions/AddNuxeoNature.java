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
        super.install(project, natureId, monitor);
        createSourceFolders(project, monitor);
        applyClasspath(project, "classpath.xml", monitor);
    }

    protected void createSourceFolders(IProject project,
            IProgressMonitor monitor) throws CoreException {
        createSourceFolder(project, "src", monitor);
        createSourceFolder(project, "src/main", monitor);
        createSourceFolder(project, "src/test", monitor);
        createSourceFolder(project, "src/main/java", monitor);
        createSourceFolder(project, "src/main/resources", monitor);
        createSourceFolder(project, "src/test/java", monitor);
        createSourceFolder(project, "src/test/resources", monitor);
    }

    protected void createSourceFolder(IProject project, String path,
            IProgressMonitor monitor) throws CoreException {
        IFolder folder = project.getFolder(path);
        if (!folder.exists()) {
            folder.create(true, false, monitor);
        }
    }

    protected void applyClasspath(IProject project, String name,
            IProgressMonitor monitor) throws CoreException {
        ClasspathEditor editor = new ClasspathEditor(project);
        // Add Nuxeo Containers
        List<String> containers = new LinkedList<String>();
        containers.add(SDKClassPathContainer.ID);
        containers.add(SDKClassPathContainer.ID_TESTS);
        editor.addContainers(containers);
        editor.flush();
    }

}
