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
package org.nuxeo.ide.sdk.server.ui;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.core.search.TypeNameMatch;
import org.eclipse.jdt.core.search.TypeNameMatchRequestor;
import org.eclipse.jdt.ui.JavaUI;
import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.sdk.SDKPlugin;

/**
 * Prefer source match over archive match
 * 
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class OpenClassAction extends TypeNameMatchRequestor {
    protected String packageName;

    protected String className;

    protected TypeNameMatch match;

    public OpenClassAction(String name) {
        int i = name.lastIndexOf('.');
        if (i > -1) {
            packageName = name.substring(0, i);
            className = name.substring(i + 1);
        } else {
            packageName = "";
            className = name;
        }
    }

    @Override
    public void acceptTypeNameMatch(TypeNameMatch match) {
        if (this.match == null) {
            this.match = match;
        } else if (!match.getPackageFragmentRoot().isArchive()) {
            this.match = match;
        }
    }

    public TypeNameMatch getMatch() {
        return match;
    }

    public void run() {
        Job job = new Job("Open class") {
            @Override
            protected IStatus run(IProgressMonitor monitor) {
                monitor.beginTask("Finding type", 1);
                SearchEngine engine = new SearchEngine();
                IStatus status = Status.OK_STATUS;
                try {
                    engine.searchAllTypeNames(packageName.toCharArray(),
                            SearchPattern.R_EXACT_MATCH,
                            className.toCharArray(),
                            SearchPattern.R_EXACT_MATCH,
                            IJavaSearchConstants.CLASS_AND_INTERFACE,
                            SearchEngine.createWorkspaceScope(),
                            OpenClassAction.this,
                            IJavaSearchConstants.WAIT_UNTIL_READY_TO_SEARCH,
                            monitor);
                    monitor.worked(1);
                } catch (Throwable t) {
                    status = new Status(IStatus.ERROR, SDKPlugin.PLUGIN_ID,
                            "failed to seach for type: " + packageName + "."
                                    + className, t);
                }
                monitor.done();
                return status;
            }
        };
        job.schedule();
        try {
            job.join();
            if (match != null) {
                JavaUI.openInEditor(match.getType());
            } else {
                UI.showWarning("No class matching '" + packageName + "."
                        + className + "' was found");
            }
        } catch (Exception e) {
            // do nothing
        }
    }

}