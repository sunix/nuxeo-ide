package org.nuxeo.ide.qatests.usecases;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nuxeo.ide.qatests.dialogs.DialogOperation;
import org.nuxeo.ide.qatests.dialogs.NewNuxeoArtifactDialogBot;
import org.nuxeo.ide.qatests.dialogs.NuxeoPreferencesBot;
import org.nuxeo.ide.qatests.wizards.SDKPreferenceBot;
import org.nuxeo.ide.qatests.wizards.SeamServiceCreationWizardBot;

@RunWith(SWTBotJunit4ClassRunner.class)
public class CreateSeamServiceWrapperUseCase {

    public static class OpenNewNuxeoArtifact implements DialogOperation<NewNuxeoArtifactDialogBot> {

        @Override
        public void run(NewNuxeoArtifactDialogBot dialog) {
            dialog.workbench.menu("Nuxeo").menu("Nuxeo Artifact").click();
        }
        
    }
    
    public class OpenNuxeoPreferences implements DialogOperation<NuxeoPreferencesBot> {

        @Override
        public void run(NuxeoPreferencesBot dialog) {
            dialog.workbench.menu("Window").menu("Preferences").click();
        }
        
    }
        
    SWTWorkbenchBot workbench = new SWTWorkbenchBot();
 
    @Before public void configureSDK() throws IOException {
//        NuxeoPreferencesBot preferences = NuxeoPreferencesBot.asyncOpen(workbench, NuxeoPreferencesBot.class, new OpenNuxeoPreferences());
//        SDKPreferenceBot sdk = preferences.select(SDKPreferenceBot.class);
//        File home = new File("/home/matic/Workspaces/support/nuxeo-5.4/nuxeo-distribution/nuxeo-distribution-tomcat/target/nuxeo-dm-5.4.3-SNAPSHOT-tomcat");
//        sdk.addAndSelect(home);
//        preferences.finish();
    }
    
    @Before public void configureProject() {
        
    }
    
    @Test public void run() {
        
//        assertNotNull(workbench.activeShell());
//
//        NewNuxeoArtifactDialogBot dialog = NewNuxeoArtifactDialogBot.asyncOpen(workbench, NewNuxeoArtifactDialogBot.class, new OpenNewNuxeoArtifact()); 
//            
//        SeamServiceCreationWizardBot wizard = dialog.enterWizard(SeamServiceCreationWizardBot.class);
//               
//        wizard.fillAndFinish("Test", "org.nuxeo.sample", "TypeManager");
//        
//        boolean ok = true;
    }

}
