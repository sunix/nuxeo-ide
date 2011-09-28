package org.nuxeo.ide.sdk.server;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;

import javax.management.JMX;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import javax.net.ServerSocketFactory;

import org.nuxeo.ide.common.IOUtils;
import org.nuxeo.ide.sdk.server.management.DevBundleManager;

public class ServerMonitor {
        
    protected static final ObjectName DEVBUNDLES_NAME = objectName("org.nuxeo:name=dev-bundles,type=sdk");

    protected JMXConnector connector;
    
    protected DevBundleManager devBundles;
            
    protected int jmxPort;
        
    
    protected static ObjectName objectName(String name) {
        try {
            return new ObjectName(name);
        } catch (Exception e) {
           throw new Error("Cannot get object name for bootstrap", e);
        }
    }
    
    public void connect() throws IOException {
        JMXServiceURL location = new JMXServiceURL(
                "service:jmx:rmi:///jndi/rmi://127.0.0.1:" + jmxPort +  "/jmxrmi");
        connector = JMXConnectorFactory.connect(location);
        MBeanServerConnection connection = connector.getMBeanServerConnection();
        devBundles = JMX.newMBeanProxy(connection, DEVBUNDLES_NAME, DevBundleManager.class);
//        connection.addNotificationListener(MBeanServerDelegate.DELEGATE_NAME, new NotificationListener() {
//            
//            @Override
//            public void handleNotification(Notification notification, Object handback) {
//                if (!(notification instanceof MBeanServerNotification)) {
//                    return;
//                }
//                MBeanServerNotification mbsn = (MBeanServerNotification)notification;
//                if (!MBeanServerNotification.REGISTRATION_NOTIFICATION.equals(mbsn.getType()) {
//                    return;
//                }
//                if
//            }
//        }, null, null);
    }
    
    public void disconnect() {
        if (connector == null) {
            return;
        }
        try {
            connector.close();
        } catch (IOException e) {
            ;
        }
        connector = null;
        devBundles = null;
    }
  
    public void writeDevBundles(String content) throws IOException {
        if (devBundles == null) {
            connect();
        }
        String path = devBundles.getDevBundlesLocation();
        File file = new File(path);
        IOUtils.writeFile(file, content);
        devBundles.loadDevBundles();
    }

    public int selectJMXPort() throws IOException {
        ServerSocket socket = ServerSocketFactory.getDefault().createServerSocket(0);
        jmxPort = socket.getLocalPort();
        socket.close();
        return jmxPort;
    }
}
