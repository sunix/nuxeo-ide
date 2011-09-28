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
import java.util.ArrayList;
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

public class AddLinesChange extends ResourceChange {

    protected final IFile file;

    protected final List<String> lines = new ArrayList<String>();

    public AddLinesChange(IFile file, List<String> lines) {
        this.file = file;
        this.lines.addAll(lines);
    }

    @Override
    public Change perform(IProgressMonitor pm) throws CoreException {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            out.write(IOUtils.read(file.getContents()).getBytes());
            for (String line : lines) {
                out.write(line.getBytes());
                out.write("\n".getBytes());
            }
            file.setContents(new ByteArrayInputStream(out.toByteArray()),
                    IFile.KEEP_HISTORY, pm);
        } catch (IOException e) {
            throw new CoreException(new Status(IStatus.ERROR,
                    SDKPlugin.PLUGIN_ID, "Cannot write lines in "
                            + file.getName(), e));
        }
        return new RemoveLinesChange(file, lines);
    }

    @Override
    public String getName() {
        return "add lines in " + file.getName();
    }

    @Override
    protected IResource getModifiedResource() {
        return file;
    }
}