package org.nuxeo.ide.connect.studio.content;

import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;
import org.nuxeo.ide.connect.ConnectPlugin;
import org.nuxeo.ide.connect.StudioProjectBinding;
import org.nuxeo.ide.connect.studio.StudioProject;

public class StudioNavigatorLabelProvider extends BaseLabelProvider implements
        ICommonLabelProvider {

    @Override
    public Image getImage(Object element) {
        return ConnectPlugin.getDefault().getImageRegistry().get(
                "icons/studio_project.gif");
    }

    @Override
    public String getText(Object element) {
        if (element instanceof StudioProject) {
            return ((StudioProject) element).getName();
        } else if (element instanceof StudioProjectBinding) {
            return "Studio Projects";
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
