package org.nuxeo.ide.qatests.widgets;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.waits.ICondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotButton;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTable;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.nuxeo.ide.qatests.dialogs.DialogBot;

public class ServiceChooserBot extends DialogBot {

    protected SWTBotText filter;

    protected SWTBotTable services;

    protected SWTBotButton ok;

    public ServiceChooserBot(SWTWorkbenchBot workbench) {
        super(workbench, "Service Selection");
    }

    @Override
    protected void handleActivation() {
        filter = workbench.text();
        services = workbench.table();
        ok = workbench.button("OK");
    }

    public void selectByName(final String name) {
        filter.setFocus();
        filter.typeText(name);
        workbench.waitWhile(new ICondition() {

            @Override
            public boolean test() throws Exception {
                return services.rowCount() != 1;
            }

            @Override
            public void init(SWTBot bot) {
                ;
            }

            @Override
            public String getFailureMessage() {
                if (services.rowCount() > 1) {
                    return "Too much services selected (" + services.rowCount()
                            + ") for " + name;
                }
                return "No matching service selected for " + name;
            }

        });
        services.setFocus();
        services.select(0);
        ok.setFocus();
        ok.click();
    }
}
