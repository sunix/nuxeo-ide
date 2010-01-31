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
package org.nuxeo.dev.ide.launcher;

import java.io.File;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.variables.IStringVariableManager;
import org.eclipse.core.variables.VariablesPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.internal.ui.DebugUIMessages;
import org.eclipse.debug.ui.WorkingDirectoryBlock;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.internal.debug.ui.JDIDebugUIPlugin;
import org.eclipse.jdt.launching.JavaRuntime;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 *
 */
public class NuxeoWorkingDirectoryBlock extends WorkingDirectoryBlock {

    public NuxeoWorkingDirectoryBlock() {
        super (NuxeoLaunchAttributes.HOME);
    }
    
    protected IProject getProject(ILaunchConfiguration configuration)
            throws CoreException {
        IJavaProject project = JavaRuntime.getJavaProject(configuration);
        return project == null ? null : project.getProject();
    }

    protected void log(CoreException e) {
        JDIDebugUIPlugin.log(e);
    }

    @Override
    protected void setDefaultWorkingDir() {
        String home = null;
        try {
            ILaunchConfiguration config = getLaunchConfiguration();
            if (config != null) {
                IProject project = getProject(config);
                if (project != null) {
                    home = getDefaultHome()+"/projects/"+project.getFullPath().makeRelative().toOSString();
                    mkdirs(home);
                    setDefaultWorkingDirectoryText(home);
                    return;
                }
            }
        } 
        catch (CoreException ce) {
            log(ce);
        }
        home = getDefaultHome();
        mkdirs(home);
        setDefaultWorkingDirectoryText(getDefaultHome()); //$NON-NLS-1$
    }
    
    public static String getDefaultHome() {
        return System.getProperty("user.home")+"/.nxserver";
    }

    protected void mkdirs(String dir) {
        new File(dir).mkdirs();
    }
    
    public boolean isValid(ILaunchConfiguration config) {
        setErrorMessage(null);
        setMessage(null);
        // if variables are present, we cannot resolve the directory
        String workingDirPath = getWorkingDirectoryText();
        if (workingDirPath.indexOf("${") >= 0) { //$NON-NLS-1$
            IStringVariableManager manager = VariablesPlugin.getDefault().getStringVariableManager();
            try {
                manager.validateStringVariables(workingDirPath);
            }
            catch (CoreException e) {
                setErrorMessage(e.getMessage());
                return false;
            }
        } 
//        else if (workingDirPath.length() > 0) {
//            IContainer container = getContainer();
//            if (container == null) {
//                File dir = new File(workingDirPath);
//                if (dir.isDirectory()) {
//                    return true;
//                }
//                setErrorMessage(DebugUIMessages.WorkingDirectoryBlock_10); 
//                return false;
//            }
//        } 
        else if (workingDirPath.length() == 0) {
            setErrorMessage(DebugUIMessages.WorkingDirectoryBlock_20);
            return false;
        }
        return true;
    }
}
