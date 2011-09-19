${copyright}

package ${package};

import java.security.Principal;

import org.nuxeo.ecm.core.api.security.ACP;
import org.nuxeo.ecm.core.api.security.Access;
import org.nuxeo.ecm.core.model.Document;
import org.nuxeo.ecm.core.security.AbstractSecurityPolicy;

${classHeader}
public class ${className}  extends AbstractSecurityPolicy {

    public Access checkPermission(Document doc, ACP mergedAcp,
            Principal principal, String permission,
            String[] resolvedPermissions, String[] additionalPrincipals)
            throws SecurityException {
        //
        return Access.UNKNOWN;
    }

}
