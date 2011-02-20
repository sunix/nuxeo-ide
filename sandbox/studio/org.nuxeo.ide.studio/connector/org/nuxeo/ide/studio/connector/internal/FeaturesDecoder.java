package org.nuxeo.ide.studio.connector.internal;

import java.io.InputStream;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.TypeReference;
import org.nuxeo.ide.studio.StudioFeature;

public class FeaturesDecoder {

    protected final InputStream input;
    
    public FeaturesDecoder(InputStream input) {
        this.input = input;
    }
    
    public StudioFeature[] decode() {
        FeatureBean[] beans;
        try {
            ObjectMapper mapper = new ObjectMapper();
            beans = mapper.readValue(input, TypeFactory.arrayType(FeatureBean.class));
        } catch (Exception e) {
            throw new Error("Cannot decode input", e);
        }
        return beans;
    }
   
}
