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
package org.nuxeo.ide.sdk.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.equinox.security.storage.StorageException;
import org.nuxeo.ide.common.IOUtils;
import org.nuxeo.ide.sdk.SDKInfo;
import org.nuxeo.ide.sdk.deploy.Deployment;
import org.osgi.service.prefs.BackingStoreException;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class ServerController implements ServerConstants {

    protected File root;

    protected volatile int state = STOPPED;

    protected ListenerList listeners;

    protected ServerLogTail logFile;

    public ServerController(SDKInfo info) {
        this(info.getInstallDirectory());
    }

    protected ServerController(File root) {
        this.root = root;
        listeners = new ListenerList();
    }

    public void addServerLifeCycleListener(ServerLifeCycleListener listener) {
        listeners.add(listener);
    }

    public void removeServerLifeCycleListener(ServerLifeCycleListener listener) {
        listeners.remove(listener);
    }

    protected void fireServerStarting() {
        state = STARTING;
        openLogFile();
        for (Object listener : listeners.getListeners()) {
            ((ServerLifeCycleListener) listener).serverStateChanged(this, state);
        }
    }

    protected void fireServerStarted() {
        state = STARTED;
        for (Object listener : listeners.getListeners()) {
            ((ServerLifeCycleListener) listener).serverStateChanged(this, state);
        }
    }

    protected void fireServerStopping() {
        state = STOPPING;
        for (Object listener : listeners.getListeners()) {
            ((ServerLifeCycleListener) listener).serverStateChanged(this, state);
        }
    }

    protected void fireServerStopped() {
        closeLogFile();
        state = STOPPED;
        for (Object listener : listeners.getListeners()) {
            ((ServerLifeCycleListener) listener).serverStateChanged(this, state);
        }
    }

    protected void fireConsoleText(String text) {
        for (Object listener : listeners.getListeners()) {
            ((ServerLifeCycleListener) listener).handleConsoleText(this, text);
        }
    }

    protected void fireConsoleError(Throwable t) {
        for (Object listener : listeners.getListeners()) {
            ((ServerLifeCycleListener) listener).handleConsoleError(this, t);
        }
    }

    protected synchronized void openLogFile() {
        if (logFile == null) {
            logFile = new ServerLogTail(this);
            logFile.tailAsync();
        }
    }

    protected synchronized void closeLogFile() {
        if (logFile != null) {
            logFile.close();
            logFile = null;
        }
    }

    public ServerLogTail getLogFile() {
        return logFile;
    }

    public boolean start() throws Exception {
        return start(false);
    }

    public boolean stop() throws Exception {
        return stop(false);
    }

    public synchronized boolean startAsJob(boolean isDebug) throws Exception {
        if (state != STOPPED) {
            return false;
        }
        new StartServer(this, isDebug).runAsJob("Starting Nuxeo Server");
        return true;
    }

    public synchronized boolean start(boolean block) throws Exception {
        if (state != STOPPED) {
            return false;
        }
        if (block) {
            new StartServer(this).run();
        } else {
            new StartServer(this).runAsync();
        }
        return true;
    }

    public synchronized boolean stopAsJob() throws Exception {
        if (state == STOPPED) {
            return false;
        }
        new StopServer(this).runAsJob("Stopping Nuxeo Server");
        return true;
    }

    public synchronized boolean stop(boolean block) throws Exception {
        if (state == STOPPED) {
            return false;
        }
        if (block) {
            new StopServer(this).run();
        } else {
            new StopServer(this).runAsync();
        }
        return true;
    }

    public synchronized int getState() {
        return state;
    }

    public synchronized InputStream getConsoleStream() throws IOException {
        if (state == STOPPED) {
            return null;
        }
        return new FileInputStream(new File(root, "log/server.log"));
    }

    public PrintStream getStdout() {
        return null;
    }

    public PrintStream getStderr() {
        return null;
    }

    public ProcessBuilder newProcessBuilder(String command, boolean isDebug)
            throws Exception {
        ProcessBuilder builder = new ProcessBuilder(
                VMUtils.getJavaExecutablePath());
        ServerConfiguration config = ServerConfiguration.getDefault();
        String vmargs = config.getVmArgs(isDebug);
        if (vmargs != null) {
            builder.command().add("-Dlauncher.java.opts=" + vmargs);
        }
        builder.command().add("-Dnuxeo.home=" + root.getAbsolutePath());
        builder.command().add(
                "-Dnuxeo.conf="
                        + new File(root, "bin/nuxeo-sdk.conf").getAbsolutePath());
        builder.command().add(
                "-Dnuxeo.log.dir=" + new File(root, "log").getAbsolutePath());
        builder.command().add("-jar");
        builder.command().add(
                new File(root, "bin/nuxeo-launcher.jar").getAbsolutePath());
        if (command != null) {
            builder.command().add(command);
        }
        builder.directory(new File(root, "bin"));
        return builder;
    }

    public void writeDevBundles(Deployment deployment) throws IOException,
            StorageException, BackingStoreException, CoreException {
        File file = new File(root, "nxserver/dev.bundles");
        String content = deployment == null ? ""
                : deployment.getContentAsString();
        IOUtils.writeFile(file, content);
    }

}
