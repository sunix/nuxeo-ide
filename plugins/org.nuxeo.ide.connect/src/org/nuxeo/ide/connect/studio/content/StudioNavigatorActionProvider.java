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
package org.nuxeo.ide.connect.studio.content;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionConstants;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonMenuConstants;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class StudioNavigatorActionProvider extends CommonActionProvider {

    protected OpenAction open;

    protected ExportOperations exportOps;

    @Override
    public void fillActionBars(IActionBars actionBars) {
        if (open.isEnabled()) {
            actionBars.setGlobalActionHandler(ICommonActionConstants.OPEN, open);
        }
    }

    @Override
    public void fillContextMenu(IMenuManager menu) {
        if (open.isEnabled()) {
            menu.appendToGroup(ICommonMenuConstants.GROUP_OPEN, open);
        }
        if (exportOps.isEnabled()) {
            menu.appendToGroup(ICommonMenuConstants.GROUP_GENERATE, exportOps);
        }
    }

    @Override
    public void init(ICommonActionExtensionSite aSite) {
        super.init(aSite);
        open = new OpenAction(this);
        exportOps = new ExportOperations(this);
    }

    public ICommonActionExtensionSite getSite() {
        return getActionSite();
    }

    public Shell getShell() {
        return getActionSite().getViewSite().getShell();
    }

}
