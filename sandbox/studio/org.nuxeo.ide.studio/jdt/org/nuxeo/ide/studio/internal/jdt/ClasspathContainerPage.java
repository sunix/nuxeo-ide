package org.nuxeo.ide.studio.internal.jdt;

import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.ui.wizards.IClasspathContainerPage;
import org.eclipse.jdt.ui.wizards.IClasspathContainerPageExtension;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.nuxeo.ide.studio.NxStudioPlugin;
import org.nuxeo.ide.studio.dto.NxStudioWorkbenchBean;
import org.nuxeo.ide.studio.dto.NxStudioWorkbenchExtractor;

public class ClasspathContainerPage extends WizardPage implements
        IClasspathContainerPage, IClasspathContainerPageExtension {

    public ClasspathContainerPage() {
        super("Nuxeo Studio Dependencies");
    }

    protected IClasspathEntry containerEntry;

    protected String[] projects() {
        NxStudioWorkbenchBean wb = NxStudioPlugin.getDefault().getStudioWorkbench();
        return new NxStudioWorkbenchExtractor(wb).extractProjectNames();
    }
    
    @Override
    public void createControl(Composite parent) {
        setTitle("Manage Nuxeo Studio dependencies");
        setDescription("Select projects you want being referenced in the project classpath");

        Composite composite = new Composite(parent, SWT.NONE);
        composite.setLayout(new GridLayout());
        setControl(composite);

        List projects = new List(composite, SWT.NONE);
        projects.setItems(projects());
        projects.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
               // TODO configure something
               return;
            }
        });
    }

    protected IJavaProject java;

    @Override
    public void initialize(IJavaProject project,
            IClasspathEntry[] currentEntries) {
        java = project;
    }

    @Override
    public boolean finish() {
        
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
