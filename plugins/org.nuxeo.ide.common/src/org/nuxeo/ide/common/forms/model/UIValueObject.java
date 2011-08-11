/*
 * (C) Copyright 2006-2010 Nuxeo SAS (http://nuxeo.com/) and contributors.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * Contributors:
 *     bstefanescu
 */
package org.nuxeo.ide.common.forms.model;

import java.util.List;

import org.eclipse.swt.widgets.Control;
import org.nuxeo.ide.common.forms.HasValue;
import org.nuxeo.ide.common.forms.UIObject;
import org.nuxeo.ide.common.forms.Validator;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public abstract class UIValueObject<T extends Control> extends UIObject<T>
        implements HasValue {

    protected List<Validator> validators;

    @Override
    public void setValidators(List<Validator> validators) {
        this.validators = validators;
    }

    @Override
    public List<Validator> getValidators() {
        return validators;
    }

    protected abstract void doSetValue(Object value);

    @Override
    public void setValue(Object value) {
        Object oldValue = getValue();
        doSetValue(value);
        if (oldValue == value) {
            return;
        }
        if (value != null) {
            if (!value.equals(oldValue)) {
                validate();
            }
        } else {
            validate();
        }
    }

    @Override
    public void validate() {
        HasValue obj = (HasValue) this;
        List<Validator> validators = obj.getValidators();
        if (validators == null || validators.isEmpty()) {
            return;
        }
        Object value = obj.getValue();
        String strvalue = obj.getValueAsString();
        for (Validator v : validators) {
            if (!v.validate(value, strvalue)) {
                form.addError(this, v.getMessage());
                return;
            }
        }
        form.removeError(this);
    }

}
