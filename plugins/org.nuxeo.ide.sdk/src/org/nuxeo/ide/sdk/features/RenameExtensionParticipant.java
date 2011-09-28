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
package org.nuxeo.ide.sdk.features;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.NullChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.RenameParticipant;
import org.nuxeo.ide.sdk.model.ExtensionModel;
import org.nuxeo.ide.sdk.model.ManifestWriter;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class RenameExtensionParticipant extends RenameParticipant {

    protected IFile file;

    @Override
    protected boolean initialize(Object element) {
        if (element instanceof IFile) {
            IResource resource = (IFile) element;
            if (!"xml".equals(resource.getFileExtension())) {
                return false;
            }
            String path = resource.getParent().getProjectRelativePath().makeRelative().removeTrailingSeparator().toString();
            if (ExtensionModel.BASE_PATH.equals(path)) {
                this.file = (IFile)resource;
                return true;
            }
        }
        return false;
    }

    @Override
    public String getName() {
        return "Remove Extension File: " + file.getName();
    }

    @Override
    public RefactoringStatus checkConditions(IProgressMonitor pm,
            CheckConditionsContext context) throws OperationCanceledException {
        String name = getArguments().getNewName();
        if (name.endsWith(".xml")) {
            name = name.substring(0, name.length() - 4);
        } else {
            RefactoringStatus status = new RefactoringStatus();
            status.addWarning("Extension files must have an .xml extension");
            return status;
        }
        return new RefactoringStatus();
    }

    @Override
    public Change createChange(IProgressMonitor pm) throws CoreException,
            OperationCanceledException {
        String name = getArguments().getNewName();
        if (name.endsWith(".xml")) {
            name = name.substring(0, name.length() - 4);
        } else {
            return new NullChange();
        }
        ManifestChange change = new ManifestChange(file.getProject().getFile(
                ManifestWriter.PATH));
        change.remove(
                "Nuxeo-Component",
                ExtensionModel.getRuntimePath(file.getProjectRelativePath().removeFileExtension().lastSegment()));
        change.append("Nuxeo-Component", ExtensionModel.getRuntimePath(name));
        return change;
    }

}
