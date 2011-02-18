package org.nuxeo.ide.studio;

import java.io.File;

public interface StudioContentProvider {

  StudioProject[] getProjects();

  String getEncodedFeatures(String projectId);

  File getJar(String name);

  void updateJar(String projectName);

  StudioProject getProject(String id);

}
