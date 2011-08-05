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
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.nuxeo.ide.studio.StudioPlugin;

/**
 * @author eugen
 *
 */
public class DeleteFeatureAction extends Action{
    TreeViewer treeViewer;
    public DeleteFeatureAction(TreeViewer treeViewer) {
        this.treeViewer = treeViewer;
        setText("Delete Feature");
        setToolTipText("Remove Feature");
        setImageDescriptor(ActionIcons.getIcon(ActionIcons.ACTION_DELETE_FEATURE));
        treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

            public void selectionChanged(SelectionChangedEvent event) {
                ISelection selection = event.getSelection();
                setEnabled(!selection.isEmpty());
            }
        });

    }

    public void run() {
        StudioPlugin.showInfo("Not yet...");
    }

}
