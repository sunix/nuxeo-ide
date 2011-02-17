package org.nuxeo.ide.studio.connector.internal;

import org.nuxeo.ide.studio.StudioProject;


public class ProjectBean implements StudioProject {

    protected final String name;

    protected String title;

    protected String targetVersion;

    public ProjectBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getTargetVersion() {
        return targetVersion;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTargetVersion(String targetVersion) {
        this.targetVersion = targetVersion;
    }

}
