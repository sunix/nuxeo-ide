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
package org.nuxeo.ide.sdk.server.ui;

import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.nuxeo.ide.common.FormPreferencePage;
import org.nuxeo.ide.common.forms.Form;
import org.nuxeo.ide.common.forms.FormData;
import org.nuxeo.ide.sdk.templates.TemplatePrefs;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class TemplatesPreferencePage extends FormPreferencePage implements
        IWorkbenchPreferencePage, FormData {

    protected String copyrightHeader;

    protected String classHeader;

    public TemplatesPreferencePage() {
        super(null);
        setFormData(this);
    }

    @Override
    public void createControl(Composite parent) {
        super.createControl(parent);
        final Text text = (Text) form.getWidgetControl("content");
        final Combo combo = (Combo) form.getWidgetControl("type");
        text.setText(copyrightHeader);
        text.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                if (combo.getSelectionIndex() == 0) {
                    copyrightHeader = text.getText();
                } else {
                    classHeader = text.getText();
                }
            }
        });
        combo.addSelectionListener(new SelectionListener() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (combo.getSelectionIndex() == 0) {
                    text.setText(copyrightHeader);
                } else {
                    text.setText(classHeader);
                }
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
                widgetDefaultSelected(e);
            }
        });
    }

    @Override
    protected void performDefaults() {
        copyrightHeader = null;
        classHeader = null;
        try {
            store(form);
            load(form);
            final Text text = (Text) form.getWidgetControl("content");
            final Combo combo = (Combo) form.getWidgetControl("type");
            if (combo.getSelectionIndex() == 0) {
                text.setText(copyrightHeader);
            } else {
                text.setText(classHeader);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void load(Form form) throws Exception {
        this.copyrightHeader = TemplatePrefs.getCopyrightHeader();
        this.classHeader = TemplatePrefs.getClassHeader();
    }

    @Override
    public void store(Form form) throws Exception {
        TemplatePrefs.setCopyright(copyrightHeader);
        TemplatePrefs.setClassHeader(classHeader);
    }

}
