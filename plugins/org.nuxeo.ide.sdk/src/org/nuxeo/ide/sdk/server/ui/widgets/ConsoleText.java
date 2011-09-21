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

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.console.ConsolePlugin;
import org.nuxeo.ide.sdk.server.ui.strace.ErrorHyperlinkFactory;
import org.nuxeo.ide.sdk.server.ui.strace.ExceptionHyperlinkFactory;
import org.nuxeo.ide.sdk.server.ui.strace.StackTraceHyperlinkFactory;

/**
 * A styled text that supports hyperlinks.
 * 
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class ConsoleText extends StyledText {

    protected ConsoleStyleManager mgr;

    protected Cursor handCursor;

    protected Cursor textCursor;

    protected StyleRange hyperlink;

    public ConsoleText(Composite parent, int style) {
        this(null, parent, style);
    }

    public ConsoleText(ConsoleStyleManager mgr, Composite parent, int style) {
        super(parent, style);
        this.mgr = mgr == null ? new ConsoleStyleManager(this) : mgr;
        addLineStyleListener(this.mgr);
        addListener(SWT.MouseDown, new Listener() {
            @Override
            public void handleEvent(Event event) {
                onHyperlinkClick(event);
            }
        });
        addMouseMoveListener(new MouseMoveListener() {
            @Override
            public void mouseMove(MouseEvent e) {
                onMouseMove(e);
            }
        });
    }

    public void installStackTraceSupport() {
        mgr.addStyleFactory(new ExceptionHyperlinkFactory());
        mgr.addStyleFactory(new ErrorHyperlinkFactory());
        mgr.addStyleFactory(new StackTraceHyperlinkFactory());
    }

    public void appendAndScroll(String text) {
        append(text);
        setSelection(getCharCount(), getCharCount());
    }

    @Override
    public void dispose() {
        hyperlink = null;
        if (handCursor != null) {
            handCursor.dispose();
            handCursor = null;
        }
        if (textCursor != null) {
            textCursor.dispose();
            textCursor = null;
        }
        mgr.dispose();
        mgr = null;
        super.dispose();
    }

    public void resetStyles() {
        mgr.reset();
    }

    public ConsoleStyleManager getStyleManager() {
        return mgr;
    }

    protected void onHyperlinkClick(Event event) {
        if (hyperlink != null) {
            String text = getText(hyperlink.start, hyperlink.start
                    + hyperlink.length - 1);
            ((HyperlinkHandler) hyperlink.data).onClick(this, hyperlink, text);
        }
    }

    protected void onMouseMove(MouseEvent event) {
        try {
            int offset = getOffsetAtLocation(new Point(event.x, event.y));
            StyleRange style = mgr.getStyleAtOffset(offset);
            if (style != null && (style.data instanceof HyperlinkHandler)) {
                onHyperlinkEnter(style);
            } else if (hyperlink != null) {
                onHyperlinkExit();
            }
        } catch (Throwable e) {
            if (hyperlink != null) {
                onHyperlinkExit();
            }
        }
    }

    protected void onHyperlinkEnter(StyleRange style) {
        if (hyperlink != null) {
            if (hyperlink.equals(style)) {
                return;
            }
            onHyperlinkExit();
        }
        this.hyperlink = style;
        setCursor(getHandCursor());
        // redraw();
    }

    protected void onHyperlinkExit() {
        // setCursor(getTextCursor());
        setCursor(null);
        this.hyperlink = null;
        // redraw();
    }

    /**
     * Returns the hand cursor.
     * 
     * @return the hand cursor
     */
    protected Cursor getHandCursor() {
        if (handCursor == null) {
            handCursor = new Cursor(ConsolePlugin.getStandardDisplay(),
                    SWT.CURSOR_HAND);
        }
        return handCursor;
    }

    /**
     * Returns the text cursor.
     * 
     * @return the text cursor
     */
    protected Cursor getTextCursor() {
        if (textCursor == null) {
            textCursor = new Cursor(ConsolePlugin.getStandardDisplay(),
                    SWT.CURSOR_IBEAM);
        }
        return textCursor;
    }

    /**
     * Remove first 'lines" from the content and reset styles.
     */
    public void truncate(int lineIndex) {
        if (lineIndex <= 0) {
            return;
        }
        mgr.reset(); // flush caches
        if (lineIndex >= getLineCount()) {
            setText("");
            return;
        }
        int start = getOffsetAtLine(lineIndex);
        String text = getText().substring(start);
        setText(text);
    }

}
