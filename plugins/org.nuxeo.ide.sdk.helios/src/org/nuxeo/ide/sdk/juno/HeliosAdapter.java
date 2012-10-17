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
package org.nuxeo.ide.sdk.juno;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.internal.debug.ui.actions.OpenTypeAction;
import org.nuxeo.ide.sdk.IEclipseAdapter;

/**
 * @author "Stephane Lacoin (aka matic) slacoin@nuxeo.com"
 *
 */
public class HeliosAdapter implements IEclipseAdapter{


    @Override
    public Object findTypeInWorkspace(String typeName) throws CoreException {
        return OpenTypeAction.findTypeInWorkspace(typeName);
    }

}
