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
package org.nuxeo.ide.sdk.server.ui.widgets;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.swt.custom.StyleRange;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public abstract class RegexStyleFactory implements StyleFactory {

    private Pattern pattern;

    public RegexStyleFactory(String pattern) {
        this.pattern = Pattern.compile(pattern);
    }

    public RegexStyleFactory(Pattern pattern) {
        this.pattern = pattern;
    }

    @Override
    public StyleRange getStyle(String string) {
        Matcher m = pattern.matcher(string);
        if (m.find()) {
            return getStyle(m.start(), m.group().length());
        }
        return null;
    }

    protected StyleRange getStyle(int start, int length) {
        StyleRange style = new StyleRange();
        style.data = this;
        style.start = start;
        style.length = length;
        applyStyle(style);
        return style;
    }

    protected abstract void applyStyle(StyleRange range);

}
