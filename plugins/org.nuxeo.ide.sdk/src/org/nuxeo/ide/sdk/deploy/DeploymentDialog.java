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
package org.nuxeo.ide.sdk.deploy;

import java.util.HashSet;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.nuxeo.ide.common.UI;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class DeploymentDialog extends TitleAreaDialog {

    protected DeploymentPanel panel;

    protected DeploymentsTable table;

    public DeploymentDialog(Shell shell) {
        super(shell);
    }

    @Override
    protected boolean isResizable() {
        return true;
    }

    @Override
    protected Point getInitialSize() {
        return new Point(800, 600);
    }

    public DeploymentsTable getDeploymentsTable() {
        return table;
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite composite = (Composite) super.createDialogArea(parent);

        SashForm sash = new SashForm(composite, SWT.HORIZONTAL | SWT.FLAT);
        sash.setLayout(new FillLayout());
        table = new DeploymentsTable(sash);
        Composite panelContainer = new Composite(sash, SWT.NONE);
        panelContainer.setLayout(new FillLayout());
        panel = new DeploymentPanel(panelContainer);
        panel.setDialog(this);
        panel.setVisible(false);
        sash.setWeights(new int[] { 30, 70 });

        GridData gd = new GridData();
        gd.horizontalAlignment = SWT.FILL;
        gd.verticalAlignment = SWT.FILL;
        gd.grabExcessHorizontalSpace = true;
        gd.grabExcessVerticalSpace = true;
        sash.setLayoutData(gd);

        setTitle("Deployment Configurations");
        setMessage("Create and select the default deployment configuration to use on the server");

        getShell().addDisposeListener(new DisposeListener() {
            @Override
            public void widgetDisposed(DisposeEvent e) {
                dispose();
            }
        });

        table.getTableViewer().addSelectionChangedListener(
                new ISelectionChangedListener() {
                    public void selectionChanged(SelectionChangedEvent event) {
                        Deployment deployment = table.getSelection();
                        updatePanel(deployment);
                    }
                });

        table.refresh();

        return composite;
    }

    protected void updatePanel(Deployment deployment) {
        if (deployment == null) {
            panel.setVisible(false);
        } else {
            panel.setVisible(true);
            panel.setDeployment(deployment);
        }
    }

    public void dispose() {
        if (table != null) {
            table.dispose();
        }
        if (panel != null) {
            panel.dispose();
        }
    }

    protected boolean validateDeploymentNames(DeploymentPreferences prefs) {
        HashSet<String> set = new HashSet<String>();
        for (Deployment d : prefs.getDeployments()) {
            if (!set.add(d.getName())) {
                UI.showError("Several deployment configurations share the same name: "
                        + d.getName() + ".");
                return false;
            }
        }
        return true;
    }

    @Override
    protected void okPressed() {
        try {
            if (!validateDeploymentNames(table.getPrefs())) {
                return;
            }
            Deployment d = table.getDefaultDeployment();
            if (d != null) {
                table.getPrefs().setDefault(d.getName());
            }
            table.getPrefs().save();
            super.okPressed();
        } catch (Exception e) {
            UI.showError("Failed to save modifications", e);
        }
    }
}
