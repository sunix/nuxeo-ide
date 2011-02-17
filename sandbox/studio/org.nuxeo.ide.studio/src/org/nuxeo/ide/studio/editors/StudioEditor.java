package org.nuxeo.ide.studio.editors;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.nuxeo.ide.studio.data.Node;


public class StudioEditor extends EditorPart {

    public static final String ID = "org.nuxeo.ide.studio.editor";

    protected Browser browser;

    public StudioEditor() {
    }

    @Override
    public void doSave(IProgressMonitor monitor) {

    }

    @Override
    public void doSaveAs() {

    }

    @Override
    public void init(IEditorSite site, IEditorInput input)
            throws PartInitException {
        setSite(site);
        setInput(input);
    }

    @Override
    public boolean isDirty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isSaveAsAllowed() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void createPartControl(Composite parent) {
        parent.setLayout(new FillLayout());
        browser = new Browser(parent, SWT.NONE);
        Node node = (Node) getEditorInput().getAdapter(Node.class);
        browser.setUrl(node.getUrl());
    }

    @Override
    public void setFocus() {

    }

    @Override
    public String getPartName() {
        return getEditorInput().getName();
    }

    public Browser getBrowser() {
        return browser;
    }

}
