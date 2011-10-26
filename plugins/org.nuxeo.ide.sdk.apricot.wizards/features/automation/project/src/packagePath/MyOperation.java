${copyright}

package ${package};

import org.eclipse.ecr.automation.core.Constants;
import org.eclipse.ecr.automation.core.annotations.Context;
import org.eclipse.ecr.automation.core.annotations.Operation;
import org.eclipse.ecr.automation.core.annotations.OperationMethod;
import org.eclipse.ecr.automation.core.annotations.Param;
import org.eclipse.ecr.automation.core.collectors.DocumentModelCollector;
import org.eclipse.ecr.automation.core.collectors.BlobCollector;
import org.eclipse.ecr.core.api.CoreSession;
import org.eclipse.ecr.core.api.DocumentModel;
import org.eclipse.ecr.core.api.DocumentRef;

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
