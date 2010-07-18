package org.nuxeo.ide.manifests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.jar.Manifest;

public class ManifestFormater {

	protected void configureWriter(ManifestWriter writer) {
		DirectiveTransformer root = DirectiveTransformer.logger();
		root.link(DirectiveTransformer.nameVeto("Tool")).
			link(DirectiveTransformer.nameVeto("Bnd-LastModified")).
			link(DirectiveTransformer.exportPackagesVersionEraser("1.6.2.SNAPSHOT")).
			link(DirectiveTransformer.exportPackagesVersionEraser("5.3.2.SNAPSHOT")).
			link(DirectiveTransformer.bundleVersionOverwriter("0.0.0.SNAPSHOT")).
			link(DirectiveTransformer.multiValuesPrettyPrinter());
		writer.setDirectiveTransformer(root);
	}

	public void format(File file) throws IOException {
		Manifest mf = new Manifest(new FileInputStream(file));
		format(mf, new FileOutputStream(file));
	}
	
	public void format(Manifest mf, OutputStream out) throws IOException {
		ManifestWriter writer = new ManifestWriter(out);
		configureWriter(writer);
		writer.write(mf);
	}

}
