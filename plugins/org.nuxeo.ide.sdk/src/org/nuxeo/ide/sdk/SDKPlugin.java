package org.nuxeo.ide.sdk;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.nuxeo.ide.common.forms.PreferencesFormData;
import org.nuxeo.ide.sdk.templates.TemplateRegistry;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class SDKPlugin extends AbstractUIPlugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "org.nuxeo.ide.sdk"; //$NON-NLS-1$

    // The shared instance
    private static SDKPlugin plugin;

    protected TemplateRegistry tempReg;

    /**
     * The constructor
     */
    public SDKPlugin() {
    }

    public TemplateRegistry getTemplateRegistry() {
        return tempReg;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
     * )
     */
    public void start(BundleContext context) throws Exception {
        super.start(context);
        tempReg = new TemplateRegistry();
        tempReg.loadtemplates(context.getBundle());
        plugin = this;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
     * )
     */
    public void stop(BundleContext context) throws Exception {
        plugin = null;
        tempReg = null;
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
    public static SDKPlugin getDefault() {
        return plugin;
    }

}
