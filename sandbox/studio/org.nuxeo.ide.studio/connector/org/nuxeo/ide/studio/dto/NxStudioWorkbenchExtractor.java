package org.nuxeo.ide.studio.dto;

import java.util.ArrayList;
import java.util.List;

public class NxStudioWorkbenchExtractor {

    protected NxStudioWorkbenchBean source;
    
    public NxStudioWorkbenchExtractor(NxStudioWorkbenchBean wb) {
        source = wb;
    }
    
    public String[] extractProjectNames() {
        NxStudioProjectBean[] projects = source.getProjects();
        List<String> names = new ArrayList<String>(projects.length);
        for (NxStudioProjectBean project : projects) {
            names.add(project.getName());
        }
        return names.toArray(new String[names.size()]);
    }

}
