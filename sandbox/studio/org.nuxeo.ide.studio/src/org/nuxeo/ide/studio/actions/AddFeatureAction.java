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
import org.nuxeo.ide.studio.ui.Icons;
import org.nuxeo.ide.studio.ui.UI;

/**
 * @author eugen
 *
 */
public class AddFeatureAction extends Action {
    public AddFeatureAction() {
        setText("Add Feature");
        setToolTipText("Add Feature");
        setImageDescriptor(Icons.getIcon(Icons.ACTION_ADD_FEATURE));
    }

    public void run() {
        System.out.println("add...");
        UI.showInfo("Not yet... ");
    }

}
