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

import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IClasspathEntry;
import org.nuxeo.ide.sdk.NuxeoSDK;
import org.nuxeo.ide.sdk.SDKRegistry;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class SDKClassPathContainer implements IClasspathContainer {

    public final static String ID = "org.nuxeo.ide.SDK_CONTAINER";

    public static final IClasspathEntry[] EMPTY_CP = new IClasspathEntry[0];

    protected IPath containerPath;

    protected boolean useSDKClasspath;

    public SDKClassPathContainer(IPath containerPath) {
        this.containerPath = containerPath;
        useSDKClasspath = SDKRegistry.useSDKClasspath();
    }

    @Override
    public IClasspathEntry[] getClasspathEntries() {
        if (!useSDKClasspath) {
            return EMPTY_CP;
        }
        NuxeoSDK sdk = NuxeoSDK.getDefault();
        if (sdk != null) {
            return sdk.getClasspathEntries();
        } else {
            return EMPTY_CP;
        }
    }

    public void setUseSDKClasspath(boolean useSDKClasspath) {
        this.useSDKClasspath = useSDKClasspath;
    }

    public boolean useSDKClasspath() {
        return useSDKClasspath;
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
