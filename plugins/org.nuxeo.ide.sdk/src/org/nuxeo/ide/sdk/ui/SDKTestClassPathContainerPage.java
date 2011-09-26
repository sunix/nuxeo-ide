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

import org.eclipse.jdt.core.IClasspathEntry;
import org.nuxeo.ide.sdk.NuxeoSDK;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class SDKTestClassPathContainerPage extends SDKClassPathContainerPage {

    public SDKTestClassPathContainerPage() {
        super("NuxeoSDKTest", "Nuxeo SDK (Tests)", null);
    }

    @Override
    protected IClasspathEntry[] getClasspath(NuxeoSDK sdk) {
        return sdk.getTestClasspathEntries();
    }

}
