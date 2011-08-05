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
package org.nuxeo.ide.common.forms.test;

import java.io.InputStream;
import java.util.Properties;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.nuxeo.ide.common.forms.BindingContext;
import org.nuxeo.ide.common.forms.Form;
import org.nuxeo.ide.common.forms.TestErrorHandler;
import org.nuxeo.ide.common.forms.model.ToggleButtonWidget;
import org.w3c.dom.Element;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class Main {

    public static void createContent(Composite parent) throws Exception {

        parent.setLayout(new FillLayout());

        Form form = new Form();
        form.setErrorHandler(new TestErrorHandler());
        form.addBinding("mytoggle", new ToggleButtonWidget() {
            @Override
            protected Button createControl(Composite parent, Element element,
                    BindingContext ctx) {
                Button btn = new Button(parent, SWT.TOGGLE);
                return btn;
            }
        });

        form.load(parent, Main.class.getResource("form.xml"));

        Properties props = new Properties();
        InputStream in = Main.class.getResourceAsStream("form.properties");
        if (in != null) {
            props.load(in);
            form.setValues(props);
        }

    }

    public static void main(String[] args) throws Exception {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setSize(600, 400);

        createContent(shell);

        Monitor primary = display.getPrimaryMonitor();
        Rectangle bounds = primary.getBounds();
        Rectangle rect = shell.getBounds();

        int x = bounds.x + (bounds.width - rect.width) / 2;
        int y = bounds.y + (bounds.height - rect.height) / 2;

        shell.setLocation(x, y);
        // shell.pack();
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
    }
}
