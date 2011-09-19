${copyright}

package ${package}.test;

import org.nuxeo.ecm.core.security.TestSecurityPolicyService;

${classHeader}
public class Test${className} extends TestSecurityPolicyService {


    @Override
    public void setUp() throws Exception {
        super.setUp();
        deployContrib("${project}", "OSGI-INF/extensions/${package}.${className}.xml");
    }

    public void test${className}Contrib() throws Exception {
        
    }

}
