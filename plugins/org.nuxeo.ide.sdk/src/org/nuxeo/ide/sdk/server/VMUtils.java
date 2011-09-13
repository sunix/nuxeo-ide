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
package org.nuxeo.ide.sdk.server;

import java.io.File;

import org.eclipse.jdt.internal.launching.StandardVMType;
import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jdt.launching.JavaRuntime;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class VMUtils {

    public static String getJavaExecutablePath() {
        return getJavaExecutable().getAbsolutePath();
    }

    public static String getJavaExecutablePath(IVMInstall vm) {
        return getJavaExecutable(vm).getAbsolutePath();
    }

    public static File getJavaExecutable() {
        return getJavaExecutable(JavaRuntime.getDefaultVMInstall());
    }

    public static File getJavaExecutable(IVMInstall vm) {
        return StandardVMType.findJavaExecutable(vm.getInstallLocation());
    }

}
