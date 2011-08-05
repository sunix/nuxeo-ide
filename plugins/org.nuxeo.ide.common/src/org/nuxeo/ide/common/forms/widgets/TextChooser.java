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
package org.nuxeo.ide.common.forms.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public abstract class TextChooser extends Composite {

    protected Text text;

    protected Button btn;

    public TextChooser(Composite parent) {
        this(parent, "Choose");
    }

    public TextChooser(Composite parent, String btnLabel) {
        super(parent, SWT.NONE);
        createControl(btnLabel);
    }

    protected void createControl(String btnLabel) {
        GridLayout layout = new GridLayout();
        layout.numColumns = 2;
        setLayout(layout);
        text = new Text(this, SWT.BORDER);
        GridData gd = new GridData();
        gd.horizontalAlignment = SWT.FILL;
        gd.grabExcessHorizontalSpace = true;
        text.setLayoutData(gd);

        btn = new Button(this, SWT.NONE);
        btn.setText(btnLabel);
        btn.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                String r = changePressed(text.getText().trim());
                if (r != null) {
                    text.setText(r);
                }
            }
        });
    }

    protected abstract String changePressed(String path);

    public String getValue() {
        return text.getText();
    }

    public void setValue(String value) {
        text.setText(value);
    }
}
