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

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

/**
 * Run a process and block until the process is terminated
 * 
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class ProcessRunner implements Runnable {

    protected CommandLine cmdLine;

    protected File workingDir;

    public ProcessRunner(CommandLine cmdLine, File workingDir) {
        this.cmdLine = cmdLine;
    }

    public CommandLine getCommandLine() {
        return cmdLine;
    }

    protected void terminated(int status, Throwable e) {
        // do nothing
    }

    protected void started() {
        // do nothing
    }

    public void runAsync() {
        Thread thread = new Thread(this, "Process Runner");
        thread.start();
    }

    public void runAsJob(String jobName) {
        new Job(jobName) {
            @Override
            protected IStatus run(IProgressMonitor monitor) {
                monitor.beginTask("", 1);
                ProcessRunner.this.run();
                monitor.worked(1);
                monitor.done();
                return Status.OK_STATUS;
            }
        }.schedule();
    }

    @Override
    public void run() {
        DefaultExecutor executor = new DefaultExecutor();
        if (workingDir != null) {
            executor.setWorkingDirectory(workingDir);
        }
        executor.setExitValue(0);

        started();

        int exitStatus = -1;
        try {
            exitStatus = executor.execute(cmdLine);
            terminated(exitStatus, null);
        } catch (Throwable t) {
            terminated(exitStatus, t);
        }

    }

    protected void closeStream(Process process) {
        try {
            process.getInputStream().close();
        } catch (Throwable t) {
            // do nothing
        }
    }
}
