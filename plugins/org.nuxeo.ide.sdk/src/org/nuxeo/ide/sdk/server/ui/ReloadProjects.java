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
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.sdk.NuxeoSDK;
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
            if (d != null) {
                reload(d);
            }
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

    public void reload(Deployment deployment) throws Exception {
        NuxeoSDK sdk = NuxeoSDK.getDefault();
        if (sdk != null) {
            sdk.reloadDeployment(deployment);
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

}
