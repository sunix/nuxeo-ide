package org.nuxeo.ide.manifests;

import static junit.framework.Assert.assertTrue;

import static junit.framework.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.jar.Manifest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.nuxeo.ide.manifests.DirectiveTransformer.ExportPackageVersionEraser;

public class TestManifestWriter  {
	
	protected static final Log log = LogFactory.getLog(TestManifestWriter.class);

	@Test
	public void writeBinary() throws IOException {
		
		URL mfLocation = TestManifestWriter.class.getResource("TestManifestWriter.mf");
		Manifest mf = new Manifest(mfLocation.openStream());
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		new ManifestFormater().format(mf, os);
	}

	@Test
	public void testMultiValues() throws DirectiveTransformerVeto {
		DirectiveTransformer transf= new DirectiveTransformer.MultiValuesPrettyPrinter();
		DirectiveInfo info = transf.process(new DirectiveInfo("test", "toto,titi"));
		assertEquals("name is altered", "test", info.name);
		assertEquals("line is not pretty printed", " toto,\n titi", info.value);
	}
	
	@Test(expected=DirectiveTransformerVeto.class)
	public void testNameVeto() throws DirectiveTransformerVeto {
		DirectiveTransformer nameVeto = new DirectiveTransformer.NameVeto("pfff");
		nameVeto.process(new DirectiveInfo("pfff", ""));
	}
	
	@Test
	public void testExportPackagesVersionEraser() throws DirectiveTransformerVeto {
		ExportPackageVersionEraser eraser = new ExportPackageVersionEraser("1.6.2.SNAPSHOT");
		DirectiveInfo original = new DirectiveInfo("Export-Package", " org.nuxeo;version=\"1.6.2.SNAPSHOT\",\n org.nuxeo.other;version=\"1.6.2.SNAPSHOT\"\n");
		DirectiveInfo info = eraser.process(original);
		assertEquals("incorrect packages", " org.nuxeo,\n org.nuxeo.other\n", info.value);
	}
}
