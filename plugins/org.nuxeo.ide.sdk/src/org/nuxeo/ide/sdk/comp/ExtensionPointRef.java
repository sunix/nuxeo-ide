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
 * A light weight reference to an extension point.
 * 
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public final class ExtensionPointRef implements HasLabel, HasImage,
        Comparable<ExtensionPointRef> {

    protected String id;

    protected String name;

    protected String component;

    public ExtensionPointRef(String name, String component) {
        this.name = name;
        this.component = component;
        this.id = name + "#" + component;
    }

    /**
     * Extension point ID. (i.e. component#xpointName)
     * 
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * The extension point name
     */
    public String getName() {
        return name;
    }

    /**
     * The component owning that extension point
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
        if (obj.getClass() == ExtensionPointRef.class) {
            return ((ExtensionPointRef) obj).id.equals(id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public int compareTo(ExtensionPointRef o) {
        return id.compareTo(o.id);
    }

    @Override
    public String getLabel() {
        return id;
    }

    @Override
    public Image getImage() {
        return SDKPlugin.getDefault().getImageRegistry().get(
                "icons/comp/xpoint.gif");
    }

}
