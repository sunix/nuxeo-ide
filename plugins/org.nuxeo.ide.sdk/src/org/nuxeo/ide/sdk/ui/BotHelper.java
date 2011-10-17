package org.nuxeo.ide.sdk.ui;

import org.eclipse.swt.widgets.Widget;

public class BotHelper {
    
    public static final String WIDGET_KEY = "org.eclipse.swtbot.widget.key";
    
    public static final String WIDGET_OWNER = "org.eclipse.swtbot.widget.owner";

    public static void setOwner(Widget w, Object owner) {
        w.setData(WIDGET_KEY, owner.getClass().getName());
        w.setData(WIDGET_OWNER, owner);
    }

}
