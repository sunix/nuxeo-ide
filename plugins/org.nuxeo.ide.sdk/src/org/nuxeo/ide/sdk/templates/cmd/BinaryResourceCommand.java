package org.nuxeo.ide.sdk.templates.cmd;

import java.io.File;

import org.nuxeo.ide.sdk.templates.TemplateContext;
import org.osgi.framework.Bundle;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class BinaryResourceCommand implements Command {

    protected SourceCommand sourceCommand = new SourceCommand();
    protected final RenameCommand renameCommand = new RenameCommand();
    
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
    
        Element rename = doc.createElement("rename");
        rename.setAttribute("path", src + "/" + path);
        rename.setAttribute("to", src + "/" + to);
        renameCommand.init(rename);
    }

    @Override
    public void execute(TemplateContext ctx, Bundle bundle, File projectDir)
            throws Exception {
        sourceCommand.execute(ctx, bundle, projectDir);
        renameCommand.execute(ctx, bundle, projectDir);
    }

}
