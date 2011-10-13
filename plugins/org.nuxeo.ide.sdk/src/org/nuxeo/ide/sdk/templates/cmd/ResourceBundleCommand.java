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
        String from = element.getAttribute("from").trim();
        String to = element.getAttribute("to").trim();
        String src = element.getAttribute("src").trim();
        String name = element.getAttribute("name").trim();
        String locale = element.getAttribute("locale").trim();
        

        if (src.isEmpty()) {
            src = "src/main/resources";
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
        
        Element transformElememt = doc.createElement("transform");
        transformElememt.setAttribute("path", src + "/OSGI-INF/l10n/" + from + "-"  + name + locale + ".properties");
        transformElememt.setAttribute("to", src + "/OSGI-INF/l10n/"+ to + "-" + name + locale + ".properties");
        append.init(transformElememt);
    }

    @Override
    public void execute(TemplateContext ctx, Bundle bundle, File projectDir)
            throws Exception {
        resourcePath.execute(ctx, bundle, projectDir);
        append.execute(ctx, bundle, projectDir);
    }

}
