${copyright}

package ${package};

import java.io.Serializable;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.Unwrap;
import org.nuxeo.runtime.api.Framework;

import ${service_fqn};

/**
 *
 * This is a simple service wrapper that allow to inject a Nuxeo Runtime service as a Seam component
 *
 */
@Name("${bean?uncap_first}")
@Scope(ScopeType.EVENT)
public class ${class} implements Serializable {

    private static final long serialVersionUID = 1L;

    protected ${service_sn} ${service_sn?uncap_first};

    @Unwrap
    public ${service_sn} getService() throws Exception {
        if (${service_sn?uncap_first} == null) {
            ${service_sn?uncap_first} = Framework.getService(${service_sn}.class);
        }
        return ${service_sn?uncap_first};
    }

}
