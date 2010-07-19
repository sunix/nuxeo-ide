package org.nuxeo.ide.files;

import java.io.File;

public class TestResourcesLoader {

    public static final File userDir = 	   new File(System.getProperty("user.dir"));

    public static File getResource(String path) {
        return new File(userDir.getAbsolutePath().concat("/").concat(path));
    }

}
