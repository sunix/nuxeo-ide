package org.nuxeo.ide.sdk.server.ui;

import java.io.IOException;

import org.eclipse.core.runtime.ListenerList;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;
import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.sdk.NuxeoSDK;
import org.nuxeo.ide.sdk.SDKChangedListener;
import org.nuxeo.ide.sdk.deploy.Deployment;
import org.nuxeo.ide.sdk.deploy.DeploymentPreferences;
import org.nuxeo.ide.sdk.server.ServerConstants;
import org.nuxeo.ide.sdk.server.ServerController;
import org.nuxeo.ide.sdk.server.ServerLifeCycleAdapter;

public class ServerView extends ViewPart implements ISelectionProvider,
        SDKChangedListener {

    /**
     * The ID of the view as specified by the extension.
     */
    public static final String ID = "org.nuxeo.ide.server.views.ServerView";

    protected Text console;

    protected ServerController ctrl;

    protected MyServerLifeCycleListener listener;

    protected ListenerList selectionListeners;

    /**
     * The constructor.
     */
    public ServerView() {
        selectionListeners = new ListenerList();
        listener = new MyServerLifeCycleListener();
        initServer();
        NuxeoSDK.addSDKChangedListener(this);
    }

    protected void initServer() {
        if (ctrl != null) {
            int state = ctrl.getState();
            if (state == ServerConstants.STARTED
                    || state == ServerConstants.STARTING) {
                try {
                    ctrl.stopAsJob();
                } catch (IOException e) {
                    UI.showError("Failed to stop running server", e);
                }
            }
            ctrl.removeServerLifeCycleListener(listener);
            ctrl = null;
        }
        NuxeoSDK sdk = NuxeoSDK.getDefault();
        if (sdk != null) {
            ctrl = new ServerController(sdk.getInfo());
            ctrl.addServerLifeCycleListener(listener);
            System.out.println("Server initialized");
        }
        setSelection(getSelection());
    }

    @Override
    public void handleSDKChanged(NuxeoSDK sdk) {
        System.out.println("SDK changed");
        initServer();
    }

    public Text getConsole() {
        return console;
    }

    public void start() throws Exception {
        // auto deployment
        Deployment deploy = DeploymentPreferences.load().getDefault();
        if (deploy != null) {
            NuxeoSDK.getDefault().reloadDeployment(deploy);
        }
        // now start
        console.setText("=== Starting Nuxeo Server ===\r\n");
        ctrl.startAsJob();
    }

    public void stop() throws Exception {
        if (ctrl == null) {
            return;
        }
        ctrl.stopAsJob();
    }

    /**
     * This is a callback that will allow us to create the viewer and initialize
     * it.
     */
    @Override
    public void createPartControl(Composite parent) {
        console = new Text(parent, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL
                | SWT.H_SCROLL | SWT.FLAT | SWT.READ_ONLY);
    }

    @Override
    public void dispose() {
        NuxeoSDK.removeSDKChangedListener(this);
        if (listener != null) {
            ctrl.removeServerLifeCycleListener(listener);
            listener = null;
        }
        if (ctrl != null) {
            try {
                ctrl.stop(false);
            } catch (Exception e) {
                UI.showError("Faield to stop the server.", e);
            }
            ctrl = null;
        }
        super.dispose();
        selectionListeners.clear();
        selectionListeners = null;

        console.dispose();
        console = null;
    }

    /**
     * Passing the focus request to the viewer's control.
     */
    @Override
    public void setFocus() {
        console.setFocus();
    }

    class MyServerLifeCycleListener extends ServerLifeCycleAdapter {
        @Override
        public void handleConsoleError(ServerController ctrl, Throwable t) {
            t.printStackTrace();
        }

        @Override
        public void handleConsoleText(ServerController ctrl, final String text) {
            if (console != null) {
                Display.getDefault().asyncExec(new Runnable() {
                    @Override
                    public void run() {
                        console.append(text);
                    }
                });
            }
        }

        @Override
        public void serverStateChanged(ServerController ctrl, int state) {
            if (state == ServerConstants.STARTED) {
                handleConsoleText(ctrl, "=== Nuxeo Server Started ===\r\n");
            } else if (state == ServerConstants.STOPPED) {
                handleConsoleText(ctrl, "=== Nuxeo Server Stopped ===\r\n");
            }
            setSelection(new ServerState(state));
        }
    }

    @Override
    public void addSelectionChangedListener(ISelectionChangedListener listener) {
        selectionListeners.add(listener);
    }

    @Override
    public void removeSelectionChangedListener(
            ISelectionChangedListener listener) {
        if (selectionListeners != null) {
            selectionListeners.remove(listener);
        }
    }

    @Override
    public void setSelection(ISelection selection) {
        SelectionChangedEvent event = new SelectionChangedEvent(this, selection);
        for (Object obj : selectionListeners.getListeners()) {
            ((ISelectionChangedListener) obj).selectionChanged(event);
        }
    }

    @Override
    public ISelection getSelection() {
        return new ServerState(ctrl == null ? ServerConstants.UNDEFINED
                : ctrl.getState());
    }

    @Override
    public void init(IViewSite site) throws PartInitException {
        super.init(site);
        site.setSelectionProvider(this);
    }

    static class ServerState implements ISelection {
        protected int state;

        public ServerState(int state) {
            this.state = state;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        public int getState() {
            return state;
        }
    }

}