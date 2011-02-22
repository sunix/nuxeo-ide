package org.nuxeo.ide.demo;

import org.nuxeo.ecm.core.api.ClientException;
import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.api.impl.DocumentModelImpl;
import org.nuxeo.ecm.core.test.DefaultRepositoryInit;
import org.nuxeo.ecm.core.test.annotations.RepositoryInit;

public class PopulateDemoRepo extends DefaultRepositoryInit implements
		RepositoryInit {

	@Override
	public void populate(CoreSession repo) throws ClientException {
		String rootPath = repo.getRootDocument().getPathAsString();
		DocumentModel doc = new DocumentModelImpl(rootPath, "demo", "Demo" );
		repo.createDocument(doc);
	}

}
