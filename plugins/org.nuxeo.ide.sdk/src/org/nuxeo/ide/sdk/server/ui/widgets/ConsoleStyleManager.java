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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.swt.custom.LineStyleEvent;
import org.eclipse.swt.custom.LineStyleListener;
import org.eclipse.swt.custom.StyleRange;

/**
 * Doesn't support nested styles. A style is containing a given offset if it is
 * the style with the closer start from that offset (start <= offset) and its
 * length contains the offset.
 * 
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class ConsoleStyleManager implements LineStyleListener {

    protected TreeMap<Integer, StyleRange> styles;

    protected List<StyleFactory> factories;

    protected ConsoleText console;

    public ConsoleStyleManager(ConsoleText console) {
        styles = new TreeMap<Integer, StyleRange>();
        factories = new ArrayList<StyleFactory>();
        this.console = console;
    }

    /**
     * Flush cache
     */
    public void reset() {
        styles = new TreeMap<Integer, StyleRange>();
    }

    public void dispose() {
        styles = null;
        factories = null;
        console = null;
    }

    public void addStyleFactory(StyleFactory factory) {
        factories.add(factory);
    }

    public void removeStyleFactory(StyleFactory factory) {
        factories.remove(factory);
    }

    public StyleRange[] getStyles() {
        return styles.values().toArray(new StyleRange[styles.size()]);
    }

    public StyleRange getStyleAtOffset(int offset) {
        Map.Entry<Integer, StyleRange> entry = styles.floorEntry(offset);
        if (entry != null) {
            StyleRange style = entry.getValue();
            if (style.start + style.length > offset) {
                return style;
            }
        }
        return null;
    }

    @Override
    public void lineGetStyle(LineStyleEvent event) {
        if (event.lineText.length() == 0) {
            return;
        }
        // TODO styles are computed each time the user scroll the styled text
        // System.out.println("compute styles: " + event.lineText);
        // compute styles
        ArrayList<StyleRange> result = null;
        for (StyleFactory factory : factories) {
            StyleRange style = factory.getStyle(event.lineText);
            if (style != null) {
                style.start += event.lineOffset;
                if (result == null) {
                    result = new ArrayList<StyleRange>();
                }
                result.add(style);
                this.styles.put(style.start, style);
            }
        }
        if (result != null) {
            event.styles = result.toArray(new StyleRange[result.size()]);
        }
    }
}
