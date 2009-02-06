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

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.browser.IWebBrowser;
import org.eclipse.ui.browser.IWorkbenchBrowserSupport;
import org.nuxeo.ide.webengine.Nuxeo;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class OpenWebBrowserAction extends Action {

    protected ServerView view;

    public OpenWebBrowserAction(ServerView view) {
        setId("org.nuxeo.ide.webengine.server.openwebbrowser");
        this.view = view;
        setText("Open in a Web Browser");
        setToolTipText("Open in a Web Browser");
        setImageDescriptor(Nuxeo.getImageDescriptor("/icons/internal_browser.gif"));
    }

    @Override
    public void run() {
        try {
            IWorkbenchBrowserSupport browserSupport = PlatformUI.getWorkbench().getBrowserSupport();
            IWebBrowser browser = browserSupport.createBrowser(
                    IWorkbenchBrowserSupport.LOCATION_BAR
                            | IWorkbenchBrowserSupport.NAVIGATION_BAR,
                    "org.nuxeo.ide.webengine.browser", "Webengine browser",
                    "Webengine browser");
            browser.openURL(new URL("http://localhost:8080"));

        } catch (PartInitException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isEnabled() {
        ILaunch launch = view.getCurrentLaunch();
        return launch != null && !launch.isTerminated();
    }

}
