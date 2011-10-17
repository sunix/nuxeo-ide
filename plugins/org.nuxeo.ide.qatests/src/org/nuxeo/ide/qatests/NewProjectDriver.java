package org.nuxeo.ide.qatests;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;

public class NewProjectDriver {

    protected SWTWorkbenchBot bot;

    public void newProject(String name) {
        bot.menu("File").click();
    }
}
