${copyright}

package ${package};

import org.nuxeo.ecm.automation.core.Constants;
import org.nuxeo.ecm.automation.core.annotations.Context;
import org.nuxeo.ecm.automation.core.annotations.Operation;
import org.nuxeo.ecm.automation.core.annotations.OperationMethod;
import org.nuxeo.ecm.automation.core.annotations.Param;
import org.nuxeo.ecm.automation.core.collectors.DocumentModelCollector;
import org.nuxeo.ecm.automation.core.collectors.BlobCollector;
import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.api.DocumentRef;

/**
 * ${authorTag}
 */
@Operation(id=${className}.ID, category=Constants.${category}, <#if seam>requires=Constants.SEAM_CONTEXT, </#if>label="${label!operationId}", description="${description}")
public class ${className} {

    public static final String ID = "${operationId}";

    @OperationMethod<#if iterable>(collector=${outputCollector})</#if>
    public ${output!"void"} run(<#if input && input != "void">${input} input</#if>) {
      <#if output && output != "void">return null;</#if> 
    }    

}
