package org.nuxeo.ide.studio.connector.internal;

import java.util.ArrayList;
import java.util.List;

import org.nuxeo.ide.studio.StudioContentProvider;
import org.nuxeo.ide.studio.StudioProject;

public class ContentExtractor {

    protected StudioContentProvider provider;
    
    public ContentExtractor(StudioContentProvider p) {
        provider = p;
    }
    
    public String[] extractProjectNames() {
        StudioProject[] projects = provider.getProjects();
        List<String> names = new ArrayList<String>(projects.length);
        for (StudioProject project : projects) {
            names.add(project.getId());
        }
        return names.toArray(new String[names.size()]);
    }

}
