package org.nuxeo.ide.sdk.templates.cmd;

import java.io.File;

import org.nuxeo.ide.sdk.templates.TemplateContext;
import org.osgi.framework.Bundle;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ResourceBundleCommand implements Command {

    protected ResourcePathCommand resourcePath =
            new ResourcePathCommand();
    
    protected AppendCommand append =
            new AppendCommand();
    
    @Override
    public void init(Element element) {
        Document doc = element.getOwnerDocument();
        String src = element.getAttribute("src").trim();
        String name = element.getAttribute("name").trim();
        String locale = element.getAttribute("locale").trim();
        String path = element.getAttribute("path").trim();
        
        if (src.isEmpty()) {
            src = "src/main/i18n";
        }
        
        if (name.isEmpty()) {
            name = "messages";
        }

        if (!locale.isEmpty()) {
            locale = "_" + locale;
        }
        
        Element sourceElement = doc.createElement("resourcePath");
        sourceElement.setAttribute("path", src);
        resourcePath.init(sourceElement);
        
        Element appendElement = doc.createElement("append");
        appendElement.setAttribute("path", src + "/" + path);
        appendElement.setAttribute("to", src + "/web/nuxeo.war/WEB-INF/classes/"+name+locale+".properties");
        append.init(appendElement);
    }

    @Override
    public void execute(TemplateContext ctx, Bundle bundle, File projectDir)
            throws Exception {
        resourcePath.execute(ctx, bundle, projectDir);
        append.execute(ctx, bundle, projectDir);
    }

}
