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
package org.nuxeo.ide.connect.features.adapter;

import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.nuxeo.ide.connect.StudioProjectBinding;
import org.nuxeo.ide.connect.studio.DocumentSchema;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class StudioSchemasTable extends Composite {

    protected CheckboxTableViewer tv;

    public StudioSchemasTable(Composite parent) {
        super(parent, SWT.NONE);
        setLayout(new FillLayout());
        createTable();
    }

    public CheckboxTableViewer getTableViewer() {
        return tv;
    }

    protected void createTable() {
        tv = CheckboxTableViewer.newCheckList(this, SWT.BORDER | SWT.H_SCROLL
                | SWT.V_SCROLL);
        SchemaProvider provider = new SchemaProvider();
        tv.setLabelProvider(provider);
        tv.setContentProvider(provider);
    }

    public void setInput(StudioProjectBinding binding) {
        tv.setInput(binding);
    }

    public void setInput(DocumentSchema[] schemas) {
        tv.setInput(schemas);
    }

    public DocumentSchema[] getSelectedSchemas() {
        Object[] ar = tv.getCheckedElements();
        DocumentSchema[] schemas = new DocumentSchema[ar.length];
        System.arraycopy(ar, 0, schemas, 0, ar.length);
        return schemas;
    }

}
