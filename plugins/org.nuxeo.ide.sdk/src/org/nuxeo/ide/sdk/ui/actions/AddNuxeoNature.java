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
package org.nuxeo.ide.sdk.ui.actions;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.nuxeo.ide.common.AddNaturesAction;
import org.nuxeo.ide.sdk.ui.NuxeoNature;

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
        IFile cp = project.getFile(".classpath");
        InputStream in = getClass().getResourceAsStream(name);
        if (in != null) {
            try {
                if (!cp.exists()) {
                    cp.create(in, true, new NullProgressMonitor());
                } else {
                    cp.setContents(in, true, true, new NullProgressMonitor());
                }
            } finally {
                try {
                    in.close();
                } catch (IOException e) {
                    // do nothing
                }
            }
        }
    }

}
