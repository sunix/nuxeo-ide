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
public class TerminateAction extends Action {

    protected ServerView view;
    
    public TerminateAction(ServerView view) {
        setId("org.nuxeo.ide.webengine.server.terminate");
        this.view = view;
        setText("Terminate");
        setToolTipText("Terminate Process");
        setImageDescriptor(Nuxeo.getImageDescriptor("/icons/terminate.gif"));
    }
    
    @Override
    public void run() {
        try {
            ILaunch launch = view.getCurrentLaunch();
            if (launch != null && launch.canTerminate()) {
                launch.terminate();
            }
        } catch (CoreException e) {
            UI.showError("Failed to temrinate process", e);
        }
    }

    @Override
    public boolean isEnabled() {
        ILaunch launch = view.getCurrentLaunch();
        return launch != null && !launch.isTerminated(); 
    }

}
