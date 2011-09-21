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
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class SDKIndex {

    protected File root;

    protected File db;

    public SDKIndex(File root) {
        this.root = root;
        this.db = new File(root, "nxserver/sdk/index.db");
    }

    public void build() throws IOException {

    }

    public static Map<String, String> buildIndex(File... roots)
            throws IOException {
        HashMap<String, String> result = new HashMap<String, String>();
        for (File root : roots) {
            buildIndex(root, result);
        }
        return result;
    }

    public static void buildIndex(File root, Map<String, String> result)
            throws IOException {
        File[] jars = root.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".jar");
            }
        });

        if (jars != null) {
            for (File jar : jars) {
                buildJarIndex(jar, result);
            }
        }

    }

    public static void buildJarIndex(File jar, Map<String, String> result)
            throws IOException {
        ZipInputStream zin = new ZipInputStream(new FileInputStream(jar));
        try {
            try {
                collectClasses(jar.getName(), zin, result);
            } catch (IOException e) {
                // ignore
                e.printStackTrace(); // TODO collect errors
            }
        } finally {
            zin.close();
        }
    }

    protected static void collectClasses(String jarName, ZipInputStream zin,
            Map<String, String> result) throws IOException {
        ZipEntry entry = zin.getNextEntry();
        while (entry != null) {
            String name = entry.getName();
            if (!entry.isDirectory() && name.endsWith(".class")) {
                name = name.replace('/', '.');
                name = name.replace('$', '.');
                name = name.substring(0, name.length() - 6);
                result.put(name, jarName);
            }
            entry = zin.getNextEntry();
        }
    }

}
