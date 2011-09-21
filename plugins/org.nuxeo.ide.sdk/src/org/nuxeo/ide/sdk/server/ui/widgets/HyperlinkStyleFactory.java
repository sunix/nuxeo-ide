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

import java.util.regex.Pattern;

import org.eclipse.jface.resource.JFaceColors;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.widgets.Display;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public abstract class HyperlinkStyleFactory extends RegexStyleFactory implements
        HyperlinkHandler {

    public HyperlinkStyleFactory(String pattern) {
        super(pattern);
    }

    public HyperlinkStyleFactory(Pattern pattern) {
        super(pattern);
    }

    @Override
    protected void applyStyle(StyleRange style) {
        style.underline = true;
        // do not use UNDERLINE_LINK otherwise the styles will be recomputed
        // at mouse move even if the mouse is not positioned over a link
        // use instead a blue color to create the link
        // style.underlineStyle = SWT.UNDERLINE_LINK;
        style.foreground = JFaceColors.getHyperlinkText(Display.getCurrent());
    }

}
