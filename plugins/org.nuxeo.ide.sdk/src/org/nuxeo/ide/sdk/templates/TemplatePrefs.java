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

import java.io.IOException;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.nuxeo.ide.common.IOUtils;
import org.osgi.service.prefs.BackingStoreException;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class TemplatePrefs {

    public static String getCopyrightHeader() throws IOException {
        IEclipsePreferences prefs = new InstanceScope().getNode("nuxeoSDKTemplates");
        String v = prefs.get("copyright", null);
        if (v == null) {
            v = IOUtils.read(TemplatePrefs.class.getResource("copyright.txt"));
        }
        return v.trim();
    }

    public static String getClassHeader() throws IOException {
        IEclipsePreferences prefs = new InstanceScope().getNode("nuxeoSDKTemplates");
        String v = prefs.get("classHeader", null);
        if (v == null) {
            v = IOUtils.read(TemplatePrefs.class.getResource("classHeader.txt"));
        }
        return v.trim();
    }

    public static void setClassHeader(String value)
            throws BackingStoreException {
        IEclipsePreferences prefs = new InstanceScope().getNode("nuxeoSDKTemplates");
        if (value == null) {
            prefs.remove("classHeader");
        } else {
            prefs.put("classHeader", value.trim());
        }
        prefs.flush();
        prefs.sync();
    }

    public static void setCopyright(String value) throws BackingStoreException {
        IEclipsePreferences prefs = new InstanceScope().getNode("nuxeoSDKTemplates");
        if (value == null) {
            prefs.remove("copyright");
        } else {
            prefs.put("copyright", value.trim());
        }
        prefs.flush();
        prefs.sync();
    }

}
