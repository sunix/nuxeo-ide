/*
 * (C) Copyright 2011 Nuxeo SA (http://nuxeo.com/) and contributors.
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
 *     "Stephane Lacoin (aka matic) slacoin@nuxeo.com"
 */
package org.nuxeo.ide.sdk;

import org.eclipse.core.runtime.CoreException;

/**
 * @author "Stephane Lacoin (aka matic) slacoin@nuxeo.com"
 *
 * @since 1.9
 */
public interface IEclipseAdapter {
    
    public static String ID = "org.nuxeo.ide.sdk.eclipse_adapter";

    /**
     * Delegates to OpenTypeAction.findTypeInWorkspace
     * 
     */
    Object findTypeInWorkspace(String typeName) throws CoreException;


}
