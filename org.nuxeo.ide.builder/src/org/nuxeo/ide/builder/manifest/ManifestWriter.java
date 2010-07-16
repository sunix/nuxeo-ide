package org.nuxeo.ide.builder.manifest;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ManifestWriter {
	
	Log log = LogFactory.getLog(ManifestWriter.class);
	
	protected Writer writer;
	
	public ManifestWriter(OutputStream out) {
		this.writer = new PrintWriter(new OutputStreamWriter(out));
	}
	
	protected static final String LS = System.getProperty("line.separator");
	
	protected DirectiveTransformer transformer = new DirectiveTransformer.Noop();
	
	public void setDirectiveTransformer(DirectiveTransformer transformer) {
		this.transformer = transformer;
	}
	
	public void write(Manifest mf) throws IOException {
		Attributes attributes = mf.getMainAttributes();
		
		for (Map.Entry<Object,Object> entry:attributes.entrySet()) {
			String name = entry.getKey().toString();
			String value = (String)entry.getValue();
			DirectiveInfo info = new DirectiveInfo(name, value);
			try {
				info = transformer.process(info);
			} catch (DirectiveTransformerVeto e) {
				continue;
			}
			writeDirective(info);
		}
		writer.flush();
		writer.close();
	}
	
	
	protected void writeDirective(DirectiveInfo info) throws IOException {
		writer.append(String.format("%s:%s\n", info.name, info.value));
	}
	
	protected static String[] splitValues(String value) {
		return value.split(",");
	}


}
