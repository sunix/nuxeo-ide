package ${package};

import org.nuxeo.ecm.core.api.ClientException;
import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.api.security.ACP;
import org.nuxeo.ecm.core.api.security.SecurityConstants;
import org.nuxeo.ecm.core.api.security.UserEntry;
import org.nuxeo.ecm.core.api.security.impl.UserEntryImpl;

public class SampleProjectServiceImpl {

    void setPrivateDocumentAcl(CoreSession coreSession, DocumentModel doc)
            throws ClientException {
        ACP acp = coreSession.getACP(doc.getRef());

        // creating ACEs
        // granting read and browse for admin
        UserEntry adminEntry = new UserEntryImpl(
                SampleProjectConstants.GRP_ADMIN);
        adminEntry.addPrivilege(SecurityConstants.READ, true, false);
        adminEntry.addPrivilege(SecurityConstants.BROWSE, true, false);

        // granting read and browse for members
        UserEntry membersEntry = new UserEntryImpl(
                SampleProjectConstants.GRP_MEMBERS);
        membersEntry.addPrivilege(SecurityConstants.READ, true, false);
        membersEntry.addPrivilege(SecurityConstants.BROWSE, true, false);

        // denying read and browse for web
        UserEntry webEntry = new UserEntryImpl(SampleProjectConstants.GRP_WEB);
        webEntry.addPrivilege(SecurityConstants.READ, false, false);
        webEntry.addPrivilege(SecurityConstants.BROWSE, false, false);

        acp.setRules(new UserEntry[] { adminEntry, membersEntry, webEntry });

        coreSession.setACP(doc.getRef(), acp, true);
        coreSession.save();
    }

}

