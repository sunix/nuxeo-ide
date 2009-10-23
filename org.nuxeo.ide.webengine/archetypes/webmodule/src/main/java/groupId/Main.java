package ${package};

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.nuxeo.ecm.webengine.model.WebObject;
import org.nuxeo.ecm.webengine.model.impl.ModuleRoot;

@WebObject(type="${moduleId}")
@Produces("text/html; charset=UTF-8")
public class Main extends ModuleRoot {

  /**
   * Default view
   */
  @GET
  public Object doGet() {
    return getView("index");
  }

  /**
   * Return the template index1.ftl from 'skin' directory
   */
  @GET
  @Path("index1")
  public Object getIndex1() {
    return getTemplate("index1.ftl");
  }

}

