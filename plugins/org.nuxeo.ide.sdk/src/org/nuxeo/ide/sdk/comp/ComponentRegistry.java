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
package org.nuxeo.ide.sdk.comp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class ComponentRegistry {

    protected List<ComponentModel> components;

    protected List<ServiceModel> services;

    protected List<ExtensionPointModel> xpoints;

    public ComponentRegistry() {
        components = new ArrayList<ComponentModel>();
        services = new ArrayList<ServiceModel>();
        xpoints = new ArrayList<ExtensionPointModel>();
    }

    public ComponentModel[] getComponents() {
        return components.toArray(new ComponentModel[components.size()]);
    }

    public ServiceModel[] getServices() {
        return services.toArray(new ServiceModel[services.size()]);
    }

    public ExtensionPointModel[] getExtensionPoints() {
        return xpoints.toArray(new ExtensionPointModel[xpoints.size()]);
    }

    public List<ComponentModel> getComponentsList() {
        return components;
    }

    public List<ServiceModel> getServiceList() {
        return services;
    }

    public List<ExtensionPointModel> getExtensionPointList() {
        return xpoints;
    }

}
