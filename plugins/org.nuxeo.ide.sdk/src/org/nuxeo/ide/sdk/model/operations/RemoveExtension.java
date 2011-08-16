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
package org.nuxeo.ide.sdk.model.operations;

import org.nuxeo.ide.sdk.model.ComponentModel;
import org.w3c.dom.Element;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public abstract class RemoveExtension implements ExtensionOperation {

    protected String target;

    protected String point;

    public RemoveExtension(String target, String point) {
        this.target = target;
        this.point = point;
    }

    @Override
    public void execute(ComponentModel model) {
        for (Element el : model.getExtensions(target, point)) {
            if (removeContribution(el)) {
                if (ComponentModel.isExtensionEmpty(el)) {
                    el.getParentNode().removeChild(el);
                }
            }
        }
    }

    /**
     * Remove the contribution if any.
     * 
     * @param xt
     * @return
     */
    protected abstract boolean removeContribution(Element xt);

}
