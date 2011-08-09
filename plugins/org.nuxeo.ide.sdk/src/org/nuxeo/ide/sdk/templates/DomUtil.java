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
package org.nuxeo.ide.sdk.templates;

import org.w3c.dom.Element;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class DomUtil {

    public static String getAttribute(Element element, String key) {
        return getAttribute(element, key, null);
    }

    public static String getAttribute(Element element, String key,
            String defValue) {
        String v = element.getAttribute(key);
        return v.length() == 0 ? defValue : v;
    }

    public static boolean getBooleanAttribute(Element element, String key,
            boolean defValue) {
        String v = element.getAttribute(key);
        return v.length() == 0 ? defValue : Boolean.parseBoolean(v);
    }

}
