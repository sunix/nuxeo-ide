package org.nuxeo.ide.studio.connector;

import org.eclipse.core.runtime.IPath;

public interface StudioIDEContentProvider {
  
  StudioIDEProject getDefaultProject();

  StudioIDEProject getProject(String name);
  
  StudioIDEProject[] getProjects();
  
  IPath find(String path);

}
