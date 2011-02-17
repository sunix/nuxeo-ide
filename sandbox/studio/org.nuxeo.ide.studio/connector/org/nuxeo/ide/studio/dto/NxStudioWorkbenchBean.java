package org.nuxeo.ide.studio.dto;

import java.net.URL;



public class NxStudioWorkbenchBean {
    
    protected final URL location;
    
    protected String username = "john doe";
    
    protected NxStudioProjectBean[] projects = new NxStudioProjectBean[0];

    public NxStudioWorkbenchBean(URL location) {
        this.location = location;
    }
    
    public void setProjects(NxStudioProjectBean... beans) {
        this.projects = beans;
    }
    
    public NxStudioProjectBean[] getProjects() {
        return projects;
    }

    public void setUsername(String value) {
        username = value;
    }
    
    public String getUsername() {
        return username;
    }

    public URL getLocation() {
        return location;
    }
}
