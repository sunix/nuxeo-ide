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
package org.nuxeo.ide.sdk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Properties;

import org.nuxeo.ide.common.UI;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class SDKInfo {

    protected String id;

    protected String version;

    protected String path;

    public SDKInfo(String path, String version) {
        this.path = path;
        this.version = version;
        String rawid = new StringBuilder(256).append(version).append('#').append(
                path).toString();
        try {
            // the id should not contain '/' so we encode it.
            this.id = URLEncoder.encode(rawid, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            UI.showError("UTF-8 not supported for enconding IDs", e);
        }
    }

    public SDKInfo(File installFile, String version) {
        this(installFile.getAbsolutePath(), version);
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public String getPath() {
        return path;
    }

    public File getInstallDirectory() {
        return new File(path);
    }

    public String getTitle() {
        return "Nuxeo SDK ".concat(version);
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SDKInfo) {
            return ((SDKInfo) obj).id.equals(id);
        }
        return false;
    }

    public static SDKInfo loadSDK(File dir) throws IOException {
        if (!dir.isDirectory()) {
            throw new FileNotFoundException(
                    "The given file is not a directory: " + dir);
        }
        File file = new File(dir, "nxserver/config/nuxeo.properties");
        String version = null;
        if (file.isFile()) {
            Properties props = new Properties();
            FileInputStream in = new FileInputStream(file);
            try {
                props.load(in);
            } finally {
                in.close();
            }
            version = props.getProperty("org.nuxeo.ecm.product.version",
                    "0.0.0");
        } else {
            version = getVersionFromBundles(new File(dir, "nxserver/bundles"));
        }
        if (version == null) {
            throw new FileNotFoundException("Not a Nuxeo SDK: " + dir);
        }
        SDKInfo sdk = new SDKInfo(dir, version);
        // TODO sdk.index();
        return sdk;
    }

    public static String getVersionFromBundles(File bundles) {
        String[] list = bundles.list();
        if (list == null) {
            return null;
        }
        for (String name : list) {
            if (name.startsWith("nuxeo-common-") && name.endsWith(".jar")) {
                return name.substring("nuxeo-common-".length(), name.length()
                        - ".jar".length());
            }
        }
        return null;
    }

}
