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
package org.nuxeo.ide.sdk.features;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.resource.ResourceChange;
import org.nuxeo.ide.sdk.SDKPlugin;
import org.nuxeo.ide.sdk.model.ManifestWriter;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class ManifestChange extends ResourceChange {

    protected Map<String, List<String>> append;

    protected Map<String, String> replace;

    protected Map<String, List<String>> removeValues;

    protected List<String> removeKeys;

    protected IFile file;

    public ManifestChange(IFile file) {
        this.file = file;
        this.append = new HashMap<String, List<String>>();
        this.replace = new HashMap<String, String>();
        this.removeValues = new HashMap<String, List<String>>();
        this.removeKeys = new ArrayList<String>();
    }

    public void remove(String key) {
        remove(key, null);
    }

    public void remove(String key, String value) {
        if (value == null) {
            removeKeys.add(key);
        } else {
            List<String> list = removeValues.get(key);
            if (list == null) {
                list = new ArrayList<String>();
                removeValues.put(key, list);
            }
            if (!list.contains(value)) {
                list.add(value);
            }
        }
    }

    public void append(String key, String value) {
        List<String> list = append.get(key);
        if (list == null) {
            list = new ArrayList<String>();
            append.put(key, list);
        }
        if (!list.contains(value)) {
            list.add(value);
        }
    }

    public void replace(String key, String value) {
        replace.put(key, value);
    }

    @Override
    protected IResource getModifiedResource() {
        return file;
    }

    @Override
    public String getName() {
        return "Update Manifest";
    }

    @Override
    public Change perform(IProgressMonitor pm) throws CoreException {
        try {
            ManifestWriter writer = ManifestWriter.getWriter(file.getProject());
            Change change = applyChanges(writer);
            writer.write(pm);
            return change;
        } catch (CoreException e) {
            throw e;
        } catch (Exception e) {
            throw new CoreException(new Status(IStatus.ERROR,
                    SDKPlugin.PLUGIN_ID, "Failed to update manifest"));
        }
    }

    protected Change applyChanges(ManifestWriter writer) throws Exception {
        ManifestChange change = new ManifestChange(file);
        for (Map.Entry<String, String> entry : replace.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            String old = writer.replaceEntry(key, value);
            if (old != null) {
                change.replace(key, old);
            } else {
                change.remove(key, null);
            }
        }

        for (Map.Entry<String, List<String>> entry : removeValues.entrySet()) {
            String key = entry.getKey();
            List<String> list = entry.getValue();
            for (String value : list) {
                if (writer.removeEntry(key, value)) {
                    change.append(key, value);
                }
            }
        }

        for (String key : removeKeys) {
            String value = writer.removeEntry(key);
            if (value != null) {
                change.replace(key, value);
            }
        }

        for (Map.Entry<String, List<String>> entry : append.entrySet()) {
            String key = entry.getKey();
            List<String> list = entry.getValue();
            for (String value : list) {
                if (writer.appendEntry(key, value)) {
                    change.remove(key, value);
                }
            }
        }

        return change;
    }
}
