package org.nuxeo.ide.studio;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.nuxeo.ide.studio.dto.NxStudioWorkbenchBean;
import org.nuxeo.ide.studio.internal.extensions.ExtensionsReader;
import org.nuxeo.ide.studio.mock.internal.MockWorbenchProvider;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class NxStudioPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = NxStudioConstants.PLUGIN_ID;

	// The shared instance
	private static NxStudioPlugin plugin;
	
	/**
	 * The constructor
	 */
	public NxStudioPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
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
		super.stop(context);
	}
	
	protected NxStudioWorkbenchProvider wbProvider = new MockWorbenchProvider();
	
	public NxStudioWorkbenchBean getStudioWorkbench() {
	    return wbProvider.getWorkbench();
	}

	protected void setStudioWorkbenchProvider(NxStudioWorkbenchProvider provider) {
	    wbProvider = provider;
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static NxStudioPlugin getDefault() {
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

}
