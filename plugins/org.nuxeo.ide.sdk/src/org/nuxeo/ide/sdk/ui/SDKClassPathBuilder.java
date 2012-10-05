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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.JavaCore;
import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.sdk.NuxeoSDK;
import org.nuxeo.ide.sdk.userlibs.UserLib;
import org.nuxeo.ide.sdk.userlibs.UserLibPreferences;
import org.osgi.service.prefs.BackingStoreException;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class SDKClassPathBuilder {

    public static IClasspathEntry[] build(NuxeoSDK sdk) {
        File syslib = sdk.getSysLibDir();
        File lib = sdk.getLibDir();
        File bundles = sdk.getBundlesDir();
        File bundlesSrc = sdk.getBundlesSrcDir();
        File libSrc = sdk.getLibSrcDir();

        ArrayList<IClasspathEntry> result = new ArrayList<IClasspathEntry>();

        collectPaths(bundles, bundlesSrc, result);
        collectPaths(lib, libSrc, result);
        collectPaths(syslib, libSrc, result);

        collectUserLibraries(libSrc, result);

        Collections.sort(result, new Comparator<IClasspathEntry>() {
            @Override
            public int compare(IClasspathEntry o1, IClasspathEntry o2) {
                return o1.getPath().lastSegment().compareTo(
                        o2.getPath().lastSegment());
            }
        });

        return result.toArray(new IClasspathEntry[result.size()]);
    }

    public static IClasspathEntry[] buildTests(NuxeoSDK sdk) {
        File tests = sdk.getTestsDir();
        File libSrc = sdk.getLibSrcDir();

        ArrayList<IClasspathEntry> result = new ArrayList<IClasspathEntry>();

        collectPaths(tests, libSrc, result);

        Collections.sort(result, new Comparator<IClasspathEntry>() {
            @Override
            public int compare(IClasspathEntry o1, IClasspathEntry o2) {
                return o1.getPath().lastSegment().compareTo(
                        o2.getPath().lastSegment());
            }
        });

        return result.toArray(new IClasspathEntry[result.size()]);
    }

    protected static void collectUserLibraries(File srcRoot,
            List<IClasspathEntry> result) {
        try {
            UserLibPreferences prefs = UserLibPreferences.load();
            for (UserLib lib : prefs.getUserLibs().values()) {
                IPath path = new Path(lib.getPath());
                IPath srcPath = getSrcPath(path);
                result.add(JavaCore.newLibraryEntry(path, srcPath, Path.ROOT));
            }
        } catch (BackingStoreException e) {
            UI.showError("Cannot save classpath", e);
        }
    }

    protected static void collectPaths(File root, File srcRoot,
            List<IClasspathEntry> result) {
        File[] files = root.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                // accept jar and xpi (especially for firebug.xpi), reject
                // others like txt or xml that are not zip files
                return name.endsWith(".jar") || name.endsWith(".xpi");
            }
        });
        if (files != null) {
            for (File file : files) {
                String name = file.getName();
                result.add(JavaCore.newLibraryEntry(
                        new Path(file.getAbsolutePath()),
                        getSrcPath(srcRoot, name), Path.ROOT));
            }
        }
    }

    private static IPath getSrcPath(File srcRoot, String name) {
        String prefix = name.substring(0, name.length() - 4);
        File src = new File(srcRoot, prefix + "-sources.jar");
        return src.exists() ? new Path(src.getAbsolutePath()) : null;
    }

    private static IPath getSrcPath(IPath jarPath) {
        String name = jarPath.lastSegment();
        String prefix = name.substring(0, name.length() - 4);
        IPath path = jarPath.removeLastSegments(1).append(
                prefix + "-sources.jar").makeAbsolute();
        return path.toFile().exists() ? path : null;
    }

}
