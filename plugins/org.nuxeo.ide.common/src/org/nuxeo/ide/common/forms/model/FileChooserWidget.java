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
package org.nuxeo.ide.common.forms.model;

import java.io.File;

import org.eclipse.swt.widgets.Composite;
import org.nuxeo.ide.common.forms.BindingContext;
import org.nuxeo.ide.common.forms.HasValue;
import org.nuxeo.ide.common.forms.WidgetName;
import org.nuxeo.ide.common.forms.widgets.FileChooser;
import org.w3c.dom.Element;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
@WidgetName("file")
public class FileChooserWidget extends UIValueObject<FileChooser> implements
        HasValue {

    @Override
    protected FileChooser createControl(Composite parent, Element element,
            BindingContext ctx) {
        return new FileChooser(parent);
    }

    @Override
    public void doSetValue(Object value) {
        if (value == null) {
            return;
        }
        File file = null;
        if (value.getClass() == File.class) {
            file = (File) value;
        } else {
            file = new File(value.toString());
        }
        ctrl.setValue(file.getAbsolutePath());
    }

    @Override
    public String getValue() {
        return ctrl.getValue().trim();
    }

    @Override
    public String getValueAsString() {
        return getValue();
    }

}
