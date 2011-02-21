package org.nuxeo.ide.studio;

import java.io.File;

public interface StudioContentProvider {

  StudioProject[] getProjects();

  StudioFeature[] getFeatures(String projectId);

  File getJar(String name);

  void updateJar(String projectName);

  StudioProject getProject(String id);

}
