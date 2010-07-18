package org.nuxeo.ide.archetype.ui.providers;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

public class ArchetypeLabelProvider extends LabelProvider implements ITableLabelProvider {
    public String getColumnText(Object obj, int index) {
         if (obj instanceof IArchetypeFileEntry) {
             return ((IArchetypeFileEntry) obj).getTitle();
         }

        return getText(obj);
    }

    public Image getColumnImage(Object obj, int index) {
        // if (index == 0) {
        // return getImage(obj);
        // }
        return null;
    }

    public Image getImage(Object obj) {
        return PlatformUI.getWorkbench().getSharedImages().getImage(
                ISharedImages.IMG_OBJ_ELEMENT);
    }

}