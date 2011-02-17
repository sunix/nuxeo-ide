package org.nuxeo.ide.studio.dto;

import java.net.URL;

public class NxStudioProjectBean {
   
    protected final String name;
    
    protected URL binaryLocation;
    
    public NxStudioProjectBean(String name, URL binaryLocation) {
        this.name = name;
        this.binaryLocation = binaryLocation;
    }
    
    public String getName() {
        return name;
    }
    
    public URL getBinaryLocation() {
        return binaryLocation;
    }

}
