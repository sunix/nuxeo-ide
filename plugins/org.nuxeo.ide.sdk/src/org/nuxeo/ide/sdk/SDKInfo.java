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
import org.nuxeo.ide.sdk.server.ServerConfiguration;
import org.nuxeo.ide.sdk.server.VMUtils;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class SDKInfo {

    public static final String SDK_PATH = "sdk";

    public static final String SDK_SOURCES_PATH = "sdk/sources";

    public static final String SDK_TESTS_PATH = "sdk/tests";

    public static final String SDK_DISTRIB_PATH = "sdk/distribution.properties";

    public static final String SDK_ARTIFACTS_FILE = "artifacts.properties";

    public static final String SDK_ARTIFACTS_PATH = "sdk/artifacts.properties";

    public static final String SDK_TEST_ARTIFACTS_FILE = "test-artifacts.properties";

    public static final String SDK_TEST_ARTIFACTS_PATH = "sdk/test-artifacts.properties";

    protected String id;

    protected String name;

    protected String version;

    protected String path;

    public SDKInfo(String path, String name, String version) {
        this.name = name;
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

    public SDKInfo(File installFile, String name, String version) {
        this(installFile.getAbsolutePath(), name, version);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return new StringBuilder(64).append(name).append(" ").append(version).toString();
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
        // create the SDK dir if not exists
        file = new File(root, SDK_PATH);
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
            // if (line.contains("dt_socket") && line.startsWith("#")) {
            // lines.set(i, line.substring(1));
            // } else
            if (line.contains("nuxeo.templates")) {
                lines.set(i, "nuxeo.templates=default,sdk");
            } else if (line.contains("nuxeo.wizard.done=")) {
                lines.set(i, "nuxeo.wizard.done=true");
            }

        }
        IOUtils.writeLines(sdkConf, lines);
    }

    public static ProcessBuilder newProcessBuilder(File installRoot,
            String command, boolean isDebug) throws Exception {
        ProcessBuilder builder = new ProcessBuilder(
                VMUtils.getJavaExecutablePath());
        ServerConfiguration config = ServerConfiguration.getDefault();
        String vmargs = config.getVmArgs(isDebug);
        if (vmargs != null) {
            builder.command().add("-Dlauncher.java.opts=" + vmargs);
        }
        builder.command().add("-Dnuxeo.home=" + installRoot.getAbsolutePath());
        builder.command().add(
                "-Dnuxeo.conf="
                        + new File(installRoot, "bin/nuxeo-sdk.conf").getAbsolutePath());
        builder.command().add(
                "-Dnuxeo.log.dir="
                        + new File(installRoot, "log").getAbsolutePath());
        builder.command().add("-jar");
        builder.command().add(
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
        File file = new File(dir, SDK_DISTRIB_PATH);
        String version = null;
        String name = "Nuxeo SDK";
        if (file.isFile()) {
            Properties props = new Properties();
            FileInputStream in = new FileInputStream(file);
            try {
                props.load(in);
            } finally {
                in.close();
            }
            version = props.getProperty("org.nuxeo.distribution.version",
                    "0.0.0");
            name = props.getProperty("org.nuxeo.distribution.name", name);
        } else {
            version = getVersionFromBundles(new File(dir, "nxserver/bundles"));
        }
        if (version == null) {
            throw new FileNotFoundException("Not a Nuxeo SDK: " + dir);
        }
        SDKInfo sdk = new SDKInfo(dir, name, version);
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
