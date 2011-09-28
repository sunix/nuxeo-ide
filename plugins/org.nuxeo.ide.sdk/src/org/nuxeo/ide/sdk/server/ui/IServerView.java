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
package org.nuxeo.ide.sdk.server.ui;

import org.eclipse.ui.IViewPart;
import org.nuxeo.ide.sdk.server.ServerController;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public interface IServerView extends IViewPart {

    public void start() throws Exception;

    public void debug() throws Exception;

    public void stop() throws Exception;

    public void clearConsole();

    public void setScrollLock(boolean lock);

    public boolean getScrollLock();

    public void append(String text);
    
    public ServerController getController();
}
