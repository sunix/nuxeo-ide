package org.nuxeo.ide.connect;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.equinox.security.storage.StorageException;
import org.nuxeo.ide.sdk.IConnectProvider;
import org.osgi.service.prefs.BackingStoreException;

public class SDKProvider implements IConnectProvider {

    @Override
    public Infos[] getLibrariesInfos(IProject project, IProgressMonitor monitor)
            throws IOException, StorageException, BackingStoreException,
            CoreException {
        StudioProvider studioProvider = ConnectPlugin.getStudioProvider();
        StudioProjectBinding binding = studioProvider.getBinding(project);  
        if (binding == null) {
            return new Infos[0];
        }
        ArrayList<Infos> infos = new ArrayList<Infos>();
        for (String id:binding.getProjectIds()) {
            File file = studioProvider.repositoryManager.getFile(id);
            String gav = "nuxeo-studio:"+id+":0.0.0-SNAPSHOT";
            infos.add(new Infos(file, gav));
        }
        return infos.toArray(new Infos[infos.size()]);
    }

}
