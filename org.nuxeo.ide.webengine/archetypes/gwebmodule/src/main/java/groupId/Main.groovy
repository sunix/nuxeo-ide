package ${package};

import java.io.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import org.nuxeo.ecm.core.rest.*;
import org.nuxeo.ecm.webengine.model.*;
import org.nuxeo.ecm.webengine.model.impl.*;
import org.nuxeo.ecm.webengine.model.exceptions.*;
import org.nuxeo.ecm.webengine.*;

@WebObject(type="${moduleId}")
@Produces(["text/html; charset=UTF-8"])
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

