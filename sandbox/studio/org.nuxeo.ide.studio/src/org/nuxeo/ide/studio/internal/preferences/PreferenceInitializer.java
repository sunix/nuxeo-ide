package org.nuxeo.ide.studio.internal.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.nuxeo.ide.studio.StudioIDEConstants;

public class PreferenceInitializer extends AbstractPreferenceInitializer {

    public PreferenceInitializer() {
    }

    @Override
    public void initializeDefaultPreferences() {
        IEclipsePreferences node = DefaultScope.INSTANCE.getNode(StudioIDEConstants.PLUGIN_ID);
        node.put(PreferenceConstants.P_URL, "http://connect.nuxeo.com/site/studio/ide/xxx");
    }

}
