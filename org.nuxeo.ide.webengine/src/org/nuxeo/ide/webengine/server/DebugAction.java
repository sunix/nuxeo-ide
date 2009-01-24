/*
 * (C) Copyright 2006-2008 Nuxeo SAS (http://nuxeo.com/) and contributors.
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
package org.nuxeo.ide.webengine.server;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.jface.action.Action;
import org.nuxeo.ide.webengine.Nuxeo;
import org.nuxeo.ide.webengine.UI;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 *
 */
public class DebugAction extends Action {

    protected ServerView view;
    
    public DebugAction(ServerView view) {
        setId("org.nuxeo.ide.webengine.server.debug");
        this.view = view;
        setText("Debug");
        setToolTipText("Debug");
        setImageDescriptor(Nuxeo.getImageDescriptor("/icons/debug.gif"));
    }
    
    @Override
    public void run() {
        try {
            Launcher.debug(view.config);
        } catch (CoreException e) {
            UI.showError("Failed to launch server", e);
        }
    }

    @Override
    public boolean isEnabled() {
        ILaunch launch = view.getCurrentLaunch();
        return view.config.isValid() && (launch == null || launch.isTerminated());
    }

}
