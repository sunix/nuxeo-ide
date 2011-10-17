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
package org.nuxeo.ide.sdk.comp;

import java.io.File;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.ListenerList;
import org.nuxeo.ide.common.IOUtils;
import org.nuxeo.ide.sdk.NuxeoSDK;
import org.nuxeo.ide.sdk.SDKInfo;
import org.nuxeo.ide.sdk.SDKPlugin;
import org.nuxeo.ide.sdk.server.ServerConstants;
import org.nuxeo.ide.sdk.server.ServerController;
import org.nuxeo.ide.sdk.server.ServerLifeCycleAdapter;

/**
 * Manage Nuxeo components declared on server
 * <p>
 * TODO should take into account the local (i.e workspace) component too.
 * 
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class ComponentIndexManager extends ServerLifeCycleAdapter {

    protected volatile ComponentIndex index;

    protected File root;

    protected File cacheDir;

    protected Map<String, File> filesCache;

    protected ComponentLoader loader;

    protected Random random;

    protected ListenerList listeners;

    public ComponentIndexManager(File root) {
        random = new Random();
        this.root = root;
        this.cacheDir = SDKPlugin.getDefault().getContext().getDataFile(
                "component_files");
        cacheDir.mkdirs();
        filesCache = new Hashtable<String, File>();
        loader = new ComponentLoader();
        listeners = new ListenerList();
    }

    public void destroy() {
        flushCache();
        root = null;
        loader = null;
        cacheDir = null;
        random = null;
        listeners = null;
    }

    public synchronized void flushCache() {
        index = null;
        filesCache = new Hashtable<String, File>();
        IOUtils.deleteTree(cacheDir);
        cacheDir.mkdirs();
    }

    public ComponentIndex getIndex() {
        ComponentIndex _index = index;
        if (_index == null) {
            synchronized (this) {
                index = ComponentIndex.load(new File(root,
                        SDKInfo.SDK_COMPONENTS_PATH));
                _index = index;
            }
        }
        return _index;
    }

    public ComponentLoader getLoader() {
        return loader;
    }

    public ComponentModel getComponent(ComponentRef ref) throws Exception {
        File file = getComponentFile(ref);
        if (file == null) {
            return null;
        }
        ComponentModel model = loader.loadComponent(file);
        model.bundle = ref.getBundle();
        model.src = ref.getSrc();
        return model;
    }

    public File getComponentFile(ComponentRef ref) {
        return getComponentFile(ref.getSrc());
    }

    public File getComponentFile(ComponentModel component) {
        return getComponentFile(component.getSrc());
    }

    public File getComponentFile(String src) {
        if (src == null || src.length() == 0) {
            return null;
        }
        File file = filesCache.get(src);
        if (file == null) {
            try {
                file = locateFile(src);
                if (file != null) {
                    filesCache.put(src, file);
                }
            } catch (Exception e) {
                SDKPlugin.log(IStatus.ERROR,
                        "Failed to lookup component file: " + src, e);
            }
        }
        return file;
    }

    public File locateFile(String src) throws Exception {
        int i = src.indexOf('!');
        // TODO this will not work for now for the cloud version.
        if (i == -1) {
            // TODO: open the file when Nuxeo SDK is in the local file system
            File config = new File(
                    NuxeoSDK.getDefault().getInfo().getInstallDirectory(),
                    "nxserver/config");
            File file = new File(config, src);
            if (!file.isFile()) {
                return null;
            } else {
                return file;
            }
        }
        String jar = src.substring(0, i);
        String path = src.substring(i + 1);
        File nxserver = new File(
                NuxeoSDK.getDefault().getInfo().getInstallDirectory(),
                "nxserver");
        File bundles = new File(nxserver, "bundles");
        File file = new File(bundles, jar);
        if (!file.exists()) {
            bundles = new File(nxserver, "plugins");
            file = new File(bundles, jar);
            if (!file.exists()) {
                return null;
            }
        }
        if (file.isFile()) { // a JAR
            ZipFile zip = new ZipFile(file);
            if (path.startsWith("/")) {
                path = path.substring(1);
            }
            ZipEntry entry = zip.getEntry(path);
            if (entry == null) {
                return null;
            } else {
                InputStream in = zip.getInputStream(entry);
                try {
                    int next = random.nextInt();
                    String prefix = Integer.toHexString(next);
                    int s = path.lastIndexOf('/');
                    if (s > -1) {
                        path = path.substring(s + 1);
                    }
                    File tmp = new File(cacheDir, prefix + "_" + path);
                    IOUtils.copyToFile(in, tmp, true);
                    return tmp;
                } finally {
                    zip.close();
                }
            }
        } else {
            return file;
        }
    }

    @Override
    public void serverStateChanged(ServerController ctrl, int state) {
        if (state == ServerConstants.STARTED) {
            flushCache();
            fireComponentIndexChanged();
        }
    }

    protected void fireComponentIndexChanged() {
        for (Object listener : listeners.getListeners()) {
            ((ComponentIndexChangedListener) listener).componentIndexChanged(this);
        }
    }

    public void addComponentIndexChangedListener(
            ComponentIndexChangedListener listener) {
        listeners.add(listener);
    }

    public void removeComponentIndexChangedListener(
            ComponentIndexChangedListener listener) {
        listeners.remove(listener);
    }

}
