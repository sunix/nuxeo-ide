package org.nuxeo.ide.studio;

public interface StudioFeature {

    String getId();

    String getType();

    boolean isGlobal();

    String getKey();

}