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
package org.nuxeo.ide.sdk.ui.widgets;

import org.eclipse.core.runtime.ListenerList;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.nuxeo.ide.common.forms.HasText;
import org.nuxeo.ide.sdk.comp.ServiceModel;
import org.nuxeo.ide.sdk.ui.BotHelper;


/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class ServiceChooser extends Composite implements HasText {

    public static interface ValueChangedListener {
        void valueChanged(ServiceChooser source, String oldValue, String newValue);
    }

    protected Text text;

    protected Button btn;

    protected ListenerList listeners;
    

    public ServiceChooser(Composite parent) {
        this(parent, "Browse");
    }

    /**
     * @wbp.parser.constructor
     */
    public ServiceChooser(Composite parent, String btnLabel) {
        super(parent, SWT.NONE);
        listeners = new ListenerList();
        createControl(btnLabel);
    }

    protected Text createText() {
        return new Text(this, SWT.BORDER);
    }

    protected void createControl(String btnLabel) {
        GridLayout layout = new GridLayout();
        layout.marginHeight = 0;
        layout.marginWidth = 0;
        layout.horizontalSpacing = 0;
        layout.verticalSpacing = 2;
        layout.numColumns = 2;
        setLayout(layout);
        text = createText();
        GridData gd = new GridData();
        gd.horizontalAlignment = SWT.FILL;
        gd.grabExcessHorizontalSpace = true;
        text.setLayoutData(gd);

        btn = new Button(this, SWT.NONE);
        btn.setText(btnLabel);
        btn.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                String v = changePressed(getValue());
                if (v != null) {
                    setValue(v);
                }
            }
        });
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                text.setFocus();
            }
        });
        BotHelper.setOwner(text, this);
        BotHelper.setOwner(btn, this);
    }

    public String getValue() {
        return this.text.getText().trim();
    }

    public void setValue(String value) {
        setText(value);
    }

    public void setText(String text) {
        if (text == null) {
            text = "";
        }
        String oldtext = this.text.getText().trim();
        if (oldtext.equals(text)) {
            return;
        }
        this.text.setText(text);
        fireValueChanged(oldtext, text);
    }

    public String getText() {
        String v = text.getText().trim();
        return v.length() == 0 ? null : v;
    }

    protected void fireValueChanged(String oldValue, String newValue) {
        for (Object l : listeners.getListeners()) {
            ((ValueChangedListener) l).valueChanged(this, oldValue, newValue);
        }
    }

    public void addValueChangedListener(ValueChangedListener listener) {
        listeners.add(listener);
    }

    public void removeValueChangedListener(ValueChangedListener listener) {
        listeners.remove(listener);
    }


    public String changePressed(String value) {
        ServiceChooserDialog dialog = new ServiceChooserDialog(this.getShell());
        int status = dialog.open();
        if (status == Dialog.CANCEL) {
            return value;
        }
        return ((ServiceModel)dialog.getResult()[0]).getName();
    }

}
