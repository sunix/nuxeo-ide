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

import java.io.ByteArrayInputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.resource.DeleteResourceChange;
import org.eclipse.ltk.core.refactoring.resource.ResourceChange;
import org.nuxeo.ide.sdk.SDKPlugin;
import org.nuxeo.ide.sdk.model.ExtensionModel;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class ExtensionChange extends ResourceChange {

    protected IFile file;

    protected String content;

    protected boolean overwrite;

    public ExtensionChange(IFile file, String content, boolean overwrite) {
        this.file = file;
        this.content = content;
        this.overwrite = overwrite;
    }

    public ExtensionChange(IFile file, String content) {
        this(file, content, true);
    }

    @Override
    protected IResource getModifiedResource() {
        return file;
    }

    @Override
    public String getName() {
        return "Create Extension: " + file.getName();
    }

    @Override
    public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException,
            OperationCanceledException {
        if (file.exists() && !overwrite) {
            RefactoringStatus status = new RefactoringStatus();
            status.addFatalError("Extension file: " + file.getName()
                    + " already exists");
            return status;
        }
        if (file.exists()) {
            return super.isValid(pm);
        }
        return new RefactoringStatus();
    }

    @Override
    public Change perform(IProgressMonitor pm) throws CoreException {
        try {
            ByteArrayInputStream in = new ByteArrayInputStream(
                    content.getBytes("UTF-8"));
            if (file.exists()) {
                file.setContents(in, true, true, pm);
            } else {
                ExtensionModel.createFolder((IFolder) file.getParent(), pm);
                file.create(in, true, pm);
            }
        } catch (CoreException e) {
            throw e;
        } catch (Exception e) {
            throw new CoreException(new Status(IStatus.ERROR,
                    SDKPlugin.PLUGIN_ID, "Failed to create extension file: "
                            + file.getName()));
        }
        return new DeleteResourceChange(file.getFullPath(), true);
    }

}
