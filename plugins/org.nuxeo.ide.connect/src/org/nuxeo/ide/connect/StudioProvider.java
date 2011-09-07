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
package org.nuxeo.ide.connect;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.nuxeo.ide.common.IOUtils;
import org.nuxeo.ide.connect.studio.StudioProject;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class StudioProvider {

    protected File file;

    protected StudioProject[] projects;

    public StudioProvider(File file) throws Exception {
        this.file = file;
        reload();
    }

    public void updateProjects(String json) throws Exception {
        IOUtils.writeFile(file, json);
        reload();
    }

    /**
     * Update the projects from the given input stream. The InputStream will be
     * closed.
     * 
     * @param in
     * @throws Exception
     */
    public void updateProjects(InputStream in) throws Exception {
        try {
            IOUtils.copyToFile(in, file);
        } finally {
            in.close();
        }
        reload();
    }

    public void reload() throws IOException {
        if (file.exists()) {
            FileInputStream in = new FileInputStream(file);
            List<StudioProject> result = StudioProject.readProjects(in);
            projects = result.toArray(new StudioProject[result.size()]);
        } else {
            projects = new StudioProject[0];
        }
    }

    public File getFile() {
        return file;
    }

    public StudioProject[] getProjects() {
        return projects;
    }

    // TODO: to remove
    protected static String[] paths = new String[] { "dc:title", "dc:subjects",
            "dc:created", "dc:description", "dc:rights", "dc:source",
            "dc:coverage", "dc:modified", "dc:issued", "dc:valid",
            "dc:expired", "dc:format", "dc:language", "dc:creator",
            "dc:contributors", "dc:lastContributor" };

    static {
        Arrays.sort(paths);
    }

    public String[] getSchemaPaths() {
        return paths;
    }

    public static List<String> getSchemaPaths(String prefix) {
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < paths.length; i++) {
            if (paths[i].startsWith(prefix)) {
                result.add(paths[i]);
            } else {
                if (!result.isEmpty()) {
                    // stop iteration since entries are sorted
                    break;
                }
            }
        }
        return result;
    }

}
