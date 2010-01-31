package org.nuxeo.dev.ide;

import java.io.File;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.nuxeo.dev.ide";

	// The shared instance
	private static Activator plugin;
	
	
	protected String version;
	protected IPath bin;
	protected IPath src;
	
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		URL url = getClass().getClassLoader().getResource("/sdk.properties");
		if (url == null) {
		    //getLog().log(new Satus())
		    throw new IllegalStateException("SDK not found");
		}
		File sdkDir = urlToFile(FileLocator.resolve(url)).getParentFile();
		InputStream in = url.openStream();
		try {
		    Properties p = new Properties();
		    p.load(in);
		    version = p.getProperty("version");
		    String path = p.getProperty("bin");
		    bin = new Path(new File(sdkDir, path).getAbsolutePath());
		    path = p.getProperty("src");
		    src = new Path(new File(sdkDir, path).getAbsolutePath());
		} finally {
		    in.close();
		}
	}
	
	public IPath getNuxeoDistributionTools() {
	    return bin;
	}

	public IPath getNuxeoDistributionToolsSources() {
	    return src;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
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

	public static File urlToFile(URL url) { 
	    File f;
	    try {
	        f = new File(url.toURI());
	    } catch(URISyntaxException e) {
	        f = new File(url.getPath());
	    }
	    return f;
	}

}
