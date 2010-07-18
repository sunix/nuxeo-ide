package org.nuxeo.ide.files;

import java.io.File;

import freemarker.template.utility.SecurityUtilities;

public class TestResourcesLoader {

    public static final File userDir = 	   new File(SecurityUtilities.getSystemProperty("user.dir"));

    public static File getResource(String path) {
        return new File(userDir.getAbsolutePath().concat("/").concat(path));
    }

}
