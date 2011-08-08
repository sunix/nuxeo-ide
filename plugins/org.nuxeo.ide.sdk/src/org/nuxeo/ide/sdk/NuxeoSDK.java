/*
 * (C) Copyright 2006-2010 Nuxeo SAS (http://nuxeo.com/) and contributors.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * Contributors:
 *     bstefanescu
 */
package org.nuxeo.ide.sdk;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.sdk.server.ServerController;
import org.nuxeo.ide.sdk.ui.NuxeoNature;
import org.nuxeo.ide.sdk.ui.SDKClassPathContainer;
import org.osgi.service.prefs.BackingStoreException;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class NuxeoSDK {

    /**
     * The Nuxeo SDK instance on the active Eclipse Workspace.
     */
    private static volatile NuxeoSDK instance = null;

    private static ListenerList listeners = new ListenerList();

    static void initialize() throws BackingStoreException {
        SDKInfo info = SDKRegistry.getDefaultSDK();
        if (info != null) {
            instance = new NuxeoSDK(info);
        }
    }

    public static NuxeoSDK getDefault() {
        // TODO
        return new NuxeoSDK(
                new SDKInfo(
                        new File(
                                "/Users/bstefanescu/work/nuxeo/nuxeo-distribution/nuxeo-distribution-tomcat/target/nuxeo-dm-5.4.3-SNAPSHOT-tomcat"),
                        "5.4.3"));
        // return instance;
    }

    public static NuxeoSDK setDefault(SDKInfo info) {
        boolean changed = false;
        NuxeoSDK sdk = getDefault();
        if (sdk == null) {
            if (info != null) {
                sdk = new NuxeoSDK(info);
                changed = true;
            }
        } else {
            if (info == null) {
                sdk = null;
                changed = true;
            } else {
                if (!sdk.info.equals(info)) {
                    sdk = new NuxeoSDK(info);
                    changed = true;
                }
            }
        }
        if (changed) {
            instance = sdk;
            fireSDKChanged(sdk);
            try {
                rebuildNuxeoProjects();
            } catch (CoreException e) {
                UI.showError("Failed to rebuild Nuxeo Projects", e);
            }
        }
        return sdk;
    }

    public static void addSDKChangedListener(SDKChangedListener listener) {
        listeners.add(listener);
    }

    public static void removeSDKChangedListener(SDKChangedListener listener) {
        listeners.remove(listener);
    }

    private static void fireSDKChanged(NuxeoSDK sdk) {
        for (Object listener : listeners.getListeners()) {
            ((SDKChangedListener) listener).handleSDKChanged(sdk);
        }
    }

    protected SDKInfo info;

    /**
     * Singleton classpath container used by project that use SDK deps and not
     * maven. Only initialized at demand.
     */
    protected volatile SDKClassPathContainer cp;

    // /**
    // * Class index (class -> artifact). ONly initialized at demand. Used to
    // * generate maven dependencies.
    // */
    // protected volatile Index index;

    protected ServerController server;

    public NuxeoSDK(SDKInfo info) {
        this.info = info;
    }

    public SDKInfo getInfo() {
        return info;
    }

    public ServerController getServer() {
        return new ServerController(info);
    }

    public SDKClassPathContainer getClassPathContainer(IPath containerPath) {
        SDKClassPathContainer _cp = cp;
        if (_cp == null) {
            synchronized (this) {
                _cp = new SDKClassPathContainer(containerPath);
                cp = _cp;
            }
        }
        return _cp;
    }

    public static void rebuildProjects() {
        doBuildOperation(IncrementalProjectBuilder.FULL_BUILD, null);
    }

    public static void rebuildNuxeoProjects() throws CoreException {
        ArrayList<IProject> nxProjects = new ArrayList<IProject>();
        for (IProject project : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
            if (project.hasNature(NuxeoNature.ID)) {
                nxProjects.add(project);
            }
        }
        doBuildOperation(IncrementalProjectBuilder.FULL_BUILD, nxProjects);
    }

    private static void doBuildOperation(final int buildType,
            final List<IProject> projects) {
        Job buildJob = new Job("Building Workspace") {
            protected IStatus run(IProgressMonitor monitor) {
                int ticks = 100;
                String message = "Rebuilding All ...";
                if (projects != null) {
                    ticks = projects.size();
                    message = "Rebuilding Nuxeo Projects ...";
                }
                monitor.beginTask(message, ticks);
                try {
                    if (projects == null) {
                        ResourcesPlugin.getWorkspace().build(buildType,
                                new SubProgressMonitor(monitor, 100));
                    } else {
                        for (IProject project : projects) {
                            project.build(buildType, new SubProgressMonitor(
                                    monitor, 1));
                        }
                    }
                } catch (CoreException e) {
                    return e.getStatus();
                } finally {
                    monitor.done();
                }
                return Status.OK_STATUS;
            }

            public boolean belongsTo(Object family) {
                return ResourcesPlugin.FAMILY_MANUAL_BUILD == family;
            }
        };
        buildJob.setUser(true);
        buildJob.schedule();
    }

}
