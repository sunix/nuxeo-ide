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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.nuxeo.ide.sdk.SDKPlugin;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class ComponentIndex {

    protected ComponentRef[] components;

    protected ServiceRef[] services;

    protected ExtensionPointRef[] xpoints;

    private ComponentIndex() {
    }

    public static ComponentIndex load(File file) {
        ComponentIndex index = new ComponentIndex();
        Loader loader = null;
        try {
            loader = new Loader();
            loader.load(file);
            index.components = loader.components.toArray(new ComponentRef[loader.components.size()]);
            index.services = loader.services.toArray(new ServiceRef[loader.services.size()]);
            index.xpoints = loader.xpoints.toArray(new ExtensionPointRef[loader.xpoints.size()]);
            Arrays.sort(index.components);
            Arrays.sort(index.services);
            Arrays.sort(index.xpoints);
        } catch (Throwable e) {
            index.components = new ComponentRef[0];
            index.services = new ServiceRef[0];
            index.xpoints = new ExtensionPointRef[0];
            SDKPlugin.log(IStatus.ERROR, "Failed to load components index", e);
        }
        return index;
    }

    public ComponentRef getComponent(String name) {
        int i = Arrays.binarySearch(components, new ComponentRef(name, "", ""));
        return i < 0 ? null : components[i];
    }

    public ComponentRef[] getComponents() {
        return components;
    }

    public ExtensionPointRef[] getExtensionPoints() {
        return xpoints;
    }

    public ServiceRef[] getServices() {
        return services;
    }

    static class Loader {
        List<ComponentRef> components;

        List<ServiceRef> services;

        List<ExtensionPointRef> xpoints;

        Loader() {
            components = new ArrayList<ComponentRef>();
            services = new ArrayList<ServiceRef>();
            xpoints = new ArrayList<ExtensionPointRef>();
        }

        void load(File file) throws IOException {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            try {
                String line = reader.readLine();
                while (line != null) {
                    line = line.trim();
                    if (line.length() > 0 && !line.startsWith("#")) {
                        loadEntry(line);
                    }
                    line = reader.readLine();
                }
            } finally {
                reader.close();
            }
        }

        private void loadEntry(String line) {
            if (line.startsWith("c:")) {
                ComponentRef ref = readComponentEntry(line);
                if (ref != null) {
                    components.add(ref);
                }
            } else if (line.startsWith("s:")) {
                ServiceRef ref = readServiceEntry(line);
                if (ref != null) {
                    services.add(ref);
                }
            } else if (line.startsWith("x:")) {
                ExtensionPointRef ref = readExtensionPointEntry(line);
                if (ref != null) {
                    xpoints.add(ref);
                }
            } // else unknown entry type
        }

        /**
         * c:name:bundle:src
         * 
         * @param line
         * @return
         */
        private ComponentRef readComponentEntry(String line) {
            int i = 2;
            int k = line.indexOf(':', i);
            if (k == -1) {
                return null;
            }
            String name = line.substring(i, k);
            i = k + 1;
            k = line.indexOf(':', i);
            if (k == -1) {
                return null;
            }
            String bundle = line.substring(i, k);
            String src = line.substring(k + 1);
            return new ComponentRef(name, bundle, src);
        }

        /**
         * s:component:name
         * 
         * @param line
         * @return
         */
        private ServiceRef readServiceEntry(String line) {
            int i = 2;
            int k = line.indexOf(':', i);
            if (k == -1) {
                return null;
            }
            String component = line.substring(i, k);
            String name = line.substring(k + 1);
            return new ServiceRef(name, component);
        }

        /**
         * x:component:name
         * 
         * @param line
         * @return
         */
        private ExtensionPointRef readExtensionPointEntry(String line) {
            int i = 2;
            int k = line.indexOf(':', i);
            if (k == -1) {
                return null;
            }
            String component = line.substring(i, k);
            String name = line.substring(k + 1);
            return new ExtensionPointRef(name, component);
        }
    }

}
