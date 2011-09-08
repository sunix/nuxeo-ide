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

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.nuxeo.ide.connect.StudioProvider;
import org.nuxeo.ide.connect.studio.content.StudioProjectElement;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class StudioEditorPanel extends StudioPanel {

    protected StudioProjectElement element;

    public StudioEditorPanel(Composite parent) {
        super(parent);
    }

    public void setInput(StudioProjectElement element) {
        this.element = element;
        super.setInput(element.getProject());
    }

    @Override
    protected String getFormTitle() {
        if (element == null) {
            return super.getFormTitle();
        } else {
            return "Studio Project: " + element.getName();
        }
    }

    protected IAction createExportOperationsAction() {
        Action action = new Action() {
            public void run() {
                // ExportOperationsWizard wizard = new ExportOperationsWizard(
                // project.getId());
                // wizard.init(getSite().getWorkbenchWindow().getWorkbench(),
                // new StructuredSelection(rootProject));
                // WizardDialog dialog = new WizardDialog(getSite().getShell(),
                // wizard);
                // dialog.create();
                // dialog.open();
            }
        };
        action.setId("export");
        action.setText("Export Operations");
        action.setImageDescriptor(imgProvider.getImageDescriptor("icons/export.gif"));
        return action;
    }

    @Override
    protected void createToolbar(ScrolledForm form) {
        form.getToolBarManager().add(createRefreshAction());
        form.getToolBarManager().add(createExportOperationsAction());
        form.getToolBarManager().update(true);
    }

    @Override
    public void handleProjectsUpdate(StudioProvider provider) {
        setInput(element);
    }
}
