package org.nuxeo.ide.studio.connector.internal;

import java.io.InputStream;

import org.codehaus.jackson.map.ObjectMapper;

public class ProjectsDecoder {

    protected final InputStream input;
    
    public ProjectsDecoder(InputStream input) {
        this.input = input;
    }
    
    public ProjectBean[] decode() {
        ProjectBean[] beans;
        try {
            ObjectMapper mapper = new ObjectMapper();
            beans = mapper.readValue(input, ProjectBean[].class);
        } catch (Exception e) {
            throw new Error("Cannot decode input", e);
        }
        return beans;
    }

   
}
