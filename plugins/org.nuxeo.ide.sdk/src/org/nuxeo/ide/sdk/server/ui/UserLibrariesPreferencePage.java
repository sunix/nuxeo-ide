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

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.nuxeo.ide.common.FormPreferencePage;
import org.nuxeo.ide.common.forms.Form;
import org.nuxeo.ide.common.forms.FormData;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class UserLibrariesPreferencePage extends FormPreferencePage implements
        IWorkbenchPreferencePage, FormData {

    public UserLibrariesPreferencePage() {
        super(null);
        setFormData(this);
    }

    @Override
    public void createControl(Composite parent) {
        super.createControl(parent);
    }

    @Override
    public void load(Form form) throws Exception {
        // TODO
    }

    @Override
    public void store(Form form) throws Exception {
        // TODO
    }

}
