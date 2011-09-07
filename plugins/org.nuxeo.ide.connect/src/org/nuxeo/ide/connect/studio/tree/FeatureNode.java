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
package org.nuxeo.ide.connect.studio.tree;

import org.nuxeo.ide.connect.studio.StudioFeature;
import org.nuxeo.ide.connect.studio.StudioProject;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class FeatureNode extends Node<StudioFeature> {

    protected StudioFeature feature;

    public FeatureNode(StudioProject project, StudioFeature feature) {
        super(project);
        this.feature = feature;
    }

    @Override
    public String getId() {
        return feature.getId();
    }

    @Override
    public String getLabel() {
        return feature.getId();
    }

    @Override
    public String getIcon() {
        return "icons/studio/obj/" + feature.getType() + ".gif";
    }

    @Override
    public boolean hasChildren() {
        return false;
    }

    @Override
    public Node<?>[] getChildren() {
        return null;
    }

    @Override
    public boolean isTerminal() {
        return true;
    }

    @Override
    public StudioFeature getData() {
        return feature;
    }

}
