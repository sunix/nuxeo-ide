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
package org.nuxeo.ide.sdk.comp;

import org.eclipse.swt.graphics.Image;
import org.nuxeo.ide.common.IViewItem;
import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.sdk.SDKPlugin;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class ServiceModel implements IViewItem {

    protected String name;

    protected ComponentModel component;

    public ServiceModel(ComponentModel component, String name) {
        this.component = component;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ComponentModel getComponent() {
        return component;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ExtensionPointModel) {
            return name.equals(((ExtensionPointModel) obj).name);
        }
        return false;
    }

    @Override
    public Object[] getChildren() {
        return UI.EMPTY_OBJECTS;
    }

    @Override
    public String getLabel() {
        return name;
    }

    @Override
    public Object getParent() {
        return component;
    }

    @Override
    public Image getImage() {
        return SDKPlugin.getDefault().getImageRegistry().get(
                "icons/comp/service.gif");
    }

    @Override
    public boolean hasChildren() {
        return false;
    }

}
