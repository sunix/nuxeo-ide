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
package org.nuxeo.ide.sdk.deploy;

import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.sdk.userlibs.UserLib;
import org.nuxeo.ide.sdk.userlibs.UserLibPreferences;
import org.nuxeo.ide.sdk.userlibs.UserLibViewProvider;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class UserLibCheckList extends Composite {

    protected CheckboxTableViewer tv;

    public UserLibCheckList(Composite parent) {
        super(parent, SWT.NONE);
        createControl();
    }

    public CheckboxTableViewer getTableViewer() {
        return tv;
    }

    protected void createControl() {
        setLayout(new FillLayout());
        tv = CheckboxTableViewer.newCheckList(this, SWT.BORDER | SWT.H_SCROLL
                | SWT.V_SCROLL);

        UserLibViewProvider provider = new UserLibViewProvider();
        tv.setLabelProvider(provider);
        tv.setContentProvider(provider);

        try {
            tv.setInput(UserLibPreferences.load());
        } catch (Exception e) {
            UI.showError("Failed to load User libraries", e);
        }

    }

    public void setCheckedLibs(UserLib[] libs) {
        tv.setCheckedElements(libs);
    }

    public UserLib[] getCheckedLibs() {
        Object[] ar = tv.getCheckedElements();
        UserLib[] result = new UserLib[ar.length];
        System.arraycopy(ar, 0, result, 0, ar.length);
        return result;
    }

}
