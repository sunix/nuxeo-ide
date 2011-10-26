${copyright}

package ${package};

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * The root entry for the JAX-RS module. 
 * ${authorTag}
 */
@Path("${rootPath}")
@Produces("text/html;charset=UTF-8")
public class ${className} {

    @GET
    public Object doGet() {
        return "Hello World!";
    }

}
