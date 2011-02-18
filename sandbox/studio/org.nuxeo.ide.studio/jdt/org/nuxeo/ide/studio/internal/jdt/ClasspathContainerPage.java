package org.nuxeo.ide.studio.internal.jdt;

import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.ui.wizards.IClasspathContainerPage;
import org.eclipse.jdt.ui.wizards.IClasspathContainerPageExtension;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.nuxeo.ide.studio.StudioContentProvider;
import org.nuxeo.ide.studio.StudioConstants;
import org.nuxeo.ide.studio.StudioPlugin;
import org.nuxeo.ide.studio.connector.internal.ContentExtractor;
import org.nuxeo.ide.studio.internal.preferences.PreferencesStore;

public class ClasspathContainerPage extends WizardPage implements
        IClasspathContainerPage, IClasspathContainerPageExtension {

    public ClasspathContainerPage() {
        super("Nuxeo Studio Dependencies");
        provider = StudioPlugin.getDefault().getProvider();
    }

    protected IClasspathEntry containerEntry;

    protected final StudioContentProvider provider;

    protected String selectedProject;

    @Override
    public void createControl(Composite parent) {
        setTitle("Manage Nuxeo Studio dependencies");
        setDescription("Select projects you want being referenced in the project classpath");

        Composite composite = new Composite(parent, SWT.NONE);
        composite.setLayout(new GridLayout());
        setControl(composite);

        final List projects = new List(composite, SWT.NONE);
        projects.setItems(new ContentExtractor(provider).extractProjectNames());
        projects.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
               String[] selection = projects.getSelection();
               if (selection.length != 1) {
                   selectedProject = null;
                   setPageComplete(false);
                   return;
               }
               selectedProject = selection[0];
               setPageComplete(true);
            }
        });
    }

    protected IJavaProject ctx;

    @Override
    public void initialize(IJavaProject project,
            IClasspathEntry[] currentEntries) {
        ctx = project;
    }

    @Override
    public boolean finish() {
        PreferencesStore prefs = new PreferencesStore();
        prefs.setStudioProject(ctx, selectedProject);
        Path path = new Path(StudioConstants.CLASSPATH_CONTAINER_ID);
        containerEntry = JavaCore.newContainerEntry(path);
        return true;
    }

    @Override
    public IClasspathEntry getSelection() {
        return containerEntry;
    }

    @Override
    public void setSelection(IClasspathEntry newEntry) {
        containerEntry = newEntry;
    }

}
