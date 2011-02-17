package org.nuxeo.ide.studio.connector;

import org.eclipse.core.runtime.IPath;
import org.nuxeo.ide.studio.data.model.Feature;

public interface StudioIDEContentProvider {

  StudioIDEProject getDefaultProject();

  StudioIDEProject getProject(String name);

  StudioIDEProject[] getProjects();

  Feature[] getFeatures(String projectId);

  IPath find(String path);

}
