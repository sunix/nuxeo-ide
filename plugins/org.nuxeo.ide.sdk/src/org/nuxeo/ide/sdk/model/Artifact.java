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
package org.nuxeo.ide.sdk.model;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class Artifact {

    public static Artifact fromGav(String gav) {

        String artifactId = null;
        String version = null;
        int i = gav.indexOf(':');
        if (i == -1) {
            throw new IllegalArgumentException("No groupId in GAV: " + gav);
        }
        String groupId = gav.substring(0, i);
        int j = gav.indexOf(':', ++i);
        if (j > -1) {
            artifactId = gav.substring(i, j);
            version = gav.substring(j + 1);
        } else {
            artifactId = gav.substring(i);
        }
        return new Artifact(groupId, artifactId, version);
    }

    protected String id;

    protected String groupId;

    protected String artifactId;

    protected String version;

    protected String scope;

    public Artifact(String groupId, String artifactId) {
        this(groupId, artifactId, null);
    }

    public Artifact(String groupId, String artifactId, String version) {
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
        this.id = groupId + ':' + artifactId;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getScope() {
        return scope;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return groupId + ":" + artifactId + ":" + version;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Artifact) {
            return ((Artifact) obj).id.equals(id);
        }
        return false;
    }

}
