package org.nuxeo.ide.sdk.deploy;

import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class SelectAllButton {

    public SelectAllButton(Composite layout,
            final CheckboxTableViewer tableViewer) {
        super();
        Button selectButton = new Button(layout, SWT.PUSH);
        // Select/Unselect All buttons
        selectButton.setLocation(50, 50);
        selectButton.setText("Select/Unselect All");
        selectButton.pack();
        selectButton.addSelectionListener(new SelectionListener() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                tableViewer.setAllChecked(tableViewer.getCheckedElements().length != 0 ? false
                        : true);
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
                widgetSelected(e);
            }
        });
    }

}
