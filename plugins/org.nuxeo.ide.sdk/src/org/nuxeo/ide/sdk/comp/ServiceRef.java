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
import org.nuxeo.ide.common.HasImage;
import org.nuxeo.ide.common.HasLabel;
import org.nuxeo.ide.sdk.SDKPlugin;

/**
 * A light weight reference to a service.
 * 
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public final class ServiceRef implements HasLabel, HasImage,
        Comparable<ServiceRef> {

    protected String name;

    protected String component;

    public ServiceRef(String name, String component) {
        this.name = name;
        this.component = component;
    }

    /**
     * The service name
     */
    public String getName() {
        return name;
    }

    /**
     * The component owning that service
     */
    public String getComponent() {
        return component;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == ServiceRef.class) {
            return ((ServiceRef) obj).name.equals(name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public int compareTo(ServiceRef o) {
        return name.compareTo(o.name);
    }

    @Override
    public String getLabel() {
        return name;
    }

    @Override
    public Image getImage() {
        return SDKPlugin.getDefault().getImageRegistry().get(
                "icons/comp/service.gif");
    }

}
