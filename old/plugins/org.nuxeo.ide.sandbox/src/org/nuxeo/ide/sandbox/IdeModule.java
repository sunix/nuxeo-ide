package org.nuxeo.ide.sandbox;

import org.nuxeo.ide.sandbox.templates.TemplateProvider;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;


public class IdeModule extends AbstractModule {

    @Override
    protected void configure() {
        ;
    }

    @Provides
    public TemplateProvider provideTemplateProvider() {
        return new TemplateProvider();
    }
}
