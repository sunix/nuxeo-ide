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
package org.nuxeo.ide.common;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class BundleImageProvider {

    protected Bundle bundle;

    protected Map<String, Image> images;

    public BundleImageProvider(Bundle bundle) {
        this.bundle = bundle;
        images = new HashMap<String, Image>();
    }

    public Image getImage(String path) {
        Image img = images.get(path);
        if (img == null) {
            URL url = bundle.getEntry(path);
            if (url != null) {
                img = ImageDescriptor.createFromURL(url).createImage();
                if (img != null) {
                    images.put(path, img);
                }
            }
        }
        return img;
    }

    public ImageDescriptor getImageDescriptor(String path) {
        URL url = bundle.getEntry(path);
        if (url != null) {
            return ImageDescriptor.createFromURL(url);
        }
        return null;
    }

    public void dispose() {
        if (images != null) {
            for (Image img : images.values()) {
                img.dispose();
            }
            images = null;
            bundle = null;
        }
    }

}
