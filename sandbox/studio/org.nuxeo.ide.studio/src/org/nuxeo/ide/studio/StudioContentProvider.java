package org.nuxeo.ide.studio;

import java.io.File;

import org.nuxeo.ide.studio.data.model.Feature;

public interface StudioContentProvider {

  StudioProject[] getProjects();

  Feature[] getFeatures(String projectId);

  File getJar(String name);

  void updateJar(String projectName);

  StudioProject getProject(String id);

}
