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
package org.nuxeo.ide.sdk.server.ui;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.sdk.NuxeoSDK;
import org.nuxeo.ide.sdk.SDKPlugin;
import org.nuxeo.ide.sdk.deploy.Deployment;
import org.nuxeo.ide.sdk.deploy.DeploymentPreferences;
import org.nuxeo.ide.sdk.userlibs.UserLib;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class ReloadProjects implements IViewActionDelegate {

    protected IServerView view;

    @Override
    public void run(IAction action) {
        try {
            DeploymentPreferences prefs = DeploymentPreferences.load();
            Deployment d = prefs.getDefault();
            reload(d);
        } catch (Exception e) {
            UI.showError("Failed to reload projects", e);
        }
    }

    @Override
    public void selectionChanged(IAction action, ISelection selection) {
    }

    @Override
    public void init(IViewPart view) {
        this.view = (IServerView) view;
    }

    public void reload(final Deployment deployment) throws Exception {
        final NuxeoSDK sdk = NuxeoSDK.getDefault();
        if (sdk != null) {
            new Job("Reloading Projects") {
                @Override
                protected IStatus run(IProgressMonitor monitor) {
                    IStatus status = null;
                    monitor.beginTask("Reloading Projects on Server", 1);
                    try {
                        doReload(sdk, deployment, monitor);
                        status = Status.OK_STATUS;
                    } catch (Throwable t) {
                        status = new Status(IStatus.ERROR, SDKPlugin.PLUGIN_ID,
                                "Failed to reload projects on server", t);
                    }
                    monitor.worked(1);
                    monitor.done();
                    return status;
                }
            }.schedule();
        }
    }

    protected void doReload(final NuxeoSDK sdk, final Deployment deployment,
            final IProgressMonitor monitor) throws Exception {
        sdk.reloadDeployment(deployment);
        Display.getDefault().asyncExec(new Runnable() {
            @Override
            public void run() {
                updateConsole(deployment, monitor);
            }
        });
    }

    protected void updateConsole(Deployment deployment, IProgressMonitor monitor) {
        boolean lock = view.getScrollLock();
        view.setScrollLock(false);
        try {
            view.append("=== Reloaded Projects on Target Server ===\n");
            for (IProject project : deployment.getProjects()) {
                view.append("= Project: " + project.getName() + "\n");
            }
            UserLib[] libs = deployment.getLibraries();
            if (libs.length > 0) {
                for (UserLib lib : libs) {
                    view.append("=\n");
                    view.append("= User Library: " + lib.getName() + "\n");
                }
            }
            view.append("==========================================\n");
        } finally {
            view.setScrollLock(lock);
        }
    }

}
