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

import java.util.ArrayList;
import java.util.List;

import org.nuxeo.ide.sdk.model.Artifact;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class DependencyEntry {

    protected Artifact artifact;

    protected List<Dependency> deps;

    public DependencyEntry(Artifact artifact) {
        this.artifact = artifact;
        deps = new ArrayList<Dependency>();
    }

    public Artifact getArtifact() {
        return artifact;
    }

    public List<Dependency> getDependencies() {
        return deps;
    }

    public void addDependency(Dependency dep) {
        deps.add(dep);
    }

    public boolean isEmpty() {
        return deps.isEmpty();
    }

    public int size() {
        return deps.size();
    }

    public String getLocation() {
        if (deps.isEmpty()) {
            return "";
        }
        return deps.get(0).getLocation();
    }

    public boolean isResolved() {
        return !"*".equals(artifact.getGroupId());
    }

    public String getLabel() {
        String label = artifact.toString();
        if (artifact.getScope() != null) {
            label = label + " (scope: " + artifact.getScope() + ")";
        }
        return isResolved() ? label : "Unresolved - " + getLocation();
    }
}
