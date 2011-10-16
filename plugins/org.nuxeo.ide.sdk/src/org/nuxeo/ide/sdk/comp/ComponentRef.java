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

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;
import org.nuxeo.ide.common.HasImage;
import org.nuxeo.ide.common.HasLabel;
import org.nuxeo.ide.sdk.SDKPlugin;

/**
 * A light weight reference to a component.
 * 
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public final class ComponentRef implements HasLabel, HasImage, IEditorInput,
        Comparable<ComponentRef> {

    protected String name;

    protected String bundle;

    protected String src;

    public ComponentRef(String name, String bundle, String src) {
        this.name = name;
        this.bundle = bundle;
        this.src = src;
    }

    /**
     * The component name
     */
    public String getName() {
        return name;
    }

    /**
     * The bundle declaring that component
     * 
     * @return
     */
    public String getBundle() {
        return bundle;
    }

    /**
     * The source file in the format jarName!path or path for global
     * configuration components
     */
    public String getSrc() {
        return src;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == ComponentRef.class) {
            return ((ComponentRef) obj).name.equals(name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public int compareTo(ComponentRef o) {
        return name.compareTo(o.name);
    }

    @Override
    public Image getImage() {
        return SDKPlugin.getDefault().getImageRegistry().get(
                "icons/comp/component.gif");
    }

    @Override
    public String getLabel() {
        return name;
    }

    @Override
    public boolean exists() {
        return false;
    }

    @Override
    public ImageDescriptor getImageDescriptor() {
        return SDKPlugin.getDefault().getImageRegistry().getDescriptor(
                "icons/comp/component.gif");
    }

    @Override
    public IPersistableElement getPersistable() {
        return null;
    }

    @Override
    public String getToolTipText() {
        return getLabel();
    }

    @Override
    public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
        if (adapter == ComponentRef.class) {
            return this;
        }
        return null;
    }

}
