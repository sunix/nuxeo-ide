package org.nuxeo.ide.connect;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.nuxeo.ide.common.forms.PreferencesFormData;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class ConnectPlugin extends AbstractUIPlugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "org.nuxeo.ide.connect"; //$NON-NLS-1$

    // The shared instance
    private static ConnectPlugin plugin;

    /**
     * The constructor
     */
    public ConnectPlugin() {
    }

    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
    }

    public void stop(BundleContext context) throws Exception {
        plugin = null;
        super.stop(context);
    }

    public BundleContext getContext() {
        return getBundle().getBundleContext();
    }

    public PreferencesFormData getPreferences() {
        return new PreferencesFormData(new InstanceScope().getNode(PLUGIN_ID));
    }

    /**
     * Returns the shared instance
     * 
     * @return the shared instance
     */
    public static ConnectPlugin getDefault() {
        return plugin;
    }

}
