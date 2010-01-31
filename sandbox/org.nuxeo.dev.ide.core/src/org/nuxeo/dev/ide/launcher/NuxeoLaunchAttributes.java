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
package org.nuxeo.dev.ide.launcher;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 *
 */
public interface NuxeoLaunchAttributes {
    
    public static final String HOME = "org.nuxeo.dev.home";
    public static final String HOST = "org.nuxeo.dev.host";
    public static final String NOCACHE = "org.nuxeo.dev.nocache";
    public static final String UPDATE = "org.nuxeo.dev.update";
    public static final String OFFLINE = "org.nuxeo.dev.offline";
    //public static final String MAIN = "org.nuxeo.dev.main";
    public static final String PROFILE = "org.nuxeo.dev.profile";
    public static final String CUSTOM_PROFILE = "org.nuxeo.dev.customProfile";
    
}
