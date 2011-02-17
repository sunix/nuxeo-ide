package org.nuxeo.ide.studio.connector;

import java.io.File;

public interface StudioIDEContentProvider {

  StudioIDEProject[] getProjects();

  String getFeatures(String projectId);

  File getJar(String name);

  void updateJar(String projectName);

}
