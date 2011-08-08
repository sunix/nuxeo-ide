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
package org.nuxeo.ide.sdk.server;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public abstract class FileTail {

    protected long offset;

    protected File file;

    protected RandomAccessFile in;

    protected volatile boolean closeRequest;

    protected Thread thread;

    public FileTail(File file) {
        this.file = file;
    }

    public void tailAsync() {
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    doTail();
                } catch (IOException e) {
                    handleException(e);
                } finally {
                    dispose();
                }
            }
        }, "Nuxeo Server Log Reader");
        thread.start();
    }

    public void tail() throws IOException {
        try {
            doTail();
        } finally {
            dispose();
        }
    }

    protected void dispose() {
        thread = null;
        offset = 0;
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
            } finally {
                in = null;
            }
        }
    }

    public void close() {
        closeRequest = true;
        if (thread != null) {
            thread.interrupt();
            thread = null;
        }
    }

    protected void doTail() throws IOException {
        while (!closeRequest) {
            try {
                if (!acquireStream()) {
                    return; // close request
                }
                // read available lines
                offset = readLines();
                // check for close request
                if (closeRequest) {
                    return;
                }
                // sleep until new lines become available
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
        }
    }

    protected boolean acquireStream() throws InterruptedException {
        while (in == null || file.length() < offset) {
            try {
                in = new RandomAccessFile(file, "r");
                offset = 0;
                Thread.sleep(200);
            } catch (FileNotFoundException e) {
                if (closeRequest) {
                    return false;
                }
            }
        }
        return true;
    }

    protected long readLines() throws IOException {
        in.seek(offset);
        StringBuilder buf = new StringBuilder();
        String line = in.readLine();
        while (line != null) {
            buf.append(line).append("\r\n");
            line = in.readLine();
        }
        if (buf.length() > 0) {
            handleContent(buf.toString());
        }
        return in.getFilePointer();
    }

    protected abstract void handleContent(String content);

    protected void handleException(Throwable t) {
        t.printStackTrace();
    }

}
