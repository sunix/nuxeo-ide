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
package org.nuxeo.ide.sdk.ui;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.JavaCore;
import org.nuxeo.ide.sdk.NuxeoSDK;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class SDKClassPathBuilder {

    public static IClasspathEntry[] build(NuxeoSDK sdk) {
        File lib = sdk.getLibDir();
        File bundles = sdk.getBundlesDir();
        File bundlesSrc = sdk.getBundlesSrcDir();
        File libSrc = sdk.getLibSrcDir();

        ArrayList<IClasspathEntry> result = new ArrayList<IClasspathEntry>();

        collectPaths(bundles, bundlesSrc, result);
        collectPaths(lib, libSrc, result);
        return result.toArray(new IClasspathEntry[result.size()]);
    }

    protected static void collectPaths(File root, File srcRoot,
            List<IClasspathEntry> result) {
        File[] files = root.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".jar");
            }
        });
        if (files != null) {
            for (File file : files) {
                String name = file.getName();
                String prefix = name.substring(0, name.length() - 4);
                File src = new File(srcRoot, prefix + "-sources.jar");
                Path srcPath = src.exists() ? new Path(src.getAbsolutePath())
                        : null;
                result.add(JavaCore.newLibraryEntry(
                        new Path(file.getAbsolutePath()), srcPath, Path.ROOT));
            }
        }
    }

}
