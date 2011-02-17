package org.nuxeo.ide.studio.mock.internal;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.nuxeo.ide.studio.connector.StudioIDEContentProvider;
import org.nuxeo.ide.studio.connector.StudioIDEProject;
import org.nuxeo.ide.studio.connector.internal.ProjectBean;

public class MockIDEContentProvider implements StudioIDEContentProvider {
        
    protected ProjectBean[] projects = new ProjectBean[0];
    
    public void setProjects(ProjectBean... beans) {
        this.projects = beans;
    }
    
    public MockIDEContentProvider() {
        populate();
    } 

    protected void injectProjectURL(ProjectBean p) {
        p.setBinaryPath("/" + p.getName() + ".jar");
    }
    
    protected void populate() {
        ProjectBean p1 = new ProjectBean("p1");
        ProjectBean p2 = new ProjectBean("p2");
        injectProjectURL(p1);
        injectProjectURL(p2);
        setProjects(p1, p2);
    }
        

    @Override
    public StudioIDEProject[] getProjects() {
        return projects;
    }

 
    @Override
    public StudioIDEProject getDefaultProject() {
        return projects[0];
    }

    @Override
    public StudioIDEProject getProject(String name) {
       for (StudioIDEProject p:projects) {
           if (name.equals(p.getName())) {
               return p;
           }
       }
       throw new IllegalArgumentException("no such project " + name);
    }

    @Override
    public IPath find(String path) {
        return new Path(path);
    }

}
