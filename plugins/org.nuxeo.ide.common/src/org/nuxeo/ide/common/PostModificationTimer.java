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
package org.nuxeo.ide.common;

import org.eclipse.swt.widgets.Display;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public abstract class PostModificationTimer implements Runnable {

    protected long timeout;

    private Thread timer;

    private volatile boolean modified = false;

    public PostModificationTimer() {
        this(200);
    }

    public PostModificationTimer(long timeout) {
        this.timeout = timeout;
    }

    public void touch() {
        modified = true;
    }

    public void start() {
        Thread timer = new Thread(new Task());
        timer.start();
    }

    public synchronized void stop() {
        if (timer != null) {
            timer.interrupt();
            timer = null;
        }
    }

    private class Task implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(timeout);
                    if (modified) {
                        modified = false;
                        Display display = Display.getCurrent();
                        if (display == null) {
                            display = Display.getDefault();
                        }
                        display.asyncExec(PostModificationTimer.this);
                    }
                } catch (InterruptedException e) {
                    // do nothing - exit the thread.
                }
            }
        }
    }

    @Override
    public abstract void run();

}
