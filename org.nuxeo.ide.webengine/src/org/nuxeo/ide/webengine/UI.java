/*
 * (C) Copyright 2006-2008 Nuxeo SAS (http://nuxeo.com/) and contributors.
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
package org.nuxeo.ide.webengine;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 *
 */
public class UI {

    public static final String APPLICATION_NAME = "Nuxeo IDE";

    public static void showError(String message, Throwable t) {
        showError(message, t, APPLICATION_NAME);
    }

    public static void showError(String message, Throwable t, String title) {
        IStatus status = new Status(IStatus.ERROR, Nuxeo.getContext().getBundle().getSymbolicName(), IStatus.OK, message, t);
        ErrorDialog dlg = new ErrorDialog(Display.getDefault().getActiveShell(),
                title, message, status, IStatus.ERROR | IStatus.WARNING | IStatus.INFO | IStatus.OK | IStatus.CANCEL);
        dlg.open();
    }

    public static void showError(String message) {
        showError(message, APPLICATION_NAME);
    }

    public static void showError(String message, String title) {
        MessageDialog dlg = new MessageDialog(Display.getDefault().getActiveShell(), title, null,
                message,
                MessageDialog.ERROR, new String[] {"Ok"}, 0);
        dlg.open();
    }

    public static void showWarning(String message) {
        showWarning(message, APPLICATION_NAME);
    }

    public static void showWarning(String message, String title) {
        MessageDialog dlg = new MessageDialog(Display.getDefault().getActiveShell(), title, null,
                message,
                MessageDialog.WARNING, new String[] {"Ok"}, 0);
        dlg.open();
    }

    public static void showInfo(String message) {
        showInfo(message, APPLICATION_NAME);
    }


    public static void showInfo(String message, String title) {
        MessageDialog dlg = new MessageDialog(Display.getDefault().getActiveShell(), title, null,
                message,
                MessageDialog.INFORMATION, new String[] {"Ok"}, 0);
        dlg.open();
    }

    public static int showPrompt(String message) {
        return showPrompt(message, APPLICATION_NAME);
    }

    public static int showPrompt(String message, String title) {
        MessageDialog dlg = new MessageDialog(Display.getDefault().getActiveShell(), title, null,
                message,
                MessageDialog.QUESTION, new String[] {"Yes", "No"}, 0);
        return dlg.open();
    }
}
