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
package org.nuxeo.ide.common.forms;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public abstract class UIObject<T extends Control> {

    protected Form form;

    protected String id;

    protected T ctrl;

    /**
     * Create the control described by the given element as a child of the given
     * composite.
     * 
     * @param parent
     * @param element
     * @return
     */
    protected abstract T createControl(Composite parent, Element element,
            BindingContext ctx);

    /**
     * Get the underlying control.
     * 
     * @return
     */
    public T getControl() {
        return ctrl;
    }

    public boolean hasValue() {
        return this instanceof HasValue;
    }

    public void validate() {
    }

    public void setControl(T ctrl) {
        this.ctrl = ctrl;
        ctrl.setData(UIObject.class.getName(), this);
        if (this instanceof HasValue) {
            ctrl.addFocusListener(new FocusAdapter() {
                @Override
                public void focusLost(FocusEvent e) {
                    validate();
                }

                @Override
                public void focusGained(FocusEvent e) {
                    validate();
                }
            });
            ctrl.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    validate();
                }
            });
        }
    }

    public Form getForm() {
        return form;
    }

    public String getId() {
        return id;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    /**
     * Create the underlying control from the given XML element.
     * 
     * @param parent the parent control.
     * @param element the XML element.
     * @param layout the layout manager of the parent control.
     * @return
     */
    public T bind(Composite parent, Element element, BindingContext ctx) {
        this.id = getAttribute(element, "id");
        if (id != null) {
            ctx.getForm().getWidgets().put(id, this);
        }
        setForm(ctx.getForm());
        setControl(createControl(parent, element, ctx));
        boolean hasValue = (this instanceof HasValue);
        if (hasValue) {
            HasValue obj = (HasValue) this;
            String v = getAttribute(element, "value", null);
            if (v != null) {
                obj.setValue(v);
            }
            obj.setValidators(loadValidators(element));
        }
        if (this instanceof HasText) {
            boolean trim = getBooleanAttribute(element, "trim", true);
            ((HasText) this).setText(trim ? element.getTextContent().trim()
                    : element.getTextContent());
        }
        ctrl.setEnabled(getBooleanAttribute(element, "enabled", true));
        ctrl.setVisible(getBooleanAttribute(element, "visible", true));
        if (ctx.getLayout() != null) {
            ctx.getLayout().applyLayout(ctrl, element);
        }
        ctrl.setData("org.eclipse.swtbot.widget.key", id);
        return ctrl;
    }

    protected List<Validator> loadValidators(Element element) {
        ArrayList<Validator> validators = new ArrayList<Validator>();
        Node child = element.getFirstChild();
        while (child != null) {
            if (child.getNodeType() == Node.ELEMENT_NODE
                    && "validator".equals(child.getNodeName())) {
                Element el = (Element) child;
                String type = getAttribute(el, "type", null);
                if (type == null) {
                    throw new IllegalArgumentException(
                            "A validator element must have a type attribute");
                }
                String value = getAttribute(el, "value", null);
                String msg = el.getTextContent().trim();
                Validator v = form.getValidatorInstance(type);
                v.setValue(value);
                v.setMessage(msg);
                validators.add(v);
            }
            child = child.getNextSibling();
        }
        return validators;
    }

    public static String getAttribute(Element element, String key) {
        String v = element.getAttribute(key);
        return v.length() == 0 ? null : v;
    }

    public static String getAttribute(Element element, String key,
            String defValue) {
        String v = element.getAttribute(key);
        return v.length() == 0 ? defValue : v;
    }

    public static Integer getIntAttribute(Element element, String key) {
        String v = element.getAttribute(key);
        return v.length() == 0 ? null : Integer.valueOf(v);
    }

    public static Boolean getBooleanAttribute(Element element, String key) {
        String v = element.getAttribute(key);
        return v.length() == 0 ? null : Boolean.valueOf(v);
    }

    public static Integer getIntAttribute(Element element, String key,
            int defValue) {
        String v = element.getAttribute(key);
        return v.length() == 0 ? defValue : Integer.parseInt(v);
    }

    public static Boolean getBooleanAttribute(Element element, String key,
            boolean defValue) {
        String v = element.getAttribute(key);
        return v.length() == 0 ? defValue : Boolean.parseBoolean(v);
    }

}
