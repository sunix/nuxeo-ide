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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class FileChooser extends TextChooser {

    public FileChooser(Composite parent) {
        super(parent, "Browse");
    }

    public FileChooser(Composite parent, String btnLabel) {
        super(parent, btnLabel);
    }

    @Override
    protected String changePressed(String path) {
        FileDialog dlg = new FileDialog(getShell(), SWT.OPEN | SWT.SHEET);
        if (path != null && path.length() > 0) {
            dlg.setFilterPath(path.trim());
        }
        return path = dlg.open();
    }

}
