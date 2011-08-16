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
package org.nuxeo.ide.sdk.features;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.mapping.IResourceChangeDescriptionFactory;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.DeleteParticipant;
import org.eclipse.ltk.core.refactoring.participants.ResourceChangeChecker;
import org.eclipse.ltk.core.refactoring.resource.DeleteResourceChange;
import org.nuxeo.ide.sdk.model.ManifestWriter;

;

/**
 * 
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class DeleteFeatureParticipant extends DeleteParticipant {

    protected FeatureType type;

    public DeleteFeatureParticipant() {
    }

    @Override
    protected boolean initialize(Object element) {
        type = FeatureType.fromElement(element);
        if (type != null && type.file.exists()) {
            return true;
        }
        return false;
    }

    @Override
    public String getName() {
        return "Extension Synchronizer";
    }

    @Override
    public RefactoringStatus checkConditions(IProgressMonitor pm,
            CheckConditionsContext context) throws OperationCanceledException {
        if (type == null) {
            return new RefactoringStatus();
        }
        ResourceChangeChecker checker = (ResourceChangeChecker) context.getChecker(ResourceChangeChecker.class);
        IResourceChangeDescriptionFactory deltaFactory = checker.getDeltaFactory();
        deltaFactory.delete(type.file);
        IFile mf = type.getProject().getFile(ManifestWriter.PATH);
        deltaFactory.change(mf);
        RefactoringStatus status = new RefactoringStatus();
        status.addInfo("Deleting extension file: " + type.file.getName());
        return status;
    }

    @Override
    public Change createChange(IProgressMonitor pm) throws CoreException,
            OperationCanceledException {
        CompositeChange result = new CompositeChange("Synchronizing extensions");
        result.add(new DeleteResourceChange(type.file.getFullPath(), true));
        IFile mf = type.getProject().getFile(ManifestWriter.PATH);
        if (mf.exists()) {
            ManifestChange change = new ManifestChange(mf);
            change.remove("Nuxeo-Component", type.getRuntimeExtensionPath());
            result.add(change);
        }
        return result;
    }

}
