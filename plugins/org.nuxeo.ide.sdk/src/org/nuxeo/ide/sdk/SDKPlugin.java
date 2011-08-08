package org.nuxeo.ide.sdk;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.nuxeo.ide.common.forms.PreferencesFormData;
import org.nuxeo.ide.sdk.templates.TemplateManager;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class SDKPlugin extends AbstractUIPlugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "org.nuxeo.ide.sdk"; //$NON-NLS-1$

    // The shared instance
    private static SDKPlugin plugin;

    protected TemplateManager tempMgr;

    /**
     * The constructor
     */
    public SDKPlugin() {
    }

    public TemplateManager getTemplateManager() {
        return tempMgr;
    }

    public void start(BundleContext context) throws Exception {
        super.start(context);
        tempMgr = new TemplateManager();
        tempMgr.loadTemplates(context.getBundle());
        plugin = this;
        NuxeoSDK.initialize();
    }

    public void stop(BundleContext context) throws Exception {
        plugin = null;
        tempMgr = null;
        NuxeoSDK.dispose();
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
