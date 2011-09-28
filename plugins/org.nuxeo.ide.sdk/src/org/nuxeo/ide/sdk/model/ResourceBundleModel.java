package org.nuxeo.ide.sdk.model;

import java.io.File;
import java.io.IOException;

import org.nuxeo.ide.common.IOUtils;

public class ResourceBundleModel {

    protected final String id;
    
    public ResourceBundleModel(String id) {
       this.id = id;
    }

    public void setContent(File dir, String content) throws IOException {
        File file = new File(dir, "src/main/i18n/web/nuxeo.war/WEB-INF/classes/message.properties");
        file.getParentFile().mkdirs();
        IOUtils.appendFile(file, content);
    }

}
