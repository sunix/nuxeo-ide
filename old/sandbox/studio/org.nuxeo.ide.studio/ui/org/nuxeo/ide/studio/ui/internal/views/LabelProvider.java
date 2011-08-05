/*
 * (C) Copyright 2011 Nuxeo SA (http://nuxeo.com/) and contributors.
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
 *     eugen
 */
package org.nuxeo.ide.studio.ui.internal.views;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.nuxeo.ide.studio.ui.internal.actions.ActionIcons;
import org.nuxeo.ide.studio.ui.internal.tree.Node;

/**
 * @author eugen
 *
 */
public class LabelProvider extends org.eclipse.jface.viewers.LabelProvider {

    public String getText(Object obj) {
        return obj.toString();
    }
    public Image getImage(Object obj) {
        String imageKey = ((Node)obj).getIcon();
        if (imageKey == null) {
            return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
        }
        ImageDescriptor img = ActionIcons.getIcon(imageKey);
        if (img == null) {
            return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
        }
        return img.createImage();
    }

}
