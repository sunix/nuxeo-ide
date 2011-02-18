package org.nuxeo.ide.studio.connector.internal;

import org.nuxeo.ide.studio.StudioProject;
import org.nuxeo.ide.studio.data.model.Group;


public class ProjectBean implements StudioProject {

    protected final String id;

    protected String name;

    protected String target;

    protected Group[] types;





    public ProjectBean(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getTarget() {
        return target;
    }

    public void setName(String n) {
        name = n;
    }

    public void setTarget(String t) {
        target = t;
    }

    public Group[] getFeatureTypes() {
        return types;
    }

    public void setFeatureTypes(Group[] types) {
        this.types = types;
    }

}
