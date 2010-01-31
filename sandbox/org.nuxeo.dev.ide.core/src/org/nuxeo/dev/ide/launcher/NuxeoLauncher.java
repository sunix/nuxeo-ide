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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;
import org.eclipse.jdt.launching.JavaLaunchDelegate;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 *
 */
public class NuxeoLauncher extends JavaLaunchDelegate implements NuxeoLaunchAttributes, IJavaLaunchConfigurationConstants {

    /**
     * replace the main type with the nuxeo dev main
     */
    @Override
    public String verifyMainTypeName(ILaunchConfiguration configuration)
    throws CoreException {
        return "org.nuxeo.dev.Main";
    }

    /**
     * 
     */
    @Override
    public File verifyWorkingDirectory(ILaunchConfiguration configuration)
            throws CoreException {
        String home = getNuxeoHome(configuration);
        File file = new File(home);
        file.mkdirs();
        return file;
    }

    public String getNuxeoHome(ILaunchConfiguration configuration)
            throws CoreException {
        String home = configuration.getAttribute(HOME, "");
        if (home.length()==0) { // get the default home
            home = System.getProperty("user.home")+"/.nxserver/projects/"+configuration.getAttribute(IJavaLaunchConfigurationConstants.ATTR_PROJECT_NAME, "unknown");
            //abort("No working directory speciffied", null, IJavaLaunchConfigurationConstant.); //TODO code
            //getDefaultNuxeoHome();
        }        
        return home;
    }
    
    @Override
    public String getProgramArguments(ILaunchConfiguration configuration)
            throws CoreException {
        
        String home = getNuxeoHome(configuration);
        String profile = configuration.getAttribute(PROFILE, "");
        String cprofile = configuration.getAttribute(CUSTOM_PROFILE, "");
        boolean nocache = configuration.getAttribute(NOCACHE, false);
        boolean offline = configuration.getAttribute(OFFLINE, false);
        String update = configuration.getAttribute(UPDATE, "");
        String host = configuration.getAttribute(HOST, "");
        String main = super.getMainTypeName(configuration);
        String args = super.getProgramArguments(configuration);
        
        String result = home;
        if (cprofile.length()>0) {
            result+=" -c \""+cprofile+"\"";
        } else if (profile.length()>0) {
            result+=" -p "+profile;
        }
        if (nocache) {
            result+=" --nocache";
        }
        if (offline) {
            result+=" -o";
        }
        if (update.length()>0) {
            result+=" -u "+update;
        }
        if (host.length()>0) {
            result+=" -h "+host;
        }        
        if (main!=null&&main.length()>0) {
            result+=" -e "+main;
        }
        result+=" "+args;
        return result;
    }
    
}
