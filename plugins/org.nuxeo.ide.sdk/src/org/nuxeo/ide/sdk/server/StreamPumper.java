package org.nuxeo.ide.sdk.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamPumper implements Runnable {

    public StreamPumper(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }
    
    public static Thread newThread(StreamPumper pumper) {
        Thread th = new Thread(pumper, "stream-pumper-" + pumper.hashCode());
        return th;
    }

    protected boolean stop;

    protected InputStream in;

    protected OutputStream out;

    protected int delay = 100;
    
    public void setDelay(int value) {
        delay = value;
    }
    
    @Override
    public void run() {
        try {
            while (!stop) {
                while (in.available() > 0 && !stop) {
                    out.write(in.read());
                }
                Thread.sleep(delay);
            }
        } catch (Exception e) {
            ;
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                ;
            }
            try {
                out.close();
            } catch (IOException e) {
                ;
            }
        }
    }
    
    public void stop() {
        stop = true;
    }

}
