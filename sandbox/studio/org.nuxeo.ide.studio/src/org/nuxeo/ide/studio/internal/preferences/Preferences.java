package org.nuxeo.ide.studio.internal.preferences;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.equinox.security.storage.ISecurePreferences;
import org.eclipse.equinox.security.storage.SecurePreferencesFactory;
import org.eclipse.equinox.security.storage.StorageException;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.nuxeo.ide.studio.StudioConstants;

public class Preferences {

    public static Preferences INSTANCE = new Preferences();

    protected final IPreferenceStore pluginStore;
    
    protected IPreferenceStore projectPreferenceStore(IJavaProject java) {
	    IProject project = java.getProject();
        IScopeContext scope = new ProjectScope(project);
        String qname = StudioConstants.makeConstant(project.getName());
	    return new ScopedPreferenceStore(scope, qname);
    }
	
    public Preferences() {
        pluginStore = new ScopedPreferenceStore(new InstanceScope(), StudioConstants.PLUGIN_ID);
    }

    public void registerListener(IPropertyChangeListener listener) {
        pluginStore.addPropertyChangeListener(listener);
    }
    
    public void unregisterListener(IPropertyChangeListener listener) {
        pluginStore.removePropertyChangeListener(listener);
    }
    
    public URL getConnectLocation(String... segments) {
        String base = pluginStore.getString(PreferencesConstants.P_CONNECT_LOCATION);
        String path = path(base, segments);
        try {
            return new URL(path);
        } catch (MalformedURLException e) {
            throw new Error("Cannot convert " + path, e);
        }
    }

    private static String path(String base, String... segments) {
	    for(String segment:segments) {
	        base += "/".concat(segment);
	    }
	    return base;
    }

    public String getUsername() {
        return pluginStore.getString(PreferencesConstants.P_USER);
    }

    public String getPassword() {
        ISecurePreferences root = SecurePreferencesFactory.getDefault();
        try {
            return root.get(StudioConstants.makeConstant("password"), "");
        } catch (StorageException e) {
            throw new Error("Cannot get password in secure storage", e);
        }
    }
    
    public void setPassword(String password) {
        ISecurePreferences root = SecurePreferencesFactory.getDefault();
        try {
            root.put(StudioConstants.makeConstant("password"), password, true);
        } catch (StorageException e) {
            throw new Error("Cannot set password in secure storage", e);
        }
    }

    public void setConnectLocation(URL location) {
        String text = location.toExternalForm();
        pluginStore.setValue(PreferencesConstants.P_CONNECT_LOCATION, text);
    }


    public String getStudioProjectName(IJavaProject ctx) {
        IPreferenceStore store = projectPreferenceStore(ctx);
        String name = store.getString(PreferencesConstants.P_PROJECT);
        return name;
    }

    public void setStudioProject(IJavaProject ctx, String name) {
        IPreferenceStore store = projectPreferenceStore(ctx);
        store.setValue(PreferencesConstants.P_PROJECT, name);
    }

}
