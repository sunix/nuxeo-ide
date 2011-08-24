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
package org.nuxeo.ide.sdk.userlibs;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.nuxeo.ide.sdk.model.Artifact;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class UserLib {

    protected String path;

    protected String groupId;

    protected String artifactId;

    protected String version;

    protected String classifier;

    public UserLib(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public String getName() {
        int i = path.lastIndexOf('/');
        return i == -1 ? path : path.substring(i + 1);
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setClassifier(String classifier) {
        this.classifier = classifier;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public String getVersion() {
        return version;
    }

    public String getClassifier() {
        return classifier;
    }

    public Artifact getArtifact() {
        if (groupId != null && artifactId != null) {
            return new Artifact(groupId, artifactId, version);
        }
        return null;
    }

    public File getFile() {
        return new File(path);
    }

    public URL getUrl() throws MalformedURLException {
        return new File(path).toURI().toURL();
    }

    @Override
    public String toString() {
        return path;
    }

}
