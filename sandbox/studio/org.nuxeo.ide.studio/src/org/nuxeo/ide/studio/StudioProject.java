package org.nuxeo.ide.studio;

import org.nuxeo.ide.studio.data.model.Group;

public interface StudioProject {

    String getId();

    String getName();

    String getTarget();

    Group[] getFeatureTypes();
}