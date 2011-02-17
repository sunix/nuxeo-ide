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
package org.nuxeo.ide.studio.ui;

import org.eclipse.jface.resource.ImageDescriptor;
import org.nuxeo.ide.studio.StudioIDEPlugin;

/**
 * @author eugen
 *
 */
public class Icons {

    public static final String ACTION_DIR = "/icons/action/";

    public static final String ACTION_EXPAND_ALL = ACTION_DIR + "expand_all.gif";

    public static final String ACTION_COLLAPSE_ALL = ACTION_DIR + "collapse_all.gif";

    public static final String ACTION_CONNECT = ACTION_DIR + "connect.png";

    public static ImageDescriptor getIcon(String iconPath) {
        return StudioIDEPlugin.getImageDescriptor(iconPath);
    }

}
