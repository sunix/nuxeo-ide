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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;

import org.eclipse.core.runtime.FileLocator;
import org.nuxeo.ide.common.IOUtils;
import org.osgi.framework.Bundle;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class Template {

    public static Template fromString(Bundle bundle, String expr)
            throws ParseException {
        int i = expr.indexOf(';');
        if (i == -1) {
            throw new ParseException("Missing template attributes in " + expr,
                    i);
        }
        String name = expr.substring(0, i);
        Template temp = new Template(bundle, name);
        i = parseAttribute(temp, expr, i + 1);
        if (i == -1) {
            return temp;
        }
        parseAttribute(temp, expr, i);
        return temp;
    }

    private static int parseAttribute(Template temp, String expr, int i)
            throws ParseException {
        int k = expr.indexOf('=', i);
        if (k <= i) {
            throw new ParseException("Missing '=' in " + expr, i);
        }
        if (expr.charAt(k - 1) == ':') {
            k--;
        }
        int r = -1;
        String value = null;
        String key = expr.substring(i, k).trim();
        k++;
        int j = expr.indexOf(';', k);
        if (j == -1) {
            value = expr.substring(k).trim();
        } else {
            value = expr.substring(k, j).trim();
            r = j + 1;
            if (r >= expr.length()) {
                r = -1;
            }
        }
        if (key.equals("path")) {
            temp.path = value;
        } else if (key.equals("version")) {
            temp.version = value;
        }
        return r;
    }

    protected String name;

    protected Bundle bundle;

    protected String path;

    protected String version;

    private Template(Bundle bundle, String name) {
        this(bundle, name, null);
    }

    public Template(Bundle bundle, String name, String path) {
        this.bundle = bundle;
        this.name = name;
        this.path = path;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public void copyTo(File dir) throws IOException {
        if (path.endsWith(".zip")) {
            URL url = bundle.getEntry(path);
            if (url == null) {
                throw new FileNotFoundException("Template " + name
                        + " not found in bundle " + bundle.getSymbolicName()
                        + " at " + path);
            }
            InputStream in = url.openStream();
            try {
                IOUtils.unzip(in, dir);
            } finally {
                in.close();
            }
        } else {
            File bundleFile = FileLocator.getBundleFile(bundle);
            if (bundleFile.isDirectory()) {
                IOUtils.copyTree(new File(bundleFile, path), dir);
            } else {
                IOUtils.unzip(bundleFile, path, dir);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append(bundle == null ? "null" : bundle.getSymbolicName()).append(
                ": ").append(name).append(";path=").append(path);
        if (version != null) {
            buf.append(";version=").append(version);
        }
        return buf.toString();
    }

}
