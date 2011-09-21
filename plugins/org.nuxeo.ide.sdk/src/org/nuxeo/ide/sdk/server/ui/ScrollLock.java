package org.nuxeo.ide.sdk.server.ui;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;

public class ScrollLock implements IViewActionDelegate {

    protected IServerView view;

    @Override
    public void run(IAction action) {
        if (view != null) {
            view.setScrollLock(!view.getScrollLock());
        }
    }

    @Override
    public void selectionChanged(IAction action, ISelection selection) {
    }

    @Override
    public void init(IViewPart view) {
        this.view = (IServerView) view;
    }

}
