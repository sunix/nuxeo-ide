package org.nuxeo.ide;

import org.nuxeo.ide.templates.TemplateProvider;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class IdeModule extends AbstractModule {

    @Override
    protected void configure() {
        ;
    }

    @Provides
    TemplateProvider provideTemplateProvider() {
        return new TemplateProvider();
    }
}
