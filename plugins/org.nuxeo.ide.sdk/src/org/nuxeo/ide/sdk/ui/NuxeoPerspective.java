package org.nuxeo.ide.sdk.ui;

import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.progress.IProgressConstants;
import org.nuxeo.ide.sdk.projects.plugin.PluginProjectWizard;
import org.nuxeo.ide.sdk.projects.webengine.WebengineProjectWizard;
import org.nuxeo.ide.sdk.server.ui.ServerView;

public class NuxeoPerspective implements IPerspectiveFactory {

    public static final String ID = NuxeoPerspective.class.getName();

    @Override
    public void createInitialLayout(IPageLayout layout) {
        defineLayout(layout);
        defineJavaActions(layout);
        defineActions(layout);
    }

    protected void defineActions(IPageLayout layout) {
        layout.addPerspectiveShortcut(JavaUI.ID_PERSPECTIVE);

        layout.addShowViewShortcut("org.nuxeo.ide.sdk.server.ui.ServerView");

        layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.JavaProjectWizard");
        layout.addNewWizardShortcut(PluginProjectWizard.ID);
        layout.addNewWizardShortcut(WebengineProjectWizard.ID);
    }

    protected void defineJavaActions(IPageLayout layout) {
        // IDebugUIConstants.LAUNCH_ACTION_SET
        layout.addActionSet("org.eclipse.debug.ui.launchActionSet");
        layout.addActionSet(JavaUI.ID_ACTION_SET);
        layout.addActionSet(JavaUI.ID_ELEMENT_CREATION_ACTION_SET);
        layout.addActionSet(IPageLayout.ID_NAVIGATE_ACTION_SET);

        // views - java
        layout.addShowViewShortcut(JavaUI.ID_PACKAGES);
        layout.addShowViewShortcut(JavaUI.ID_TYPE_HIERARCHY);
        layout.addShowViewShortcut(JavaUI.ID_SOURCE_VIEW);
        layout.addShowViewShortcut(JavaUI.ID_JAVADOC_VIEW);

        // views - search
        // NewSearchUI.SEARCH_VIEW_ID
        layout.addShowViewShortcut("org.eclipse.search.ui.views.SearchView");

        // views - debugging
        // IConsoleConstants.ID_CONSOLE_VIEW
        layout.addShowViewShortcut("org.eclipse.ui.console.ConsoleView");

        // views - standard workbench
        layout.addShowViewShortcut(IPageLayout.ID_OUTLINE);
        layout.addShowViewShortcut(IPageLayout.ID_PROBLEM_VIEW);
        layout.addShowViewShortcut(IPageLayout.ID_RES_NAV);
        layout.addShowViewShortcut(IPageLayout.ID_TASK_LIST);
        layout.addShowViewShortcut(IProgressConstants.PROGRESS_VIEW_ID);
        layout.addShowViewShortcut(IPageLayout.ID_PROJECT_EXPLORER);
        // TemplatesView.ID
        layout.addShowViewShortcut("org.eclipse.ui.texteditor.TemplatesView");
        layout.addShowViewShortcut("org.eclipse.pde.runtime.LogView"); //$NON-NLS-1$

        // new actions - Java project creation wizard
        layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.JavaProjectWizard"); //$NON-NLS-1$
        layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewPackageCreationWizard"); //$NON-NLS-1$
        layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewClassCreationWizard"); //$NON-NLS-1$
        layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewInterfaceCreationWizard"); //$NON-NLS-1$
        layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewEnumCreationWizard"); //$NON-NLS-1$
        layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewAnnotationCreationWizard"); //$NON-NLS-1$
        layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewSourceFolderCreationWizard"); //$NON-NLS-1$
        layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewSnippetFileCreationWizard"); //$NON-NLS-1$
        layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewJavaWorkingSetWizard"); //$NON-NLS-1$
        layout.addNewWizardShortcut("org.eclipse.ui.wizards.new.folder");//$NON-NLS-1$
        layout.addNewWizardShortcut("org.eclipse.ui.wizards.new.file");//$NON-NLS-1$
        layout.addNewWizardShortcut("org.eclipse.ui.editors.wizards.UntitledTextFileWizard");//$NON-NLS-1$

        // 'Window' > 'Open Perspective' contributions
        layout.addPerspectiveShortcut(JavaUI.ID_BROWSING_PERSPECTIVE);
        // IDebugUIConstants.ID_DEBUG_PERSPECTIVE
        layout.addPerspectiveShortcut("org.eclipse.debug.ui.DebugPerspective");

    }

    protected void defineLayout(IPageLayout layout) {
        // Editors are placed for free.
        String editorArea = layout.getEditorArea();

        // Place project explorer and outline to left of editor area.
        IFolderLayout left = layout.createFolder("left", IPageLayout.LEFT,
                (float) 0.26, editorArea);
        left.addView(IPageLayout.ID_PROJECT_EXPLORER);
        left.addPlaceholder(JavaUI.ID_PACKAGES_VIEW);
        left.addPlaceholder(JavaUI.ID_TYPE_HIERARCHY);
        left.addView(IPageLayout.ID_OUTLINE);

        IFolderLayout bottom = layout.createFolder("bottom",
                IPageLayout.BOTTOM, (float) 0.75, editorArea);
        // first the Java perspective defaults
        bottom.addView(IPageLayout.ID_PROBLEM_VIEW);
        bottom.addView(JavaUI.ID_JAVADOC_VIEW);
        bottom.addView(JavaUI.ID_SOURCE_VIEW);
        // NewSearchUI.SEARCH_VIEW_ID
        bottom.addPlaceholder("org.eclipse.search.ui.views.SearchView");
        // IConsoleConstants.ID_CONSOLE_VIEW
        bottom.addPlaceholder("org.eclipse.ui.console.ConsoleView");
        bottom.addPlaceholder(IPageLayout.ID_BOOKMARKS);
        bottom.addPlaceholder(IProgressConstants.PROGRESS_VIEW_ID);

        bottom.addView(ServerView.ID);

    }

}
