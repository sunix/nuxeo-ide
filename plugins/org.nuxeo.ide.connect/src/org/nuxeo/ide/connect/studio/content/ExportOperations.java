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
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.PlatformUI;
import org.nuxeo.ide.connect.ConnectPlugin;
import org.nuxeo.ide.connect.ui.ExportOperationsWizard;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class ExportOperations extends Action {

    protected StudioNavigatorActionProvider provider;

    public ExportOperations(StudioNavigatorActionProvider provider) {
        super(
                "Export Operations",
                ImageDescriptor.createFromURL(ConnectPlugin.getDefault().getBundle().getEntry(
                        "icons/export.gif")));
        this.provider = provider;
        setId(ExportOperations.class.getName());
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
            ExportOperationsWizard wizard = new ExportOperationsWizard(
                    element.getProject().getId());
            wizard.init(PlatformUI.getWorkbench(), new StructuredSelection(
                    element.getTargetProject()));
            WizardDialog dialog = new WizardDialog(provider.getShell(), wizard);
            dialog.create();
            dialog.open();
        }
    }

}
