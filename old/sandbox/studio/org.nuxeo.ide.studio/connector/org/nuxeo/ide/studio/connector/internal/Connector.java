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
package org.nuxeo.ide.studio.connector.internal;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * Should be reinstantiated each time URL or login changes.
 *
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 *
 */
public class Connector {

    protected final DefaultHttpClient http;

    protected final HttpHost host;
    
    protected final String basepath;
    
    protected HttpContext authctx;

    public Connector(URL url) {
        host = new HttpHost(url.getHost(), url.getPort());
        basepath = url.getPath();
        http = multiThreadedHttpClient();
        setupHttp();
    }

    private void setupHttp() {
        HttpParams params = http.getParams();
        params.setParameter(ClientPNames.ALLOW_CIRCULAR_REDIRECTS, true);
    }
    
    protected DefaultHttpClient multiThreadedHttpClient() {
        ThreadSafeClientConnManager mgr = new ThreadSafeClientConnManager();
        return new DefaultHttpClient(mgr);
    }

    public void setPreemptiveBasicAuth(String username, String password) {
        UsernamePasswordCredentials upc = new UsernamePasswordCredentials(username, password);
                http.getCredentialsProvider().setCredentials(
                    new AuthScope(host.getHostName(), host.getPort()),
                    upc);
            AuthCache authCache = new BasicAuthCache();                                                                                                                                  
            authCache.put(host, new BasicScheme());
            authctx = new BasicHttpContext();
            authctx.setAttribute(ClientContext.AUTH_CACHE, authCache);
//       HttpGet root = new HttpGet(basepath);
//        try {
//            HttpResponse response = http.execute(host, root, authctx);
//            for (Cookie cookie:http.getCookieStore().getCookies()) {
//                if ("JSESSIONID".equals(cookie.getName()) && "/cas".equals(cookie.getPath())) {
//                    postCAS(response.getEntity(), username, password);
//                }
//            }
//        } catch (Exception e) {
//            throw new Error("Cannot fetch studio root page "
//                    + root.getURI().toASCIIString(), e);
//        }
    }

    protected void postCAS(HttpEntity entity, String username, String password) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
        InputStream input = entity.getContent();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document dom = db.parse(input);
        XPathFactory xpf = XPathFactory.newInstance();
        XPath xp = xpf.newXPath();
        XPathExpression xpe = xp.compile("//*[@id='fm1']");
        String form = xpe.evaluate(dom);
        return;
    }

    public void shutdown() {
        // When HttpClient instance is no longer needed,
        // shut down the connection manager to ensure
        // immediate deallocation of all system resources
        ClientConnectionManager connectionManager = http.getConnectionManager();
        connectionManager.shutdown();
    }

    public InputStream getFeatures(String projectId) {
        return doGet("/projects/" + projectId
                    + "/features");
    }

    public InputStream getProjects() {
        return doGet("/list");
    }

    public File getJar(String projectId) {
        File file = doGetAsFile("/projects/" + projectId
                + "/jar");
        String p = file.getParentFile() + "/" + projectId+".jar";
        File f = new File(p);
        f.delete();
        file.renameTo(f);
        return f;
    }


    protected File doGetAsFile(String path) {
        InputStream in = doGet(path);
        if (in != null) {
            try {
                return saveStream(in);
            } finally {
                closeStream(in);
            }
        }
        return null;
    }
    
    protected InputStream doGet(String path) {
        HttpGet get = new HttpGet(basepath+path);
        try {
            HttpResponse response = http.execute(host, get, authctx);
            HttpEntity entity = response.getEntity();
            if (entity == null) {
                throw new Error("got empty content from " + get.getURI().toASCIIString());
            }
            return entity.getContent();
        } catch (Exception e) {
            throw new Error("Cannot fetch content of "
                    + get.getURI().toASCIIString(), e);
        }
    }

    protected static File saveStream(InputStream in)  {
        File file;
        try {
            file = File.createTempFile("studio-stream", ".tmp");
        } catch (IOException e) {
            throw new Error("Cannot create temp file", e);
        }
        try {
            FileOutputStream out = new FileOutputStream(file);
            try {
                int r;
                byte[] tmp = new byte[1024*1024];
                while ((r = in.read(tmp)) != -1) {
                    out.write(tmp, 0, r);
                }
            } finally {
                closeStream(out);
            }
        } catch (IOException e) {
            throw new Error("Cannot save stream in temporary file", e);
        }
        return file;
    }
    
    public static String readStream(InputStream in) throws IOException {
        int r;
        StringBuilder buf = new StringBuilder();
        byte[] tmp = new byte[4096*4];
        while ((r = in.read(tmp)) != -1) {
            buf.append(new String(tmp, 0, r, "UTF-8"));
        }
        return buf.toString();
    }
    
    public static void closeStream(Closeable stream) {
        try {
            stream.close();
        } catch (IOException e) {
            throw new Error(e.getMessage(), e);
        }
    }
    



}
