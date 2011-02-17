package org.nuxeo.ide.studio.internal.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.nuxeo.ide.studio.StudioIDEConstants;

public class PreferencesInitializer extends AbstractPreferenceInitializer {

    public PreferencesInitializer() {
    }

    @Override
    public void initializeDefaultPreferences() {
        IEclipsePreferences node = new DefaultScope().getNode(StudioIDEConstants.PLUGIN_ID);
        node.put(PreferencesConstants.P_URL, "http://connect.nuxeo.com/site/studio/ide/xxx");
        node.put(PreferencesConstants.P_PROJECT, null);
    }

}
