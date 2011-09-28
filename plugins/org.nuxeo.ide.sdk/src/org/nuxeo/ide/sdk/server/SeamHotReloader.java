package org.nuxeo.ide.sdk.server;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.internal.preferences.Base64;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.nuxeo.ide.common.IOUtils;
import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.sdk.DeploymentChangedListener;
import org.nuxeo.ide.sdk.NuxeoSDK;
import org.nuxeo.ide.sdk.deploy.Deployment;

public class SeamHotReloader implements DeploymentChangedListener {


    @Override
    public void deploymentChanged(NuxeoSDK sdk, Deployment deployment) {
        Map<String, List<File>> i18nFiles = new HashMap<String, List<File>>();
        // set target
        File targetWeb = new File(sdk.getInstallDirectory(), "nxserver");
        File targetBinaries = new File(targetWeb, "nuxeo.war/WEB-INF/dev");

        IOUtils.deleteTree(targetBinaries);
        targetBinaries.mkdir();

        // visit projects
        for (IProject project : deployment.getProjects()) {
            try {
                IJavaProject java = JavaCore.create(project);
                copyBinaries(java, targetBinaries);
                copyWebFiles(java, targetWeb);
                collectI18N(java, targetWeb, i18nFiles);
            } catch (Exception e) {
                UI.showError(
                        "Cannot synch seam components of " + project.getName()
                                + " to " + sdk.getLocation(), e);
            }
        }
        
        // append i18n resource bundles
        try {
            appendI18N(i18nFiles, targetWeb);
        } catch (Exception e) {
            UI.showError("Cannot append i18n resource bundles", e);
        }

        // ask server for reloading
        try {
            postSeamReload(sdk);
        } catch (IOException e) {
            UI.showError("Cannot request seam reload", e);
        }
    }

    protected void copyBinaries(IJavaProject java, File target)
            throws CoreException, IOException {
        IProject project = java.getProject();
        IFolder source = project.getFolder("src/main/seam");
        IPackageFragmentRoot root = java.getPackageFragmentRoot(source);
        if (root == null || !root.exists()) {
            return; // no seam components
        }
        IClasspathEntry cpe = root.getRawClasspathEntry();
        IPath binPath = cpe.getOutputLocation();
        IFolder binFolder = project.getParent().getFolder(binPath);
        for (IResource m : binFolder.members()) {
            IOUtils.copyTree(m.getRawLocation().toFile(), target);
        }
    }

    protected void copyWebFiles(IJavaProject java, File target)
            throws CoreException, IOException {
        IFolder web = java.getProject().getFolder("src/main/resources/web");
        if (!web.exists()) {
            return; // no web files
        }
        for (IResource m : web.members()) {
            IOUtils.copyTree(m.getRawLocation().toFile(), target);
        }
    }

    protected void collectI18N(IJavaProject java, File target, Map<String,List<File>> i18nFiles)
            throws CoreException, IOException {
        IFolder i18n = java.getProject().getFolder(
                "src/main/i18n/web/nuxeo.war/WEB-INF/classes");
        if (!i18n.exists()) {
            return; // no i18n resources bundles
        }
        for (IResource m : i18n.members()) {
            File contribution = m.getRawLocation().toFile();
            String name = contribution.getName();
            if (!i18nFiles.containsKey(name)) {
                i18nFiles.put(name, new ArrayList<File>());
            }
            i18nFiles.get(name).add(contribution);
        }
    }

    protected void appendI18N(Map<String,List<File>> i18nfiles, File target) throws IOException {
        File i18n = new File(target, "nuxeo.war/WEB-INF/classes");
        for (String name : i18nfiles.keySet()) {
            File original = new File(i18n, name);
            File backup = new File(i18n, name + "~bak");
            if (!backup.exists()) {
                IOUtils.copyFile(original, backup);
            }
            IOUtils.copyFile(backup, original);
            for (File file : i18nfiles.get(name)) {
                IOUtils.appendFile(original, file);
            }
        }
    }

    protected void postSeamReload(NuxeoSDK sdk) throws IOException {
        URL location = sdk.getRemoteLocation("restAPI/seamReload");
        HttpURLConnection connection = (HttpURLConnection) location.openConnection();
        String authorization = new String(
                Base64.encode("Administrator:Administrator".getBytes()));
        connection.setRequestProperty("Authorization", "Basic " + authorization);
        connection.setRequestMethod("POST");
        connection.getResponseCode();
    }

}
