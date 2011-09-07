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

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.PlatformUI;
import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.connect.studio.StudioEditor;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class OpenAction extends Action {

    protected StudioNavigatorActionProvider provider;

    public OpenAction(StudioNavigatorActionProvider provider) {
        super("Open");
        this.provider = provider;
        setId(OpenAction.class.getName());
    }

    public boolean isEnabled() {
        return getSelection() != null;
    }

    public StudioProjectElement getSelection() {
        IStructuredSelection selection = (IStructuredSelection) provider.getContext().getSelection();
        if (selection.isEmpty()) {
            return null;
        }
        Object o = selection.getFirstElement();
        if (o instanceof StudioProjectElement) {
            return (StudioProjectElement) o;
        }
        return null;
    }

    @Override
    public void run() {
        StudioProjectElement element = getSelection();
        if (element != null) {
            IEditorInput input = new StudioEditorInput(element);
            try {
                PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(
                        input, StudioEditor.ID);
            } catch (Exception e) {
                UI.showError(
                        "Failed to open Studio Project: " + element.getName(),
                        e);
            }
        }
    }

}
