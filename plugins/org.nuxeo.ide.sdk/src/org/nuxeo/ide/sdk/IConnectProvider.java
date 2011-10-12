package org.nuxeo.ide.sdk;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.equinox.security.storage.StorageException;
import org.osgi.service.prefs.BackingStoreException;

public interface IConnectProvider {
    
    public static String ID = "org.nuxeo.ide.sdk.connect_provider";

    IFile[] getLibraries(IProject project, IProgressMonitor monitor) throws IOException, StorageException, BackingStoreException, CoreException;

}
