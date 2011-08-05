package org.nuxeo.ide.studio.connector.internal;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.nuxeo.ide.studio.StudioFeature;
import org.nuxeo.ide.studio.StudioProject;

public class CanOperateWithStudio {

    Connector connector;
    
    @Before public void setupConnector() throws MalformedURLException {
        URL loc = new URL("http://localhost:8080/nuxeo/site/studio");
        connector = new Connector(loc);
        connector.setPreemptiveBasicAuth("b", "b");
    }
    
    public InputStream encodedProjectsRef() {
        return CanOperateWithStudio.class.getResourceAsStream("projects.json");
    }
    
    public String encodedProjectRefAsString() throws IOException {
        InputStream refInput = encodedProjectsRef();
        return Connector.readStream(refInput);        
    }
    
    public InputStream encodedFeaturesRef() {
        return CanOperateWithStudio.class.getResourceAsStream("features.json");
    }
    
    public String encodedFeaturestRefAsString() throws IOException {
        InputStream refInput = encodedFeaturesRef();
        return Connector.readStream(refInput);        
    }
    
    @Test public void canFetchProjects() throws Exception {
        InputStream input = connector.getProjects();
        String encoded = Connector.readStream(input);
        assertThat(encoded, startsWith("["));
    }
    
    @Test public void canDecodeProjects() throws IOException {
        InputStream encodedInput = encodedProjectsRef();
        StudioProject[] projects = new ProjectsDecoder(encodedInput).decode();
        assertThat(projects.length, is(2));
    }

    @Test public void canFetchFeatures() throws Exception {
        InputStream input = connector.getFeatures("test1");
        String encoded = Connector.readStream(input);
        assertThat(encoded, startsWith("["));
    }

    @Test public void canDecodeFeatures() throws IOException {
        InputStream encodedInput = encodedFeaturesRef();
        StudioFeature[] features = new FeaturesDecoder(encodedInput).decode();
        assertThat(features.length, is(14));
    }
}
