package org.nuxeo.ide.studio.mock.internal;

import java.net.MalformedURLException;
import java.net.URL;

import org.nuxeo.ide.studio.NxStudioWorkbenchProvider;
import org.nuxeo.ide.studio.dto.NxStudioProjectBean;
import org.nuxeo.ide.studio.dto.NxStudioWorkbenchBean;

public class MockWorbenchProvider implements NxStudioWorkbenchProvider {

    public MockWorbenchProvider() {
        
    } 

    protected URL newURL(String location) {
        try {
            return new URL(location);
        } catch (MalformedURLException e) {
            throw new Error("Cannot encode URL" + e, e);
        }
    }
    
    @Override
    public NxStudioWorkbenchBean getWorkbench() {
        NxStudioProjectBean p = new NxStudioProjectBean("default", newURL("file://tmp/default.jar"));
        NxStudioWorkbenchBean wb = new NxStudioWorkbenchBean(newURL("null://pfff"));
        wb.setProjects(p);
        return wb;
    }

}
