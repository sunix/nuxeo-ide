/**
 *
 */
package org.nuxeo.ide.webengine.launch;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

/**
 * @author stan
 *
 */
public class LaunchConfigurationTabGroup extends
        AbstractLaunchConfigurationTabGroup {

    /**
     *
     */
    public LaunchConfigurationTabGroup() {
    }

    public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
        ILaunchConfigurationTab[] tabs = null;

        tabs = new ILaunchConfigurationTab[] { new CommonTab()};
//tabs = new ILaunchConfigurationTab[] {new MainTab(), new JavaArgumentsTab(), new PluginsTab(), new ConfigurationTab(), new TracingTab(), new EnvironmentTab(), new CommonTab()};
        setTabs(tabs);
    }

}
