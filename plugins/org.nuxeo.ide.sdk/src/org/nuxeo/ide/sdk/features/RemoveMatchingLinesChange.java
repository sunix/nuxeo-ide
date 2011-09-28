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
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

public class RemoveMatchingLinesChange extends ResourceChange {

    protected final IFile file;

    protected final String key;

    public RemoveMatchingLinesChange(IFile file, String key) {
        this.file = file;
        this.key = key;
    }

    @Override
    public Change perform(IProgressMonitor pm) throws CoreException {
        InputStream in = file.getContents();
        final List<String> removedLines = new ArrayList<String>();
        try {
            Iterator<String> it = IOUtils.readLines(in).iterator();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            while (it.hasNext()) {
                String line = it.next();
                if (!line.contains(key)) {
                    out.write(line.getBytes());
                    out.write("\n".getBytes());
                } else {
                    removedLines.add(line);
                }
            }
            file.setContents(new ByteArrayInputStream(out.toByteArray()),
                    IFile.KEEP_HISTORY, pm);
        } catch (IOException e) {
            throw new CoreException(new Status(IStatus.ERROR,
                    SDKPlugin.PLUGIN_ID, "Cannot write content of "
                            + file.getName(), e));
        }
        if (removedLines.size() > 0) {
            return new AddLinesChange(file, removedLines);
        }
        return new NoopFileChange(file);
    }

    @Override
    public String getName() {
        return "Resource bundle change " + file.getName();
    }

    @Override
    protected IResource getModifiedResource() {
        return file;
    }
}