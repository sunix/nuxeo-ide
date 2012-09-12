${copyright}

package ${package};

import java.util.Calendar;
import java.util.List;
import java.io.Serializable;

import org.nuxeo.ecm.core.api.ClientException;
import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.api.Blob;
import org.nuxeo.ecm.core.api.model.PropertyException;

/**
 * ${authorTag}
 */
public class ${className} {

    protected final DocumentModel doc;

    public ${className}(DocumentModel doc) {
        this.doc = doc;
    }

    public void save(CoreSession session) throws ClientException {
        session.saveDocument(doc);
    }

    public String getId() {
        return doc.getId();
    }

    <#list fields as field>
    public ${field.type} ${field.getter}() throws PropertyException, ClientException {
        return (${field.type})doc.getPropertyValue("${field.path}");
    }

    public void ${field.setter}(${field.type} value) throws PropertyException, ClientException {
        doc.setPropertyValue("${field.path}", ${field.cast("value")});
    }

    </#list>    
}
