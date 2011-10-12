package org.nuxeo.ide.connect;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.equinox.security.storage.StorageException;
import org.nuxeo.ide.sdk.IConnectProvider;
import org.osgi.service.prefs.BackingStoreException;

public class SDKProvider implements IConnectProvider {

    @Override
    public IFile[] getLibraries(IProject project, IProgressMonitor monitor) throws IOException, StorageException, BackingStoreException, CoreException {
       StudioProjectBinding binding = ConnectPlugin.getStudioProvider().getBinding(project);
       List<IFile> libs = new ArrayList<IFile>();
       for (String projectId:binding.getProjectIds()) {
          InputStream is = Connector.getDefault().downloadJarArtifact(projectId);
          IFolder libFile = project.getFolder("lib");
          if (!libFile.exists()) {
              libFile.create(IFolder.FORCE, true, monitor);
          }
          IFile jarFile = libFile.getFile(projectId + "-0.0.0-SNAPSHOT.jar");
          if (jarFile.exists()) {
              jarFile.delete(IFile.FORCE, monitor);
          }
          jarFile.create(is, IFile.FORCE, monitor);
       }
       return libs.toArray(new IFile[libs.size()]);
    }

}
