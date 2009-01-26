/**
 * 
 */
package org.nuxeo.ide.webengine;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
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

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTabGroup#createTabs(org.eclipse.debug.ui.ILaunchConfigurationDialog, java.lang.String)
	 */
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		ILaunchConfigurationTab[] tabs = null;
		//tabs = new ILaunchConfigurationTab[] {new MainTab(), new JavaArgumentsTab(), new PluginsTab(), new ConfigurationTab(), new TracingTab(), new EnvironmentTab(), new CommonTab()};
		setTabs(tabs);
	}

}
