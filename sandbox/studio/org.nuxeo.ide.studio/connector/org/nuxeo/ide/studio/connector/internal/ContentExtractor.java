package org.nuxeo.ide.studio.connector.internal;

import java.util.ArrayList;
import java.util.List;

import org.nuxeo.ide.studio.connector.StudioIDEContentProvider;
import org.nuxeo.ide.studio.connector.StudioIDEProject;

public class ContentExtractor {

    protected StudioIDEContentProvider provider;
    
    public ContentExtractor(StudioIDEContentProvider p) {
        provider = p;
    }
    
    public String[] extractProjectNames() {
        StudioIDEProject[] projects = provider.getProjects();
        List<String> names = new ArrayList<String>(projects.length);
        for (StudioIDEProject project : projects) {
            names.add(project.getName());
        }
        return names.toArray(new String[names.size()]);
    }

}
