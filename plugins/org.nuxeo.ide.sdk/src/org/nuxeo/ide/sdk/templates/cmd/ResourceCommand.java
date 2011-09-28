package org.nuxeo.ide.sdk.templates.cmd;

import java.io.File;

import org.nuxeo.ide.sdk.templates.TemplateContext;
import org.osgi.framework.Bundle;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ResourceCommand implements Command {

    protected SourceCommand sourceCommand = new SourceCommand();
    protected final TransformCommand transformCommand = new TransformCommand();
    
    @Override
    public void init(Element element) {
        Document doc = element.getOwnerDocument();
        String src = element.getAttribute("src").trim();
        String path = element.getAttribute("path").trim();
        String to = element.getAttribute("to").trim();
        
        if (src.isEmpty()) {
            src = "src/main/resources";
        }
        
        Element source = doc.createElement("source");
        sourceCommand = new SourceCommand();
        source.setAttribute("path", src);
        sourceCommand.init(source);
    
        Element transform = doc.createElement("transform");
        transform.setAttribute("path", src + "/" + path);
        transform.setAttribute("to", src + "/" + to);
        transformCommand.init(transform);
    }

    @Override
    public void execute(TemplateContext ctx, Bundle bundle, File projectDir)
            throws Exception {
        sourceCommand.execute(ctx, bundle, projectDir);
        transformCommand.execute(ctx, bundle, projectDir);
    }

}
