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

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.nuxeo.ide.sdk.userlibs.UserLib;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class DeploymentPanel extends Composite {

    protected Deployment deployment;

    protected Text name;

    protected ProjectCheckList projects;

    protected UserLibCheckList libraries;

    protected DeploymentDialog dialog;

    public DeploymentPanel(Composite parent) {
        super(parent, SWT.BORDER);
        createContent();
    }

    public void setDialog(DeploymentDialog dialog) {
        this.dialog = dialog;
    }

    public void setDeployment(Deployment deployment) {
        this.deployment = deployment;
        this.name.setText(deployment.getName());
        this.projects.setCheckedProjects(deployment.getProjects());
        this.libraries.setCheckedLibs(deployment.getLibraries());
    }

    public Deployment getDeployment() {
        return deployment;
    }

    public void dispose() {

    }

    protected void createContent() {
        GridLayout layout = new GridLayout();
        layout.numColumns = 2;
        setLayout(layout);

        Label label0 = new Label(this, SWT.NONE);
        label0.setText("Deployment Name:");
        name = new Text(this, SWT.BORDER);
        Label sep0 = new Label(this, SWT.SEPARATOR | SWT.HORIZONTAL);
        Label label1 = new Label(this, SWT.NONE);
        label1.setText("Projects");
        projects = new ProjectCheckList(this);
        Label label2 = new Label(this, SWT.NONE);
        label2.setText("User Libraries");
        libraries = new UserLibCheckList(this);

        GridData gd = new GridData();
        gd.horizontalSpan = 2;
        label1.setLayoutData(gd);
        label2.setLayoutData(gd);

        gd = new GridData();
        gd.horizontalSpan = 2;
        gd.horizontalAlignment = SWT.FILL;
        gd.grabExcessHorizontalSpace = true;
        sep0.setLayoutData(gd);

        gd = new GridData();
        gd.horizontalAlignment = SWT.FILL;
        gd.grabExcessHorizontalSpace = true;
        name.setLayoutData(gd);

        gd = new GridData();
        gd.horizontalSpan = 2;
        gd.horizontalAlignment = SWT.FILL;
        gd.verticalAlignment = SWT.FILL;
        gd.grabExcessHorizontalSpace = true;
        gd.grabExcessVerticalSpace = true;
        projects.setLayoutData(gd);

        gd = new GridData();
        gd.horizontalSpan = 2;
        gd.horizontalAlignment = SWT.FILL;
        gd.verticalAlignment = SWT.FILL;
        gd.grabExcessHorizontalSpace = true;
        libraries.setLayoutData(gd);

        name.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (dialog != null) {
                    deployment.setName(name.getText());
                    dialog.getDeploymentsTable().updateDeployment(deployment);
                }
            }
        });

        projects.getTableViewer().addCheckStateListener(
                new ICheckStateListener() {
                    @Override
                    public void checkStateChanged(CheckStateChangedEvent event) {
                        if (event.getChecked()) {
                            deployment.addProject((IProject) event.getElement());
                        } else {
                            deployment.removeProject((IProject) event.getElement());
                        }
                    }
                });

        libraries.getTableViewer().addCheckStateListener(
                new ICheckStateListener() {
                    @Override
                    public void checkStateChanged(CheckStateChangedEvent event) {
                        if (event.getChecked()) {
                            deployment.addLibrary((UserLib) event.getElement());
                        } else {
                            deployment.removeLibrary((UserLib) event.getElement());
                        }
                    }
                });

    }
}
