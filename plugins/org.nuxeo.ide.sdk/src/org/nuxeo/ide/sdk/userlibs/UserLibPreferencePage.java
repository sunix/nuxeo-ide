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
package org.nuxeo.ide.sdk.userlibs;

import java.io.File;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.nuxeo.ide.common.FormPreferencePage;
import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.common.forms.ActionHandler;
import org.nuxeo.ide.common.forms.Form;
import org.nuxeo.ide.common.forms.FormData;
import org.nuxeo.ide.common.forms.UIObject;
import org.nuxeo.ide.sdk.NuxeoSDK;
import org.nuxeo.ide.sdk.model.M2PomModelProvider;
import org.nuxeo.ide.sdk.model.PomModel;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class UserLibPreferencePage extends FormPreferencePage implements
        IWorkbenchPreferencePage, FormData {

    protected UserLibPreferences prefs;

    protected UserLib lastEdited;

    public UserLibPreferencePage() {
        super(null);
        setFormData(this);
    }

    @Override
    protected Form createForm() {
        Form form = super.createForm();
        form.addWidgetType(UserLibsWidget.class);
        return form;
    }

    @Override
    protected Control createContents(Composite parent) {
        Control root = super.createContents(parent);
        form.addActionHandler("add", new ActionHandler() {
            @Override
            public void handleAction(Form form, UIObject<?> obj, Object event) {
                handleAddAction(obj.getControl().getShell());
            }
        });
        form.addActionHandler("remove", new ActionHandler() {
            @Override
            public void handleAction(Form form, UIObject<?> obj, Object event) {
                UserLib lib = getSelectedLib();
                if (lib != null) {
                    removeLib(lib);
                }
            }
        });

        getEditorPanel().setEnabled(false);

        getTable().getTableViewer().setInput(prefs);

        getTable().getTableViewer().addSelectionChangedListener(
                new ISelectionChangedListener() {
                    @Override
                    public void selectionChanged(SelectionChangedEvent event) {
                        ISelection selection = event.getSelection();
                        if (selection.isEmpty()) {
                            getRemoveButton().setEnabled(false);
                            updateEditor(null);
                        } else {
                            getRemoveButton().setEnabled(true);
                            updateEditor((UserLib) ((IStructuredSelection) selection).getFirstElement());
                        }
                    }
                });

        UserLib lib = (UserLib) getTable().getTableViewer().getElementAt(0);
        if (lib != null) {
            getTable().getTableViewer().setSelection(
                    new StructuredSelection(lib));
        }

        return root;
    }

    public UserLib getSelectedLib() {
        ISelection selection = getTable().getTableViewer().getSelection();
        if (selection.isEmpty()) {
            return null;
        }
        return (UserLib) ((IStructuredSelection) selection).getFirstElement();
    }

    protected void removeLib(UserLib lib) {
        TableViewer tv = getTable().getTableViewer();
        prefs.removeUserLib(lib);
        int i = tv.getTable().getSelectionIndex();
        tv.remove(lib);
        UserLib slib = null;
        if (i == 0) {
            slib = (UserLib) tv.getElementAt(0);
        } else if (i > 0) {
            slib = (UserLib) tv.getElementAt(i - 1);
        }
        if (slib != null) {
            tv.setSelection(new StructuredSelection(slib));
        }
    }

    @Override
    public void load(Form form) throws Exception {
        prefs = UserLibPreferences.load();
    }

    @Override
    public void store(Form form) throws Exception {
        if (lastEdited != null) {
            saveEditor(lastEdited);
        }
        if (prefs.isModified()) {
            prefs.save();
            NuxeoSDK.reload();
        }
    }

    protected void handleAddAction(Shell shell) {
        FileDialog dlg = new FileDialog(shell);
        String path = dlg.open();
        File file = new File(path);
        UserLib lib = new UserLib(file.getAbsolutePath());

        M2PomModelProvider m2PomModelProvider = new M2PomModelProvider(file.getAbsolutePath());
        try {
            PomModel model = m2PomModelProvider.getPomModel();
            if (model != null) {
                lib.setGroupId(model.getGroupId());
                lib.setArtifactId(model.getArtifactId());
                lib.setVersion(model.getArtifactVersion());
            }
        } catch (Exception e) {
            UI.showError("Failed to parse associated pom", e);
        }

        addUserLib(lib);

    }

    public Button getRemoveButton() {
        return (Button) form.getWidgetControl("remove");
    }

    public Text getClassifier() {
        return (Text) form.getWidgetControl("classifier");
    }

    public Text getArtifactId() {
        return (Text) form.getWidgetControl("artifactId");
    }

    public Text getGroupId() {
        return (Text) form.getWidgetControl("groupId");
    }

    public Text getVersion() {
        return (Text) form.getWidgetControl("version");
    }

    public Text getPath() {
        return (Text) form.getWidgetControl("path");
    }

    public Composite getEditorPanel() {
        return (Composite) form.getWidgetControl("editor");
    }

    public UserLibsWidget getTable() {
        return (UserLibsWidget) form.getWidget("libs");
    }

    protected void addUserLib(UserLib lib) {
        prefs.addUserLib(lib);
        getTable().addUserLib(lib);
        updateEditor(lib);
    }

    protected void updateEditor(UserLib lib) {
        if (lib == null) {
            if (lastEdited != null) {
                saveEditor(lastEdited);
                lastEdited = null;
            }
            getEditorPanel().setEnabled(false);
            getPath().setText("");
            getGroupId().setText("");
            getArtifactId().setText("");
            getVersion().setText("");
            getClassifier().setText("");
        } else {
            lastEdited = lib;
            getEditorPanel().setEnabled(true);
            getPath().setText(lib.getPath());
            String v = lib.getGroupId();
            getGroupId().setText(v == null ? "" : v);
            v = lib.getArtifactId();
            getArtifactId().setText(v == null ? "" : v);
            v = lib.getVersion();
            getVersion().setText(v == null ? "" : v);
            v = lib.getClassifier();
            getClassifier().setText(v == null ? "" : v);
        }
    }

    protected void saveEditor(UserLib lib) {
        String v = getGroupId().getText().trim();
        lib.setGroupId(v.length() > 0 ? v : null);
        v = getArtifactId().getText().trim();
        lib.setArtifactId(v.length() > 0 ? v : null);
        v = getVersion().getText().trim();
        lib.setVersion(v.length() > 0 ? v : null);
        v = getClassifier().getText().trim();
        lib.setClassifier(v.length() > 0 ? v : null);
    }
}
