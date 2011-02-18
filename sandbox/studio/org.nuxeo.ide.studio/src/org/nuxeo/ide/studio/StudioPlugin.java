package org.nuxeo.ide.studio;

import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.statushandlers.StatusManager;
import org.nuxeo.ide.studio.connector.internal.StudioContentProviderImpl;
import org.nuxeo.ide.studio.internal.preferences.Preferences;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class StudioPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = StudioConstants.PLUGIN_ID;

	// The shared instance
	private static StudioPlugin plugin;

	protected Preferences prefs;

	/**
	 * The constructor
	 */
	public StudioPlugin() {
	    prefs = new Preferences();
	    wbProvider = new StudioContentProviderImpl();
	}

	IPropertyChangeListener prefsListener;
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		if (wbProvider instanceof StudioActivatorHandler) {
		    ((StudioActivatorHandler)wbProvider).handleStart();
		}
        prefs.registerListener(prefsListener = new IPropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent event) {
                if (wbProvider instanceof StudioActivatorHandler) {
                    ((StudioActivatorHandler) wbProvider).handleReset();
                }
            }
        });
		
//		loadExtensions();
	}

//	protected void loadExtensions() {
//	    ExtensionsReader reader = new ExtensionsReader();
//        wbProviders = reader.
//    }

    /*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		prefs.unregisterListener(prefsListener);
		super.stop(context);
	}

	protected StudioContentProvider wbProvider = new StudioContentProviderImpl();//new MockIDEContentProvider();

	protected void setProvider(StudioContentProvider provider) {
	    wbProvider = provider;
	}

	public StudioContentProvider getProvider() {
	    return wbProvider;
	}

	public static Preferences getPreferences() {
	    return getDefault().prefs;
	}
	
	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static StudioPlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

	public static void logInfo(String format, Object... args) {
	    String msg = String.format(format, args);
	    StatusManager.getManager().handle(new Status(Status.INFO, StudioPlugin.PLUGIN_ID, msg));	    
	}

}
