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
package org.nuxeo.ide.connect;

import java.io.File;

import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.nuxeo.ide.common.Activator;
import org.nuxeo.ide.common.forms.ActionHandler;
import org.nuxeo.ide.common.forms.FileFormData;
import org.nuxeo.ide.common.forms.Form;
import org.nuxeo.ide.common.forms.FormPreferencePage;
import org.nuxeo.ide.common.forms.UIObject;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class ConnectPreferencePage extends FormPreferencePage implements
        IWorkbenchPreferencePage {

    @Override
    protected Form createForm() {
        Form form = new Form();
        form.addActionHandler("connect", new ActionHandler() {
            @Override
            public void handleAction(Form form, UIObject<?> obj, Object event) {
                System.out.println("Do connect and update projects");
            }
        });
        form.addActionHandler("reset", new ActionHandler() {
            @Override
            public void handleAction(Form form, UIObject<?> obj, Object event) {
                System.out.println("Reset connect account and remove projects");
            }
        });
        return form;
    }

    @Override
    public void init(IWorkbench workbench) {
        File file = Activator.getDefault().getContext().getDataFile(
                "connect.properties");
        data = new FileFormData(file);
    }

}
