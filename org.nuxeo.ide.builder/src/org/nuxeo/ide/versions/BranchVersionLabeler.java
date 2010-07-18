package org.nuxeo.ide.versions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.matchers.JUnitMatchers;
import org.nuxeo.ide.Activator;
import org.nuxeo.ide.files.TestResourcesLoader;
import org.nuxeo.ide.templates.TemplateProvider;
import org.xml.sax.InputSource;

import com.google.inject.Inject;

import freemarker.ext.dom.NodeModel;
import freemarker.template.Template;

public class BranchVersionLabeler {

	protected Template template;

	protected static final Log log = LogFactory.getLog(BranchVersionLabeler.class);

	@Inject
	public void loadTemplate(TemplateProvider provider) throws IOException {
	    template = provider.getTemplate(BranchVersionLabeler.class);
	}

	public void transform(String originalLabel, String newLabel, Reader reader, Writer writer) throws Exception {
	    InputSource source = new InputSource(reader);
	    NodeModel model = NodeModel.parse(source, false, false);
	    Map<String,Object> rootMap = new HashMap<String,Object>();
	    rootMap.put("doc", model);
	    rootMap.put("originalLabel", originalLabel);
	    rootMap.put("newLabel", newLabel);
	    template.process(rootMap, writer);
	}

	public void tranform(String originalLabel, String newLabel, IFile pomFile, IProgressMonitor monitor) throws CoreException {
	    Reader reader = new InputStreamReader(pomFile.getContents());
	    ByteArrayOutputStream output = new ByteArrayOutputStream();
	    Writer writer = new OutputStreamWriter(output);
	    try {
            transform(originalLabel, newLabel, reader, writer);
        } catch (Exception e) {
           throw Activator.wrapError("templating error", e);
        }
	    pomFile.setContents(new ByteArrayInputStream(output.toByteArray()), IResource.REPLACE, monitor);
	}

	@Test
	public void testTransformation() throws Exception {
	    loadTemplate(new TemplateProvider());
	    File pomFile = TestResourcesLoader.getResource("/resources/nuxeo-example-pom.xml");
	    InputStream input = new FileInputStream(pomFile);
	    ByteArrayOutputStream output = new ByteArrayOutputStream();
	    transform("(.*)-SNAPSHOT", "-NX1-SNAPSHOT", new InputStreamReader(input), new OutputStreamWriter(output));
	    String content = output.toString().replace(" >", ">");
	    Assert.assertNotNull("content is null", content);
	    Assert.assertFalse("content is empty", content.isEmpty());
	    Assert.assertThat("does not match new version", content, JUnitMatchers.containsString("1.6.2-NX1-SNAPSHOT"));
	    log.trace(content);
	}

}
