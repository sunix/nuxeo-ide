package org.nuxeo.ide.sdk.templates.cmd;

import java.io.File;

import org.nuxeo.ide.sdk.templates.TemplateContext;
import org.osgi.framework.Bundle;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class JavaClassCommand implements Command {

    protected SourcePathCommand sourcePathCommand = new SourcePathCommand();
    protected final TransformCommand transformCommand = new TransformCommand();
    
    @Override
    public void init(Element element) {
        Document doc = element.getOwnerDocument();
        String src = element.getAttribute("src").trim();
        String path = element.getAttribute("path").trim();
        String to = element.getAttribute("to").trim();
        
        if (src.isEmpty()) {
            src = "src/main/java";
        }
        
        Element sourcePath = doc.createElement("sourcePath");
        sourcePathCommand = new SourcePathCommand();
        sourcePath.setAttribute("path", src);
        sourcePathCommand.init(sourcePath);
    
        Element tranform = doc.createElement("rename");
        tranform.setAttribute("path", src + "/" + path);
        tranform.setAttribute("to", src + "/" + to);
        transformCommand.init(tranform);
    }

    @Override
    public void execute(TemplateContext ctx, Bundle bundle, File projectDir)
            throws Exception {
        sourcePathCommand.execute(ctx, bundle, projectDir);
        transformCommand.execute(ctx, bundle, projectDir);
    }

}
