${copyright}

package ${package};

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.nuxeo.ecm.core.rest.DocumentRoot;
import org.nuxeo.ecm.webengine.model.Access;
import org.nuxeo.ecm.webengine.model.WebObject;
import org.nuxeo.ecm.webengine.model.exceptions.WebResourceNotFoundException;
import org.nuxeo.ecm.webengine.model.exceptions.WebSecurityException;
import org.nuxeo.ecm.webengine.model.impl.ModuleRoot;


${classHeader}
@Path("${rootPath}")
@Produces("text/html;charset=UTF-8")
@WebObject(type="${className}")
public class ${className} extends ModuleRoot {

    @GET
    public Object doGet() {
        return getView("index");
    }

}
