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
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.content.IContentDescription;

public abstract class ResourceVisitor implements IResourceVisitor {

    private final String fqn;

    protected ResourceVisitor(String fqn) {
        this.fqn = fqn;
    }

    public enum ContentType {
        BinaryContent,
        XhtmlContent,
        UnknownContent
    };
    
    protected boolean isBinary(IFile file) throws CoreException {
            IContentDescription desc = file.getContentDescription();
            if (desc == null) {
                return false;
            }
            if (!"org.nuxeo.ide.sdk.binary".equals(desc.getContentType().getId())) {
                return false;
            }
            return true;
    }
    
    protected boolean isHtml(IFile file) throws CoreException {
        return "xhtml".equals(file.getFileExtension());
    }
    
    protected ContentType getContentType(IFile file) throws CoreException {
        if (isHtml(file)) {
            return ContentType.XhtmlContent;
        }
        if (isBinary(file)) {
            return ContentType.BinaryContent;
        }
        return ContentType.UnknownContent;
    }
    
    @Override
    public boolean visit(IResource resource) throws CoreException {
        switch (resource.getType()) {
        case IResource.FOLDER:
            return true;
        case IResource.FILE:
            String name = resource.getName();
            if (!name.startsWith(fqn)) {
                return false;
            }
            IFile file = (IFile)resource;
            String suffix = name.substring(fqn.length());
            ContentType type = getContentType(file);
            if (ContentType.UnknownContent == type) {
                return false;
            }
            visitResource(file, suffix, type);
            return false;
        }
        return false;
    }

    protected abstract void visitResource(IFile file, String suffix, ContentType type);
}