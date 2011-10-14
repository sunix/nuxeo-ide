package org.nuxeo.ide.sdk.features.seam;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.nuxeo.ide.common.forms.Form;
import org.nuxeo.ide.sdk.features.FeatureTemplateContext;
import org.nuxeo.ide.sdk.ui.widgets.ServiceChooser;
import org.nuxeo.ide.sdk.ui.widgets.ServiceChooserWidget;

public class SeamServiceCreationWizardPage extends SeamComponentCreationWizardPage {

    public SeamServiceCreationWizardPage(String name) {
        super(name);
    }

    @Override
    public Form createForm() {
        Form newForm = super.createForm();
        newForm.addWidgetType(ServiceChooserWidget.class);
        return newForm;
    }
    
    @Override
    public void createControl(Composite parent) {
        super.createControl(parent);
        final Text componentChooser = (Text)form.getWidgetControl("component");
        final ServiceChooser serviceChooser = (ServiceChooser)form.getWidgetControl("service");
        serviceChooser.addValueChangedListener(new ServiceChooser.ValueChangedListener() {
            
            @Override
            public void valueChanged(ServiceChooser source, String oldValue,
                    String newValue) {
                String oldName = oldValue.substring(oldValue.lastIndexOf('.')+1);
                String newName = newValue.substring(newValue.lastIndexOf('.')+1);
                if (oldName.equals(componentChooser.getText())) {
                    componentChooser.setText(newName);
                }
            }
        });
    }
    
    @Override
    public void update(FeatureTemplateContext ctx) {
        super.update(ctx);
        String fqn = form.getWidgetValueAsString("service");
        String sn = fqn.substring(fqn.lastIndexOf('.')+1);
        ctx.put("service_fqn", fqn);
        ctx.put("service_sn", sn);
    }
}
