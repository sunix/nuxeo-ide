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
package org.nuxeo.ide.connect.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.ui.ISharedImages;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.connect.OperationModel;
import org.nuxeo.ide.connect.OperationScanner;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class CollectOperationsPage extends WizardPage {

    protected CheckboxTreeViewer tv;

    public CollectOperationsPage() {
        super("collectOperations", "Select Operations to Export", null);
    }

    public OperationModel[] getSelectedOperations() {
        Object[] ar = tv.getCheckedElements();
        OperationModel[] ops = new OperationModel[ar.length];
        for (int i = 0; i < ar.length; i++) {
            ops[i] = (OperationModel) ar[i];
        }
        return ops;
    }

    @Override
    public void createControl(Composite parent) {
        Composite panel = new Composite(parent, SWT.NONE);
        panel.setLayout(new GridLayout());
        Label label = new Label(panel, SWT.NONE);
        label.setText("Select the operations you want to export:");
        tv = new CheckboxTreeViewer(panel, SWT.V_SCROLL | SWT.H_SCROLL
                | SWT.BORDER);
        tv.setLabelProvider(new MyLabelProvider());
        tv.setContentProvider(new MyContentProvider());
        tv.setCheckStateProvider(new MyCheckStateProvider());
        GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
        tv.getTree().setLayoutData(gd);
        final Label status = new Label(panel, SWT.NONE);
        gd = new GridData(SWT.FILL, SWT.LEFT, true, false);
        status.setLayoutData(gd);
        status.setText("");
        setControl(panel);

        tv.addSelectionChangedListener(new ISelectionChangedListener() {
            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                String text = "";
                if (!event.getSelection().isEmpty()) {
                    Object o = ((IStructuredSelection) event.getSelection()).getFirstElement();
                    if (o instanceof OperationModel) {
                        text = ((OperationModel) o).getId() + ": "
                                + ((OperationModel) o).getLabel();
                    }
                }
                status.setText(text);
            }
        });

        IWizard wizard = getWizard();
        if (wizard instanceof ExportOperationsWizard) {
            tv.setInput(((ExportOperationsWizard) getWizard()).getSelectedProject());
        }
    }

    public void setInput(Object input) {
        if (tv != null) {
            tv.setInput(input);
        }
    }

    public List<OperationModel> getCheckedOperations() {
        ArrayList<OperationModel> result = new ArrayList<OperationModel>();
        for (Object o : tv.getCheckedElements()) {
            if (o instanceof OperationModel) {
                result.add((OperationModel) o);
            }
        }
        return result;
    }

    static class MyLabelProvider extends BaseLabelProvider implements
            ILabelProvider {

        @Override
        public Image getImage(Object element) {
            if (element instanceof OperationModel) {
                return JavaUI.getSharedImages().getImage(
                        ISharedImages.IMG_OBJS_CLASS);
            }
            return null;
        }

        @Override
        public String getText(Object element) {
            if (element instanceof OperationModel) {
                OperationModel op = (OperationModel) element;
                return op.getType().getFullyQualifiedName();
            }
            return element.toString();
        }

        @Override
        public void dispose() {
            super.dispose();
        }

    }

    static class MyContentProvider implements ITreeContentProvider {

        @Override
        public void dispose() {
        }

        @Override
        public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        }

        @Override
        public Object[] getElements(Object inputElement) {
            try {
                if (inputElement instanceof SelectExportedProjectsPage) {
                    IProject[] projects = ((SelectExportedProjectsPage) inputElement).getSelectedProjects();
                    if (projects == null) {
                        return UI.EMPTY_OBJECTS;
                    }
                    IJavaProject[] jprojects = new IJavaProject[projects.length];
                    for (int i = 0; i < projects.length; i++) {
                        jprojects[i] = JavaCore.create(projects[i]);
                    }
                    List<OperationModel> ops = OperationScanner.getOperations(jprojects);
                    return ops.toArray(new OperationModel[ops.size()]);
                } else {
                    IJavaProject project = null;
                    if (inputElement instanceof IProject) {
                        project = JavaCore.create((IProject) inputElement);
                    } else if (inputElement instanceof IJavaProject) {
                        project = (IJavaProject) inputElement;
                    }
                    if (project != null) {

                        List<OperationModel> ops = OperationScanner.getOperations(project);
                        return ops.toArray(new OperationModel[ops.size()]);
                    }
                }
            } catch (Exception e) {
                UI.showError("Cannot scan operations", e);
            }
            return UI.EMPTY_OBJECTS;
        }

        @Override
        public Object[] getChildren(Object parentElement) {
            return new Object[0];
            // if (parentElement instanceof DependencyEntry) {
            // DependencyEntry entry = (DependencyEntry) parentElement;
            // return entry.getDependencies().toArray(
            // new Dependency[entry.size()]);
            // }
            // return null;
        }

        @Override
        public Object getParent(Object element) {
            return null;
        }

        @Override
        public boolean hasChildren(Object element) {
            // return element instanceof DependencyEntry;
            return false;
        }
    }

    static class MyCheckStateProvider implements ICheckStateProvider {

        @Override
        public boolean isChecked(Object element) {
            return true;
        }

        @Override
        public boolean isGrayed(Object element) {
            return false;
        }

    }
}
