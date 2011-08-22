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
package org.nuxeo.ide.sdk.index;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.nuxeo.ide.sdk.model.Artifact;
import org.nuxeo.ide.sdk.model.PomModel;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class Index {

    private volatile static Map<String, String> index;

    public static Map<String, String> loadIndex(URL url) throws IOException {
        InputStream in = url.openStream();
        try {
            return loadIndex(in);
        } finally {
            in.close();
        }
    }

    public static Map<String, String> loadIndex(File file) throws IOException {
        FileInputStream in = new FileInputStream(file);
        try {
            return loadIndex(in);
        } finally {
            in.close();
        }
    }

    public static Map<String, String> loadIndex(InputStream in)
            throws IOException {
        HashMap<String, String> index = new HashMap<String, String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line = reader.readLine();
        while (line != null) {
            line = line.trim();
            if (line.length() != 0 && !line.startsWith("#")) {
                int i = line.indexOf('=');
                if (i > -1) {
                    index.put(line.substring(0, i).trim(),
                            line.substring(i + 1).trim());
                }
            }
            line = reader.readLine();
        }
        return index;
    }

    public static Map<String, String> loadBuiltinIndex() throws IOException {
        URL url = Index.class.getResource("index.properties");
        if (url != null) {
            return loadIndex(url);
        }
        return null;
    }

    public static Map<String, String> getIndex() {
        Map<String, String> _index = index;
        if (_index == null) {
            try {
                _index = loadBuiltinIndex();
                index = _index;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return _index;
    }

    public static Artifact resolve(Dependency dep) {
        if (dep.isBinary()) {
            String gav = getIndex().get(dep.getJar().getName());
            if (gav != null) {
                return Artifact.fromGav(gav);
            }
        } else {
            try {
                PomModel pom = PomModel.getPomModel(dep.getProject().getProject());
                String groupId = pom.getGroupId();
                if (groupId != null) {
                    String artifactId = pom.getArtifactId();
                    if (artifactId != null) {
                        return new Artifact(groupId, artifactId,
                                pom.getArtifactVersion());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static DependencyEntry[] resolve(Collection<Dependency> deps) {
        DependencyEntry unresolved = new DependencyEntry(new Artifact("*", "*"));
        TreeMap<String, DependencyEntry> map = new TreeMap<String, DependencyEntry>();
        for (Dependency dep : deps) {
            Artifact artifact = resolve(dep);
            if (artifact != null) {
                DependencyEntry entry = map.get(artifact.getId());
                if (entry == null) {
                    entry = new DependencyEntry(artifact);
                    map.put(artifact.getId(), entry);
                }
                entry.addDependency(dep);
            } else {
                unresolved.addDependency(dep);
            }
        }
        if (!unresolved.isEmpty()) {
            map.put(unresolved.getArtifact().getId(), unresolved);
        }
        return map.values().toArray(new DependencyEntry[map.size()]);
    }

}
