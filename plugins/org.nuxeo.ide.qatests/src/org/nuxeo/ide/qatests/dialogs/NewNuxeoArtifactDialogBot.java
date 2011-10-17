package org.nuxeo.ide.qatests.dialogs;

import java.util.HashMap;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotButton;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.nuxeo.ide.qatests.wizards.SeamServiceCreationWizardBot;

public class NewNuxeoArtifactDialogBot extends DialogBot {

    protected SWTBotText text;

    protected SWTBotTree tree;

    protected SWTBotButton cancel;

    protected SWTBotButton next;

    @Override
    protected void handleActivation() {
        text = workbench.text();
        tree = workbench.tree();
        cancel = workbench.button("Cancel");
        next = workbench.button("Next >");
    }

    public NewNuxeoArtifactDialogBot(SWTWorkbenchBot workbench) {
        super(workbench, "New Nuxeo Artifact");
    }

    enum WizardOption {
        SeamService("Seam", "Service Bean", SeamServiceCreationWizardBot.class);

        protected final String category;

        protected final String name;

        protected final Class<? extends DialogBot> dialogClass;

        WizardOption(String category, String name,
                Class<? extends DialogBot> dialogClass) {
            this.category = category;
            this.name = name;
            this.dialogClass = dialogClass;
        }

    }

    static final HashMap<Class<? extends DialogBot>, WizardOption> options = new HashMap<Class<? extends DialogBot>, WizardOption>();

    static {
        for (WizardOption option : WizardOption.values()) {
            options.put(option.dialogClass, option);
        }
    }

    static WizardOption getOption(
            Class<? extends SeamServiceCreationWizardBot> dialogClass) {
        return options.get(dialogClass);
    }

    public <T extends DialogBot> T enterWizard(Class<T> wizardClass) {

        WizardOption option = options.get(wizardClass);

        text.setFocus();
        text.typeText(option.name);
        tree.setFocus();
        SWTBotTreeItem category = tree.getTreeItem(option.category);
        category.expand();
        category.select(option.name);

        return DialogBot.asyncOpen(workbench, wizardClass,
                new DialogOperation<T>() {

                    @Override
                    public void run(T dialog) {
                        next.click();
                    }
                });
    }

}
