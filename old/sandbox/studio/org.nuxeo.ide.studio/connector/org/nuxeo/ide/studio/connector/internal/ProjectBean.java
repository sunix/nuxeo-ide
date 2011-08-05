package org.nuxeo.ide.studio.connector.internal;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;
import org.nuxeo.ide.studio.StudioFeatureType;
import org.nuxeo.ide.studio.StudioProject;

public class ProjectBean implements StudioProject {

    protected final String id;

    protected String name;

    protected String target;

    protected FeatureTypeBean[] types;

    @JsonCreator
    public ProjectBean(@JsonProperty("id")String id) {
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

    public FeatureTypeBean[] getTypes() {
        return types;
    }

    public void setTypes(FeatureTypeBean[] types) {
        this.types = types;
    }

}
