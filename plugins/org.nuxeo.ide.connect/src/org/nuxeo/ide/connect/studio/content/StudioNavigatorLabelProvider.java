package org.nuxeo.ide.connect.studio.content;

import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

public class StudioNavigatorLabelProvider extends BaseLabelProvider implements
        ICommonLabelProvider {

    @Override
    public Image getImage(Object element) {
        if (element instanceof StudioProjectElement) {
            return ((StudioProjectElement) element).getImage();
        } else if (element instanceof StudioBindingElement) {
            return ((StudioBindingElement) element).getImage();
        }
        return null;
    }

    @Override
    public String getText(Object element) {
        if (element instanceof StudioProjectElement) {
            return ((StudioProjectElement) element).getName();
        } else if (element instanceof StudioBindingElement) {
            return ((StudioBindingElement) element).getName();
        }
        return element.toString();
    }

    @Override
    public void restoreState(IMemento aMemento) {
    }

    @Override
    public void saveState(IMemento aMemento) {
    }

    @Override
    public String getDescription(Object anElement) {
        return null;
    }

    @Override
    public void init(ICommonContentExtensionSite aConfig) {
    }

}
