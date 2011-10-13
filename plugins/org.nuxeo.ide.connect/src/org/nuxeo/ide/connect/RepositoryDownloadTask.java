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
 *     slacoin
 */
package org.nuxeo.ide.connect;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.nuxeo.ide.common.IOUtils;
import org.nuxeo.ide.common.UI;


public class RepositoryDownloadTask implements IRunnableWithProgress {

    protected final RepositoryManager.Entry entry;

    public RepositoryDownloadTask(RepositoryManager.Entry entry) {
        this.entry = entry;
    }

    @Override
    public void run(IProgressMonitor monitor) throws InvocationTargetException,
            InterruptedException {
        monitor.beginTask("Download jar for " + entry.projectId + " on connect", 1);
        try {
            InputStream is = Connector.getDefault().downloadJarArtifact(
                    entry.projectId);
            IOUtils.copyToFile(is, entry.file, true);
        } catch (Exception e) {
            UI.showError(
                    "Cannot download jar for " + entry.projectId + " on connect", e);
        }
        monitor.done();
    }

}
