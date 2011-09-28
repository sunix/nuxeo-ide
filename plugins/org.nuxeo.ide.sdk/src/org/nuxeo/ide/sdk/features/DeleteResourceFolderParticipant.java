/*
 * (C) Copyright 2011 Nuxeo SA (http://nuxeo.com/) and contributors.
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
 *     eugen
 */
package org.nuxeo.ide.sdk.features;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.DeleteParticipant;
import org.nuxeo.ide.sdk.model.ExtensionModel;
import org.nuxeo.ide.sdk.model.ManifestWriter;

/**
 * @author <a href="mailto:ei@nuxeo.com">Eugen Ionica</a>
 * 
 */
public class DeleteResourceFolderParticipant extends DeleteParticipant {
    IFolder folder;

    protected boolean initialize(Object element) {
        if (!(element instanceof IFolder)) {
            return false;
        }
        IResource resource = (IResource) element;
        String path = resource.getProjectRelativePath().makeRelative().removeTrailingSeparator().toString();
        if (!path.startsWith(ExtensionModel.RESOURCES_PATH)) {
            return false;
        }
        this.folder = (IFolder)resource;
        return true;
    }

    public String getName() {
        return "Removing folder:" + folder.getName();
    }

    @Override
    public RefactoringStatus checkConditions(IProgressMonitor pm,
            CheckConditionsContext context) throws OperationCanceledException {
        return new RefactoringStatus();
    }

    @Override
    public Change createChange(IProgressMonitor pm) throws CoreException,
            OperationCanceledException {
        final ManifestChange change = new ManifestChange(
                folder.getProject().getFile(ManifestWriter.PATH));

        folder.accept(new IResourceVisitor() {
            public boolean visit(IResource resource) throws CoreException {
                if (resource instanceof IFile
                        && "xml".equals(resource.getFileExtension())) {
                    change.remove(
                            "Nuxeo-Component",
                            resource.getProjectRelativePath().removeFirstSegments(
                                    3).toString());
                }
                return true;
            }
        });

        return change;
    }
}
