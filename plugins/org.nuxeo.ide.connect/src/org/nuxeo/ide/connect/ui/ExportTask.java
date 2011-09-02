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
package org.nuxeo.ide.connect.ui;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.connect.Connector;
import org.nuxeo.ide.connect.OperationModel;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class ExportTask implements IRunnableWithProgress {

    protected String projectId;

    protected OperationModel[] ops;

    public ExportTask(String projectId, OperationModel[] ops) {
        this.projectId = projectId;
        this.ops = ops;
    }

    @Override
    public void run(IProgressMonitor monitor) throws InvocationTargetException,
            InterruptedException {
        try {
            monitor.beginTask("Generate JSON registries", 1);
            String reg = writeRegistry(ops);
            monitor.worked(1);
            if (monitor.isCanceled()) {
                return;
            }
            monitor.beginTask("Export registries to " + projectId, 1);
            Connector.exportOperationRegistry(projectId, reg);
            monitor.worked(1);
        } catch (Exception e) {
            UI.showError("Failed to export operations", e);
        } finally {
            monitor.done();
        }
    }

    public static String writeRegistry(OperationModel[] ops) throws Exception {
        return null;
    }

}
