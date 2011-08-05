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

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.JavaCore;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class SDKClassPathContainer implements IClasspathContainer {

    private volatile static IClasspathEntry[] cache = null;

    protected IPath containerPath;

    public SDKClassPathContainer(IPath containerPath) {
        this.containerPath = containerPath;
    }

    protected File getSDKRoot() {
        return new File(
                "/Users/bstefanescu/work/nuxeo/nuxeo-distribution/nuxeo-distribution-tomcat/target/nuxeo-dm-5.4.3-SNAPSHOT-tomcat");
    }

    @Override
    public IClasspathEntry[] getClasspathEntries() {
        ArrayList<IClasspathEntry> result = new ArrayList<IClasspathEntry>();
        File root = getSDKRoot();
        File bundles = new File(root, "nxserver/bundles");
        File lib = new File(root, "nxserver/lib");
        File bundlesSrc = new File(root, "nxserver/src/bundles");
        File libSrc = new File(root, "nxserver/src/lib");

        IClasspathEntry[] _cache = cache;
        if (_cache == null) {
            collectPaths(bundles, bundlesSrc, result);
            collectPaths(lib, libSrc, result);
            _cache = result.toArray(new IClasspathEntry[result.size()]);
            cache = _cache;
        }

        return _cache;
    }

    protected void collectPaths(File root, File srcRoot,
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

    @Override
    public String getDescription() {
        return "Nuxeo SDK";
    }

    @Override
    public int getKind() {
        return K_APPLICATION;
    }

    @Override
    public IPath getPath() {
        return containerPath;
    }

}
