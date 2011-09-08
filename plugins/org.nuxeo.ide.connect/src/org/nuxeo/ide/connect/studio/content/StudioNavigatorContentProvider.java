package org.nuxeo.ide.connect.studio.content;

import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.IPipelinedTreeContentProvider;
import org.eclipse.ui.navigator.PipelinedShapeModification;
import org.eclipse.ui.navigator.PipelinedViewerUpdate;
import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.connect.ConnectPlugin;
import org.nuxeo.ide.connect.StudioProjectBinding;

public class StudioNavigatorContentProvider implements
        IPipelinedTreeContentProvider {

    @Override
    public void dispose() {
    }

    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }

    @Override
    public Object[] getElements(Object inputElement) {
        return getChildren(inputElement);
    }

    @Override
    public Object[] getChildren(Object parentElement) {
        try {
            if (parentElement instanceof StudioBindingElement) {
                return ((StudioBindingElement) parentElement).getStudioElements();
            }
        } catch (Exception e) {
        }
        return UI.EMPTY_OBJECTS;
    }

    @Override
    public Object getParent(Object element) {
        if (element instanceof StudioBindingElement) {
            return ((StudioBindingElement) element).getProject();
        } else if (element instanceof StudioProjectElement) {
            return ((StudioProjectElement) element).getParent();
        }
        return null;
    }

    @Override
    public boolean hasChildren(Object element) {
        if (element instanceof StudioBindingElement) {
            return true;
        } else if (element instanceof IProject) {
            try {
                StudioProjectBinding binding = ConnectPlugin.getStudioProvider().getBinding(
                        (IProject) element);
                if (binding != null) {
                    return true;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    /** pipeline API **/

    @SuppressWarnings("rawtypes")
    @Override
    public void getPipelinedChildren(Object aParent, Set theCurrentChildren) {
        getPipelinedElements(aParent, theCurrentChildren);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void getPipelinedElements(Object anInput, Set theCurrentElements) {
        if (anInput instanceof IProject) {
            IProject project = (IProject) anInput;
            StudioProjectBinding binding = ConnectPlugin.getStudioProvider().getBinding(
                    project);
            if (binding != null) {
                theCurrentElements.add(new StudioBindingElement(project,
                        binding));
            }
        }
    }

    @Override
    public Object getPipelinedParent(Object anObject, Object aSuggestedParent) {
        return aSuggestedParent;
    }

    @Override
    public void init(ICommonContentExtensionSite aConfig) {
    }

    @Override
    public void saveState(IMemento aMemento) {
    }

    @Override
    public void restoreState(IMemento aMemento) {
    }

    @Override
    public PipelinedShapeModification interceptAdd(
            PipelinedShapeModification anAddModification) {
        return null;
    }

    @Override
    public boolean interceptRefresh(
            PipelinedViewerUpdate aRefreshSynchronization) {
        return false;
    }

    @Override
    public PipelinedShapeModification interceptRemove(
            PipelinedShapeModification aRemoveModification) {
        return null;
    }

    @Override
    public boolean interceptUpdate(PipelinedViewerUpdate anUpdateSynchronization) {
        return false;
    }
}
