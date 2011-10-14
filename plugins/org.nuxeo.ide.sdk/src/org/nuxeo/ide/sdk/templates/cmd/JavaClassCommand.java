package org.nuxeo.ide.sdk.templates.cmd;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.nuxeo.ide.sdk.templates.TemplateContext;
import org.osgi.framework.Bundle;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class JavaClassCommand implements Command, PostCreateCommand {

    protected SourcePathCommand sourcePathCommand = new SourcePathCommand();
    protected final TransformCommand transformCommand = new TransformCommand();
    protected final OrganizeImportsCommand organizeImportsCommand = new OrganizeImportsCommand();
    
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
        
        Element organize = doc.createElement("organizeImports");
        Element organizeClass = doc.createElement("class");
        organizeClass.setAttribute("path", src + "/" + path);
        organize.appendChild(organizeClass);
        organizeImportsCommand.init(organize);
    }

    @Override
    public void execute(TemplateContext ctx, Bundle bundle, File projectDir)
            throws Exception {
        sourcePathCommand.execute(ctx, bundle, projectDir);
        transformCommand.execute(ctx, bundle, projectDir);
    }

    @Override
    public void execute(IProject project, TemplateContext ctx) throws Exception {
        organizeImportsCommand.execute(project, ctx);
    }

}
