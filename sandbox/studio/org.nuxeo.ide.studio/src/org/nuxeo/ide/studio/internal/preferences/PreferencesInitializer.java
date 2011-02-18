package org.nuxeo.ide.studio.internal.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.nuxeo.ide.studio.StudioPlugin;

public class PreferencesInitializer extends AbstractPreferenceInitializer {

    protected IPreferenceStore pluginStore;
    
    public PreferencesInitializer() {
        pluginStore = StudioPlugin.getDefault().getPreferenceStore();
    }

    @Override
    public void initializeDefaultPreferences() {
        pluginStore.setDefault(PreferencesConstants.P_CONNECT_LOCATION, "http://connect.nuxeo.com/nuxeo/site/studio");
    }

}
