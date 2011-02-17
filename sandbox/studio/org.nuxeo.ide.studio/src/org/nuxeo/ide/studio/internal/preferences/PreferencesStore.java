package org.nuxeo.ide.studio.internal.preferences;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jdt.core.IJavaProject;
import org.nuxeo.ide.studio.StudioIDEConstants;
import org.nuxeo.ide.studio.StudioIDEPlugin;
import org.nuxeo.ide.studio.connector.StudioIDEContentProvider;
import org.nuxeo.ide.studio.connector.StudioIDEProject;

public class PreferencesStore {
    
    protected IEclipsePreferences getGlobalPreferences() {
        return new DefaultScope().getNode(StudioIDEConstants.PLUGIN_ID);        
    }

    protected IEclipsePreferences getProjectPreferences(IJavaProject ctx) {
        return new ProjectScope(ctx.getProject()).getNode(StudioIDEConstants.PLUGIN_ID);
    }
    
    public URL getConnectLocation() {
        String text = getGlobalPreferences().get(PreferencesConstants.P_URL, "http://connect.nuxeo.com/site/studio/ide");
        try {
            return new URL(text);
        } catch (MalformedURLException e) {
            throw new Error("Cannot convert " + text, e);
        }
    }
    
    public void setConnectLocation(URL location) {
        String text = location.toExternalForm();
        getGlobalPreferences().put(PreferencesConstants.P_URL, text);
    }

    public StudioIDEProject getStudioProject(IJavaProject ctx) {
        IEclipsePreferences preferences = getProjectPreferences(ctx);
        String name = preferences.get(PreferencesConstants.P_PROJECT, "");
        StudioIDEContentProvider provider = StudioIDEPlugin.getDefault().getProvider();

        return name.isEmpty() ? provider.getDefaultProject() : provider.getProject(name);
    
    }
    
    public void setStudioProject(IJavaProject ctx, StudioIDEProject project) {
        IEclipsePreferences prefs = getProjectPreferences(ctx);
        prefs.put(PreferencesConstants.P_PROJECT, project.getName());
    }
    
    public IPath getBinaryPath(IJavaProject ctx) {
        return new Path("/...");
//        StudioIDEProject prj = getStudioProject(ctx);
//        String relpath = prj.getBinaryPath();
//        return new Path(ctx.getPath(), "/xxxx/"+relpath);
    }
}
