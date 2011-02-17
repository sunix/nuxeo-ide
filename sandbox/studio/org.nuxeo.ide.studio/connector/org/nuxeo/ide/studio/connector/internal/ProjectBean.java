package org.nuxeo.ide.studio.connector.internal;

import org.nuxeo.ide.studio.connector.StudioIDEProject;


public class ProjectBean implements StudioIDEProject {
   
    protected final String name;
    
    protected String binaryPath;
    
    public ProjectBean(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public String getBinaryPath() {
        return binaryPath;
    }

    public void setBinaryPath(String path) {
        this.binaryPath = path;
    }
}
