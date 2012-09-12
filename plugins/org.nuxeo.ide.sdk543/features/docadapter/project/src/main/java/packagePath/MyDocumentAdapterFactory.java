${copyright}

package ${package};

import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.api.adapter.DocumentAdapterFactory;

/**
 * ${authorTag}
 */
public class ${className}Factory implements DocumentAdapterFactory {

    @Override
    public Object getAdapter(DocumentModel doc, Class<?> itf) {
        if (<#list schemas as schema>doc.hasSchema("${schema.id}")<#if schema_has_next> && </#if></#list>){
            return new ${className}(doc);
        }else{
            return null;
        }
    }
}
