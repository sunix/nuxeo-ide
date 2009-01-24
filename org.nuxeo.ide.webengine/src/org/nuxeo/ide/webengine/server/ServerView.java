/*
 * (C) Copyright 2006-2008 Nuxeo SAS (http://nuxeo.com/) and contributors.
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
package org.nuxeo.ide.webengine.server;

import java.util.ArrayList;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;
import org.nuxeo.ide.webengine.Nuxeo;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 *
 */
public class ServerView extends ViewPart {

    protected CheckboxTableViewer tv;
    protected Configuration config = null; // the active configuration
    
    @Override
    public void init(IViewSite site, IMemento memento) throws PartInitException {
        super.init(site, memento);
        
        if (memento != null) {
            Configuration.init(memento);
            config = Configuration.get("default");
        }

        ResourcesPlugin.getWorkspace().addResourceChangeListener(new IResourceChangeListener() {
            public void resourceChanged(IResourceChangeEvent event) {
                IResource resource = event.getResource();
                if (resource == null) {
                    refresh(); // may be a nature modification
                } else if (event.getType() == IResourceChangeEvent.PRE_DELETE) {
                    if (resource.getType() == IResource.PROJECT && Nuxeo.isWebEngineProject((IProject)resource)) {
                        refresh();
                    }
                }
}
        });

        
    }
    
    @Override
    public void createPartControl(Composite parent) {
        tv = CheckboxTableViewer.newCheckList(parent, SWT.BORDER);
        PluginProvider provider = new PluginProvider();
        tv.setContentProvider(provider);
        tv.setLabelProvider(provider);
        refresh();
        tv.addCheckStateListener(new ICheckStateListener() {
            public void checkStateChanged(CheckStateChangedEvent event) {   
                config.projects = new ArrayList<IProject>();
                for (Object o : tv.getCheckedElements()) {
                    config.projects.add((IProject)o);
                }
            }  
        });
    }
    
    public void refresh() {
        if (tv != null) {
            tv.setInput(ResourcesPlugin.getWorkspace());
            tv.setCheckedElements(config.projects.toArray());
        }
    }
    
    

    @Override
    public void setFocus() {
    }

    @Override
    public void saveState(IMemento memento) {
        super.saveState(memento);
        Configuration.store(memento);
    }
    
}
