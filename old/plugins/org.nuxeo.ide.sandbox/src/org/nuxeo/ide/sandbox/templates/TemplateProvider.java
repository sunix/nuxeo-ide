package org.nuxeo.ide.sandbox.templates;

import java.io.IOException;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class TemplateProvider {

    Configuration configuration = new Configuration();

    public Template getTemplate(Class<?> clazz) throws IOException {
        return configuration.getTemplate("/templates/"+clazz.getSimpleName() + ".ftl");
    }

}
