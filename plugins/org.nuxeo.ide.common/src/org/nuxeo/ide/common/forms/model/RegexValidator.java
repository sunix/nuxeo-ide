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

import java.util.regex.Pattern;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class RegexValidator extends AbstractValidator {

    protected Pattern pattern;

    public RegexValidator() {
    }

    public void setValue(String value) {
        pattern = Pattern.compile(value);
    }

    @Override
    public String getValue() {
        return pattern == null ? null : pattern.toString();
    }

    @Override
    public boolean validate(Object value) {
        if (pattern == null) {
            return true;
        }
        if (value == null) {
            return false;
        }
        return pattern.matcher(value.toString()).matches();
    }

}
