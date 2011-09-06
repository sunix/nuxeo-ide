package org.nuxeo.ide.connect;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.nuxeo.ide.common.forms.PreferencesFormData;
import org.nuxeo.ide.connect.studio.StudioProject;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class ConnectPlugin extends AbstractUIPlugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "org.nuxeo.ide.connect"; //$NON-NLS-1$

    // The shared instance
    private static ConnectPlugin plugin;

    private static StudioProjectRef studioProject;

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

    @Override
    protected void initializeImageRegistry(ImageRegistry reg) {
        reg.put("icons/studio_project.gif",
                ImageDescriptor.createFromURL(getBundle().getEntry(
                        "icons/studio_project.gif")));
    }

    public static StudioProject getStudioProject(IProject project)
            throws Exception {
        if (studioProject == null || !studioProject.owner.equals(project)) {
            StudioProject sp = StudioProject.getProject(project);
            studioProject = new StudioProjectRef(project, sp);
        }
        return studioProject.getProject();
    }

    public static class StudioProjectRef {
        IProject owner;

        StudioProject project;

        public StudioProjectRef(IProject owner, StudioProject project) {
            this.owner = owner;
            this.project = project;
        }

        public StudioProject getProject() {
            return project;
        }

        public IProject getOwner() {
            return owner;
        }
    }
}
