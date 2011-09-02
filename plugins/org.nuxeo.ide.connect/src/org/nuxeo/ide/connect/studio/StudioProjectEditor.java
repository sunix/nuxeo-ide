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

import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.nuxeo.ide.common.BundleImageProvider;
import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.connect.ConnectPlugin;
import org.nuxeo.ide.connect.Connector;
import org.nuxeo.ide.connect.studio.tree.FeatureNode;
import org.nuxeo.ide.connect.studio.tree.Node;
import org.nuxeo.ide.connect.studio.tree.StudioProjectProvider;
import org.nuxeo.ide.connect.studio.tree.TypeNode;
import org.nuxeo.ide.connect.ui.ExportOperationsWizard;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class StudioProjectEditor extends AbstractFileEditor {

    protected TreeViewer tv;

    protected ScrolledForm form;

    protected IProject rootProject;

    protected StudioProject project;

    protected FormToolkit toolkit;

    protected BundleImageProvider imgProvider;

    public StudioProjectEditor() {
    }

    @Override
    public void doSave(IProgressMonitor monitor) {

    }

    @Override
    public void doSaveAs() {

    }

    @Override
    public void init(IEditorSite site, IEditorInput input)
            throws PartInitException {
        super.init(site, input);
        try {
            handleInputChanged((IFile) input.getAdapter(IFile.class));
        } catch (Exception e) {
            UI.showError("Failed to load studio project file", e);
        }
    }

    public void loadProject(IFile file) throws Exception {
        rootProject = file.getProject();
        InputStream in = file.getContents(true);
        try {
            project = StudioProject.readProject(in);
        } finally {
            in.close();
        }
    }

    @Override
    public boolean isDirty() {
        return false;
    }

    @Override
    public boolean isSaveAsAllowed() {
        return false;
    }

    @Override
    protected void handleInputChanged(IFile file) throws Exception {
        lastModification = file.getLocalTimeStamp();
        loadProject(file);
        setPartName(project.getId());
        if (tv != null) {
            tv.setInput(project);
        }
        if (form != null) {
            form.setText("Studio Project: " + project.getName());
        }
    }

    @Override
    public void createPartControl(Composite parent) {

        imgProvider = new BundleImageProvider(
                ConnectPlugin.getDefault().getBundle());
        toolkit = new FormToolkit(parent.getShell().getDisplay());

        form = toolkit.createScrolledForm(parent);
        form.setText("Studio Project: " + project.getName());
        form.getBody().setLayout(new GridLayout());
        form.setImage(imgProvider.getImage("icons/studio_project.gif"));
        createToolbar(form);

        Section section = toolkit.createSection(form.getBody(),
                Section.EXPANDED | Section.TITLE_BAR | Section.DESCRIPTION);
        section.setText("Project Features");
        section.setDescription("You can browse features available in the Nuxeo Studio project. Double click a feature entry to open it in the browser.");

        GridData gd = new GridData();
        gd.horizontalAlignment = SWT.FILL;
        gd.grabExcessHorizontalSpace = true;
        gd.verticalAlignment = SWT.FILL;
        gd.grabExcessVerticalSpace = true;
        section.setLayoutData(gd);

        Tree tree = toolkit.createTree(section, SWT.H_SCROLL | SWT.V_SCROLL
                | SWT.BORDER);

        section.setClient(tree);

        tv = new TreeViewer(tree);

        tv.addDoubleClickListener(new IDoubleClickListener() {
            @Override
            public void doubleClick(DoubleClickEvent event) {
                ISelection sel = event.getSelection();
                if (sel.isEmpty()) {
                    return;
                }
                Node<?> obj = (Node<?>) ((IStructuredSelection) sel).getFirstElement();
                if (obj.isTerminal()) {
                    if (obj instanceof FeatureNode) {
                        openFeature(((FeatureNode) obj).getData());
                    } else if (obj instanceof TypeNode) {
                        openGlobalFeature(((TypeNode) obj).getId());
                    }
                } else {
                    if (tv.getExpandedState(obj)) {
                        tv.collapseToLevel(obj, 1);
                    } else {
                        tv.expandToLevel(obj, 1);
                    }
                }
            }
        });

        StudioProjectProvider provider = new StudioProjectProvider(imgProvider);
        tv.setContentProvider(provider);
        tv.setLabelProvider(provider);
        tv.setSorter(new ViewerSorter());
        tv.setInput(project);
        // tv.expandAll();

    }

    protected void openFeature(StudioFeature feature) {
        String url = project.getUrl() + "#@feature:" + feature.getId() + '.'
                + feature.getType();
        Program.launch(url);
    }

    protected void openGlobalFeature(String type) {
        String url = project.getUrl() + "#@feature:global." + type;
        Program.launch(url);
    }

    @Override
    public void setFocus() {

    }

    protected void createToolbar(ScrolledForm form) {
        Action action = new Action() {
            public void run() {
                try {
                    Connector.writeStudioProject(rootProject, project.getId());
                    handleInputChanged((IFile) getEditorInput().getAdapter(
                            IFile.class));
                } catch (Exception e) {
                    UI.showError("Failed to refresh studio project", e);
                }
            }
        };
        action.setId("refresh");
        action.setText("Refresh");
        action.setImageDescriptor(imgProvider.getImageDescriptor("icons/refresh.gif"));
        form.getToolBarManager().add(action);

        action = new Action() {
            public void run() {
                ExportOperationsWizard wizard = new ExportOperationsWizard(
                        project.getId());
                wizard.init(getSite().getWorkbenchWindow().getWorkbench(),
                        new StructuredSelection(rootProject));
                WizardDialog dialog = new WizardDialog(getSite().getShell(),
                        wizard);
                dialog.create();
                dialog.open();
            }
        };
        action.setId("export");
        action.setText("Export Operations");
        action.setImageDescriptor(imgProvider.getImageDescriptor("icons/export.gif"));
        form.getToolBarManager().add(action);

        form.getToolBarManager().update(true);
    }

    @Override
    public void dispose() {
        super.dispose();
        tv = null;
        form = null;
        if (toolkit != null) {
            toolkit.dispose();
            toolkit = null;
        }
        if (imgProvider != null) {
            imgProvider.dispose();
            imgProvider = null;
        }
    }

}
