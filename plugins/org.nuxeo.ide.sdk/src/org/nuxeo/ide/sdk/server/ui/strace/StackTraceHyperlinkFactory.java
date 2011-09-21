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
package org.nuxeo.ide.sdk.server.ui.strace;

import org.eclipse.swt.custom.StyleRange;
import org.nuxeo.ide.sdk.server.ui.widgets.ConsoleText;
import org.nuxeo.ide.sdk.server.ui.widgets.HyperlinkStyleFactory;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class StackTraceHyperlinkFactory extends HyperlinkStyleFactory {

    public StackTraceHyperlinkFactory() {
        super("\\([A-Za-z0-9_\\$]+\\.java:[0-9]+\\)");
    }

    @Override
    public void onClick(ConsoleText console, StyleRange style, String text) {
        // compute the complete type name
        int lineIndex = console.getLineAtOffset(style.start);
        String line = console.getLine(lineIndex).trim();
        int lineOffset = console.getOffsetAtLine(lineIndex);
        int i = line.substring(0, style.start - lineOffset).lastIndexOf(' ');
        if (i == -1) {
            i = 0;
        }
        new StackTraceHyperLink(line.substring(i + 1)).onClick();
    }

}
