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
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.resource.ResourceChange;
import org.nuxeo.ide.common.IOUtils;
import org.nuxeo.ide.sdk.SDKPlugin;

public class ReplaceIdChange extends ResourceChange {

    protected final IFile file;
    protected final String id;
    protected final String newId;
    
    public ReplaceIdChange(IFile file, String id, String newId) {
        this.file = file;
        this.id = id;
        this.newId = newId;
    }
    
    @Override
    public String getName() {
        return "Replace feature " + id + " to " + newId + " in " + file.getName();
    }

    @Override
    protected IResource getModifiedResource() {
        return file;
    }

    @Override
    public Change perform(IProgressMonitor pm) throws CoreException {
        InputStream in = file.getContents();
        String content;
        try {
            content = IOUtils.read(in);
        } catch (IOException e) {
            throw new CoreException(new Status(IStatus.ERROR, SDKPlugin.PLUGIN_ID, "Cannot read content of " + file.getName(), e));
        }
        content = content.replace(id, newId);
        file.setContents(new ByteArrayInputStream(content.getBytes()), IFile.KEEP_HISTORY, pm);
        return new ReplaceIdChange(file, newId, id);
    }

}
