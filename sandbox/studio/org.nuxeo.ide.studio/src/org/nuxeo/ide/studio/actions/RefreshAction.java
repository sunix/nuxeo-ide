/*
 * (C) Copyright 2011 Nuxeo SA (http://nuxeo.com/) and contributors.
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
 *     eugen
 */
package org.nuxeo.ide.studio.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.nuxeo.ide.studio.data.Node;
import org.nuxeo.ide.studio.editors.StudioEditor;
import org.nuxeo.ide.studio.editors.StudioEditorInput;
import org.nuxeo.ide.studio.ui.Icons;
import org.nuxeo.ide.studio.views.StudioBrowserView;

/**
 * @author eugen
 *
 */
public class RefreshAction extends Action {
    StudioBrowserView studioBrowserView;

    public RefreshAction(StudioBrowserView studioBrowserView) {
        this.studioBrowserView = studioBrowserView;
        setText("Refresh");
        setToolTipText("Refresh");
        setImageDescriptor(Icons.getIcon(Icons.ACTION_REFRESH));
    }

    public void run() {
        studioBrowserView.refresh();
    }

}
