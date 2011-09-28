${copyright}

package ${package};

import java.io.Serializable;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.Unwrap;
import org.nuxeo.ecm.core.api.ClientException;

/**
 *
 * This is a simple service wrapper that allow to inject a Nuxeo Runtime service as a Seam component
 *
 */
@Name("${bean}")
@Scope(ScopeType.EVENT)
public class ${class} implements Serializable {

    private static final long serialVersionUID = 1L;

    protected Object myService = null;

    @Unwrap
    public Object getMyService() throws ClientException {
        if (myService == null) {
            //myService = Framework.getService(serviceClass)
        }
        return myService;
    }

}
