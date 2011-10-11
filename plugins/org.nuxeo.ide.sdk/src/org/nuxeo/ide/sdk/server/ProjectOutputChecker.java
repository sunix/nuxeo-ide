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

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.sdk.SDKPlugin;
import org.nuxeo.ide.sdk.java.ClasspathEditor;
import org.nuxeo.ide.sdk.ui.NuxeoNature;

/**
 * 
 * @author matic
 * @since 1.1
 */
public class ProjectOutputChecker implements 
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
                    if ((flags & (IResourceDelta.OPEN|IResourceDelta.SYNC)) == 0) {
                        return false;
                    }
                    final IProject project = (IProject) resource;
                    if (project.isOpen() == false) {
                        return false;
                    }
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

}
