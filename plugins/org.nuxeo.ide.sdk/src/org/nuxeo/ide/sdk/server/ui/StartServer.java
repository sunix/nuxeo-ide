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

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.sdk.server.ServerConstants;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class StartServer implements IViewActionDelegate, ServerConstants {

    protected IServerView view;

    @Override
    public void run(IAction action) {
        try {
            view.start();
        } catch (Exception e) {
            UI.showError("Failed to start Nuxeo Server", e);
        }
    }

    @Override
    public void selectionChanged(IAction action, ISelection selection) {
        if (selection instanceof ServerState) {
            ServerState ss = (ServerState) selection;
            action.setEnabled(ss.getState() == STOPPED);
        }
    }

    @Override
    public void init(IViewPart view) {
        this.view = (IServerView) view;
    }

}
