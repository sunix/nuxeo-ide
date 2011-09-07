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
package org.nuxeo.ide.connect.studio;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.connect.ConnectPlugin;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class StudioView extends ViewPart {

    protected StudioPanel panel;

    @Override
    public void createPartControl(Composite parent) {
        panel = new StudioPanel(parent);
        try {
            panel.setInput(ConnectPlugin.getStudioProvider());
        } catch (Exception e) {
            UI.showError("Failed to get studio projects", e);
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        if (panel != null) {
            panel.dispose();
            panel = null;
        }
    }

    @Override
    public void setFocus() {

    }

}
