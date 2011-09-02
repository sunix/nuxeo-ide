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
package org.nuxeo.ide.connect;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.eclipse.core.internal.preferences.Base64;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.nuxeo.ide.common.IOUtils;
import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.connect.studio.StudioProject;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class Connector {

    public final static String DEFAULT_URL = "http://localhost:8080/nuxeo/site/studio/api";

    // private final static String DEFAULT_URL =
    // "https://connect.nuxeo.com/nuxeo/site/studio/api";

    protected URL url;

    public Connector(String url) throws MalformedURLException {
        this(new URL(url));
    }

    public Connector(URL url) {
        this.url = url;
    }

    public Connector() throws MalformedURLException {
        this(DEFAULT_URL);
    }

    public URL getUrl() {
        return url;
    }

    public List<StudioProject> getProjects(String user, String pwd)
            throws IOException {
        String auth = basicAuth(user, pwd);
        URL url = new URL(this.url, "api/projects");
        URLConnection conn = url.openConnection();
        conn.setDoInput(true);
        conn.setDoOutput(false);
        conn.setRequestProperty("Authorization", "Basic " + auth);
        InputStream in = conn.getInputStream();
        try {
            return StudioProject.readProjects(in);
        } finally {
            in.close();
        }
    }

    public static String getProjectContent(String projectId) throws Exception {
        ConnectPreferences prefs = ConnectPreferences.load();
        String user = prefs.getUsername();
        String pwd = prefs.getPassword();
        String host = prefs.getHost();
        if (user == null || host == null) {
            return null;
        }
        String auth = basicAuth(user, pwd);
        URL url = new URL(new URL(host), "api/projects/" + projectId);
        URLConnection conn = url.openConnection();
        conn.setDoInput(true);
        conn.setDoOutput(false);
        conn.setRequestProperty("Authorization", "Basic " + auth);
        InputStream in = conn.getInputStream();
        return IOUtils.read(in);
    }

    public static void writeStudioProject(IProject project, String projectId)
            throws Exception {
        String content = getProjectContent(projectId);
        IFile file = project.getFile("studio.project");
        if (content == null) {
            UI.showError("No such studio project: " + projectId);
            return;
        }
        ByteArrayInputStream in = new ByteArrayInputStream(
                content.getBytes("UTF-8"));
        if (file.exists()) {
            file.setContents(in, true, true, new NullProgressMonitor());
        } else {
            file.create(in, true, new NullProgressMonitor());
        }
    }

    public static boolean exportOperationRegistry(String projectId, String reg)
            throws Exception {
        ConnectPreferences prefs = ConnectPreferences.load();
        String user = prefs.getUsername();
        String pwd = prefs.getPassword();
        String host = prefs.getHost();
        if (user == null || host == null) {
            return false;
        }
        String auth = basicAuth(user, pwd);
        URL url = new URL(new URL(host), "api/projects/" + projectId
                + "/operations");
        URLConnection conn = url.openConnection();
        conn.setRequestProperty("Content-Type", "application/studio-registry");
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestProperty("Authorization", "Basic " + auth);
        OutputStream out = conn.getOutputStream();
        out.write(reg.getBytes("UTF-8"));
        out.flush();
        int status = ((HttpURLConnection) conn).getResponseCode();
        out.close();
        if (status > 399) {
            throw new RuntimeException("Server Error: " + status);
        }
        return true;
    }

    public static String basicAuth(String username, String pwd) {
        return new String(Base64.encode((username + ":" + pwd).getBytes()));
    }

}
