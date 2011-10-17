package org.nuxeo.ide.qatests.wizards;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.nuxeo.ide.qatests.dialogs.DialogBot;

public class PluginProjectWizardBot extends DialogBot {

    protected SWTBotText projectId;
    
    public PluginProjectWizardBot(SWTWorkbenchBot workbench) {
        super(workbench, "New Nuxeo Artifact");
    }

    @Override
    protected void handleActivation() {
       workbench.text();
    }
}
