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
package org.nuxeo.ide.studio.ui.internal.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreeViewer;

/**
 * @author eugen
 *
 */
public class CollapseAllAction extends Action{

    TreeViewer treeViewer;

    public CollapseAllAction(TreeViewer treeViewer) {
        this.treeViewer = treeViewer;
        setText("Collapse All");
        setToolTipText("Collapse All");
        setImageDescriptor(ActionIcons.getIcon(ActionIcons.ACTION_COLLAPSE_ALL));
    }

    public void run() {
        treeViewer.collapseAll();
    }
}
