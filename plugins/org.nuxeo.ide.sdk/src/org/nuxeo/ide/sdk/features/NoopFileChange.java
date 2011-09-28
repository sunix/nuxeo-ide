/*
 * (C) Copyright 2006-2011 Nuxeo SAS (http://nuxeo.com/) and contributors.
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
 *     slacoin
 */
package org.nuxeo.ide.sdk.features;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.resource.ResourceChange;

public class NoopFileChange extends ResourceChange{

    protected final IFile file;
    
    public NoopFileChange(IFile file) {
        this.file = file;
    }
    
    @Override
    protected IResource getModifiedResource() {
       return file;
    }

    @Override
    public String getName() {
        return "Noop change on " + file.getName();
    }

    @Override
    public Change perform(IProgressMonitor pm) throws CoreException {
        return this;
    }

}
