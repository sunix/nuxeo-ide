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
package org.nuxeo.ide.sdk.features;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.resource.RenameResourceChange;
import org.nuxeo.ide.common.IOUtils;
import org.nuxeo.ide.sdk.SDKPlugin;

public class RenameResourceAndReplaceContentChange extends RenameResourceChange {

    protected final IFile file;
    protected final IPath path;
    protected final String id;
    protected final String newId;
    protected final String suffix;
    
    public RenameResourceAndReplaceContentChange(IFile file, String id, String newId, String suffix) {
        super(file.getFullPath(), newId + suffix);
        this.file = file;
        this.path = file.getFullPath().removeLastSegments(1).append(newId+suffix);
        this.id = id;
        this.newId = newId;
        this.suffix = suffix;
    }
    
    @Override
    public String getName() {
        return "Replace feature " + id + " to " + newId + " in " + file.getName();
    }

    @Override
    public Change perform(IProgressMonitor pm) throws CoreException {
        super.perform(pm);
        IFile newFile = (IFile)ResourcesPlugin.getWorkspace().getRoot().findMember(path);
        InputStream in = newFile.getContents();
        String content;
        try {
            content = IOUtils.read(in);
        } catch (IOException e) {
            throw new CoreException(new Status(IStatus.ERROR, SDKPlugin.PLUGIN_ID, "Cannot read content of " + file.getName(), e));
        }
        content = content.replace(id, newId);
        newFile.setContents(new ByteArrayInputStream(content.getBytes()), IFile.KEEP_HISTORY, pm);
        return new RenameResourceAndReplaceContentChange(newFile, newId, id, suffix);
    }

}
