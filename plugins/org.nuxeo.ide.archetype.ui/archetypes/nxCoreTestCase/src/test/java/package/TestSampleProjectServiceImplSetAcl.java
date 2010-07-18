/*
 * (C) Copyright 2009 Nuxeo SA (http://nuxeo.com/) and contributors.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * Contributors:
 *     <a href=mailto:stan@nuxeo.com>Sun Seng David TAN</a>
 */
package ${package};

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.nuxeo.ecm.core.api.ClientException;
import org.nuxeo.ecm.core.api.CoreInstance;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.api.NuxeoPrincipal;
import org.nuxeo.ecm.core.api.PathRef;
import org.nuxeo.ecm.core.api.impl.UserPrincipal;
import org.nuxeo.ecm.core.api.security.SecurityConstants;
import org.nuxeo.ecm.core.storage.sql.SQLRepositoryTestCase;

public class TestSampleProjectServiceImplSetAcl extends
        SQLRepositoryTestCase {

    public static final Log log = LogFactory.getLog(TestSampleProjectServiceImplSetAcl.class);

    NuxeoPrincipal member_admin;

    NuxeoPrincipal member_members;

    NuxeoPrincipal member_web;

    NuxeoPrincipal member_web_and_admin;

    @Override
    public void setUp() throws Exception {
        super.setUp();

        // connecting as Administrator
        openSession();

        // Creating fake principals, we would be able to login with it after
        // having set the acls
        member_admin = new UserPrincipal("Member_admin",
                Arrays.asList(SampleProjectConstants.GRP_ADMIN));
        member_members = new UserPrincipal("Member_members",
                Arrays.asList(SampleProjectConstants.GRP_MEMBERS));
        member_web = new UserPrincipal("Member_web",
                Arrays.asList(SampleProjectConstants.GRP_WEB));

        // special case, the member is in 2 groups: admin and intranautes
        member_web_and_admin = new UserPrincipal("Member_web_and_admin",
                Arrays.asList(SampleProjectConstants.GRP_ADMIN,
                        SampleProjectConstants.GRP_WEB));

    }

    /**
     * openSession with a specific principal, logging and providing a session
     * object. This method has been created as we need to provide a principal
     * and its groups which is not possible with the default opensession method.
     * 
     * @param principal
     * @throws ClientException
     */
    private void openSessionAs(NuxeoPrincipal principal) throws ClientException {
        Map<String, Serializable> context = new HashMap<String, Serializable>();
        context.put("principal", principal);
        session = CoreInstance.getInstance().open(REPOSITORY_NAME, context);
    }

    public void testAcl() throws Exception {
        // create new document for testing
        DocumentModel doc = session.createDocumentModel("/",
                "docname_for_testing", "File");
        assertNotNull(doc);
        doc = session.createDocument(doc);
        assertNotNull(doc);

        // applying the acls using the real class:
        SampleProjectServiceImpl publishingServiceObject = new SampleProjectServiceImpl();
        publishingServiceObject.setPrivateDocumentAcl(session, doc);
        closeSession();

        // testing the result with several case:
        openSessionAs(member_admin);
        assertTrue(session.hasPermission(new PathRef("/docname_for_testing"),
                SecurityConstants.READ));
        assertTrue(session.hasPermission(new PathRef("/docname_for_testing"),
                SecurityConstants.BROWSE));
        closeSession();

        openSessionAs(member_members);
        assertTrue(session.hasPermission(new PathRef("/docname_for_testing"),
                SecurityConstants.READ));
        assertTrue(session.hasPermission(new PathRef("/docname_for_testing"),
                SecurityConstants.BROWSE));
        closeSession();

        openSessionAs(member_web);
        assertFalse(session.hasPermission(new PathRef("/docname_for_testing"),
                SecurityConstants.READ));
        assertFalse(session.hasPermission(new PathRef("/docname_for_testing"),
                SecurityConstants.BROWSE));
        closeSession();

        openSessionAs(member_web_and_admin);
        assertTrue(session.hasPermission(new PathRef("/docname_for_testing"),
                SecurityConstants.READ));
        assertTrue(session.hasPermission(new PathRef("/docname_for_testing"),
                SecurityConstants.BROWSE));
        closeSession();
    }

}
