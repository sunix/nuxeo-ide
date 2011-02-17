package org.nuxeo.ide.studio;

public class NxStudioConstants {

    public static final String PLUGIN_ID = "org.nuxeo.ide.studio";
    
    public static final String PREFERENCE_PAGE_ID = makeConstant("NxStudioPreferencesPage");
    
    public static final String CLASSPATH_CONTAINER_ID = makeConstant("ClasspathContainer");
    
    public static final String EXTENSION_WORKBENCH_PROVIDER = makeConstant("WorkbenchProvider");
    
    public static String makeConstant(String key) {
        return PLUGIN_ID + "." + key;
    }
}
