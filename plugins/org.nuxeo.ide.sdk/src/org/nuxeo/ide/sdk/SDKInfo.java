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
import java.util.List;
import java.util.Properties;

import org.nuxeo.ide.common.IOUtils;
import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.sdk.server.VMUtils;

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

    public void applyPatch() throws IOException {
        File root = getInstallDirectory();
        // be sure nuxeoctl is executable
        File file = new File(root, "bin/nuxeoctl");
        file.setExecutable(true);
        // create the nxserver/sdk dir if not exists
        file = new File(root, "nxserver/sdk");
        file.mkdirs();
        // generate sdk conf if needed
        File sdkConf = new File(root, "bin/nuxeo-sdk.conf");
        if (!sdkConf.isFile()) {
            generateSDKConf(new File(root, "bin/nuxeo.conf"), sdkConf);
        }
        // create the SDK template if not exists
        File sdkTemp = new File(root, "templates/sdk");
        if (!sdkTemp.isDirectory()) {
            generateSDKTemplate(new File(root, "templates/default"), sdkTemp);
        }
    }

    protected void generateSDKTemplate(File defTemp, File sdkTemp)
            throws IOException {
        sdkTemp.mkdirs();
        File src = new File(defTemp, "conf/Catalina/localhost/nuxeo.xml");
        File dst = new File(sdkTemp, "conf/Catalina/localhost/nuxeo.xml");
        dst.getParentFile().mkdirs();
        String content = IOUtils.readFile(src);
        content = content.replace(
                "org.nuxeo.runtime.tomcat.NuxeoWebappClassLoader",
                "org.nuxeo.runtime.tomcat.dev.NuxeoDevWebappClassLoader");
        IOUtils.writeFile(dst, content);
    }

    protected void generateSDKConf(File conf, File sdkConf) throws IOException {
        List<String> lines = IOUtils.readLines(conf);
        for (int i = 0, len = lines.size(); i < len; i++) {
            String line = lines.get(i).trim();
            if (line.contains("dt_socket") && line.startsWith("#")) {
                lines.set(i, line.substring(1));
            } else if (line.contains("nuxeo.templates")) {
                lines.set(i, "nuxeo.templates=default,sdk");
            }
        }
        IOUtils.writeLines(sdkConf, lines);
    }

    public static ProcessBuilder newProcessBuilder(File installRoot,
            String command) {
        ProcessBuilder builder = new ProcessBuilder(
                VMUtils.getJavaExecutablePath(),
                "-Dnuxeo.home=" + installRoot.getAbsolutePath(),
                "-Dnuxeo.conf="
                        + new File(installRoot, "bin/nuxeo-sdk.conf").getAbsolutePath(),
                "-jar",
                new File(installRoot, "bin/nuxeo-launcher.jar").getAbsolutePath());
        if (command != null) {
            builder.command().add(command);
        }
        builder.directory(new File(installRoot, "bin"));
        return builder;
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
        sdk.applyPatch();
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
