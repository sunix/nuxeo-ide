package org.nuxeo.ide.studio.connector.internal;

import org.nuxeo.ide.studio.FeatureTypeBean;
import org.nuxeo.ide.studio.StudioProject;


public class ProjectBean implements StudioProject {

    protected final String id;

    protected String name;

    protected String target;

    protected FeatureTypeBean[] types;





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

    public FeatureTypeBean[] getFeatureTypes() {
        return types;
    }

    public void setFeatureTypes(FeatureTypeBean[] types) {
        this.types = types;
    }

}
