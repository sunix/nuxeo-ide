package org.nuxeo.ide.demo;

import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nuxeo.ecm.core.api.ClientException;
import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.api.PathRef;
import org.nuxeo.ecm.core.api.model.Property;
import org.nuxeo.ecm.core.schema.DocumentType;
import org.nuxeo.ecm.core.test.CoreFeature;
import org.nuxeo.ecm.core.test.annotations.RepositoryConfig;
import org.nuxeo.runtime.test.runner.Deploy;
import org.nuxeo.runtime.test.runner.Features;
import org.nuxeo.runtime.test.runner.FeaturesRunner;

import com.google.inject.Inject;

@RunWith(FeaturesRunner.class)
@Features(CoreFeature.class)
@Deploy({ "studio.extensions.test1" })
@RepositoryConfig(init = PopulateDemoRepo.class)
public class CanLoadSchemaFromStudio {

	@Inject CoreSession repo;

	DocumentModel doc() throws ClientException {
		return repo.getDocument(new PathRef("/demo"));
	}
	
	Property field() throws ClientException {
		return doc().getProperty("demo:testField");
	}
	
	@Test public void haveDemoDoc() throws ClientException {
		DocumentType type = repo.getDocumentType("Demo");
		assertThat(type, notNullValue());
	}
	
	@Test public void haveTestField() throws ClientException {
		Property field = field();
		assertThat(field, notNullValue());
	}
	
	@Test public void fieldIsStringBased() throws ClientException {
		Property field = field();
		String typename = field.getField().getType().getName();
		assertThat(typename, is("string"));
	}
	
	@Test public void fieldIsDateBased() throws ClientException {
		Property field = field();
		String typename = field.getField().getType().getName();
		assertThat(typename, is("date"));
	}
}
