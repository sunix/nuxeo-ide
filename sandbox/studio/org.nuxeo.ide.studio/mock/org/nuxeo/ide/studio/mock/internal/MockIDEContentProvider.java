package org.nuxeo.ide.studio.mock.internal;

import java.io.File;

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


    protected void populate() {
        ProjectBean p1 = new ProjectBean("p1");
        ProjectBean p2 = new ProjectBean("p2");
        setProjects(p1, p2);
    }


    @Override
    public StudioIDEProject[] getProjects() {
        return projects;
    }


    @Override
    public String getFeatures(String projectId) {
        return null;
    }

    /* (non-Javadoc)
     * @see org.nuxeo.ide.studio.connector.StudioIDEContentProvider#getJar(java.lang.String)
     */
    @Override
    public File getJar(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.nuxeo.ide.studio.connector.StudioIDEContentProvider#updateJar(java.lang.String)
     */
    @Override
    public void updateJar(String projectName) {
        // TODO Auto-generated method stub

    }
}
