package org.nuxeo.ide.sdk.ui.launchers;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.jdt.junit.launcher.JUnitLaunchConfigurationDelegate;

public class NuxeoJUnitDelegate extends JUnitLaunchConfigurationDelegate {
    
    @Override
    public String[] getClasspath(ILaunchConfiguration configuration)
            throws CoreException {
        return super.getClasspath(configuration);
    }

}
