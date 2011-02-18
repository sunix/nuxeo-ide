package org.nuxeo.ide.studio;


public interface StudioProject {

    String getId();

    String getName();

    String getTarget();

    FeatureTypeBean[] getFeatureTypes();
}