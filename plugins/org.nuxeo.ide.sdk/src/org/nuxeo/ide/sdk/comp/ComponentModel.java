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
import org.nuxeo.ide.sdk.SDKPlugin;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class ComponentModel implements IViewItem {

    public final static ServiceModel[] EMPTY_SERVICES = new ServiceModel[0];

    public final static ExtensionPointModel[] EMPTY_XPOINTS = new ExtensionPointModel[0];

    protected String name;

    protected String bundle;

    protected String impl;

    protected String src;

    protected String version;

    protected String documentation;

    protected ServiceModel[] services;

    protected ExtensionPointModel[] xpoints;

    protected ExtensionModel[] extensions;

    public ComponentModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getBundle() {
        return bundle;
    }

    public String getDocumentation() {
        return documentation;
    }

    public String getSrc() {
        return src;
    }

    public String getImpl() {
        return impl;
    }

    public String getVersion() {
        return version;
    }

    public ServiceModel[] getServices() {
        return services;
    }

    public ExtensionPointModel[] getExtensionPoints() {
        return xpoints;
    }

    public ExtensionModel[] getExtensions() {
        return extensions;
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
        if (obj instanceof ComponentModel) {
            return name.equals(((ComponentModel) obj).name);
        }
        return false;
    }

    @Override
    public Object[] getChildren() {
        Object[] ar = new Object[services.length + xpoints.length];
        if (services.length > 0) {
            System.arraycopy(services, 0, ar, 0, services.length);
        }
        if (xpoints.length > 0) {
            System.arraycopy(xpoints, 0, ar, services.length, xpoints.length);
        }
        return ar;
    }

    @Override
    public String getLabel() {
        return name;
    }

    @Override
    public Object getParent() {
        return null;
    }

    @Override
    public Image getImage() {
        return SDKPlugin.getDefault().getImageRegistry().get(
                "icons/comp/component.gif");
    }

    @Override
    public boolean hasChildren() {
        return services.length + xpoints.length > 0;
    }

}
