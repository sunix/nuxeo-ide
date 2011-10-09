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

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.mapping.IResourceChangeDescriptionFactory;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.NullChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.RenameParticipant;
import org.eclipse.ltk.core.refactoring.participants.ResourceChangeChecker;
import org.eclipse.ltk.core.refactoring.resource.DeleteResourceChange;
import org.eclipse.ltk.core.refactoring.resource.RenameResourceChange;
import org.nuxeo.ide.common.IOUtils;
import org.nuxeo.ide.sdk.SDKPlugin;
import org.nuxeo.ide.sdk.model.ExtensionModel;
import org.nuxeo.ide.sdk.model.ManifestWriter;

/**
 * 
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class RenameFeatureParticipant extends RenameParticipant {

    protected FeatureType type;

    protected String name;

    protected String id;

    protected String newName;

    protected String newId;

    public RenameFeatureParticipant() {
    }

    @Override
    protected boolean initialize(Object element) {
        type = FeatureType.fromElement(element);
        if (type != null && type.file.exists()) {
            String pkgName = type.type.getPackageFragment().getElementName();
            newName = getArguments().getNewName();
            if (newName.endsWith(".java")) {
                newName = newName.substring(0,
                        newName.length() - ".java".length());
            }
            newId = pkgName + "." + newName;
            id = type.type.getFullyQualifiedName();
            name = id.substring(id.lastIndexOf('.'));
            return true;
        }
        return false;
    }

    @Override
    public String getName() {
        return "Rename Feature Synchronizer";
    }

    @Override
    public RefactoringStatus checkConditions(IProgressMonitor pm,
            CheckConditionsContext context) throws OperationCanceledException {
        if (type == null) {
            return new RefactoringStatus();
        }
        ResourceChangeChecker checker = (ResourceChangeChecker) context.getChecker(ResourceChangeChecker.class);
        IResourceChangeDescriptionFactory deltaFactory = checker.getDeltaFactory();
        // deltaFactory.move(type.file,
        // type.file.getFullPath().removeLastSegments(1).append(getArguments().getNewName()))
        IFile dst = type.getProject().getFile(ExtensionModel.getPath(newId));
        IFile src = type.getProject().getFile(ExtensionModel.getPath(id));
        RefactoringStatus status = new RefactoringStatus();
        if (dst.exists()) {
            status.addError("Extension file already exists: " + dst.getName());
            return status;
        }
        deltaFactory.create(dst);
        deltaFactory.delete(src);
        IFile mf = type.getProject().getFile(ManifestWriter.PATH);
        deltaFactory.change(mf);
        checkI18NConditions(deltaFactory, status);
        checkResourceConditions(deltaFactory, status);
        return status;
    }

    protected void checkResourceConditions(
            final IResourceChangeDescriptionFactory deltaFactory,
            final RefactoringStatus status) {
        final String fqn = type.type.getFullyQualifiedName();
        final IFolder resources = type.getProject().getFolder(
                "src/main/resources");
        try {
            resources.accept(new ResourceVisitor(fqn) {

                @Override
                public void visitResource(IFile file, String suffix,
                        @SuppressWarnings("hiding") ContentType type) {
                    deltaFactory.move(
                            file,
                            file.getParent().getLocation().append(
                                    new Path(fqn + suffix)));
                }

            });
        } catch (CoreException e) {
            status.addError("Cannot visit binary resources");
        }
    }

    protected void checkI18NConditions(
            IResourceChangeDescriptionFactory deltaFactory,
            RefactoringStatus status) {
        IFolder i18n = type.getProject().getFolder(
                "src/main/i18n/web/nuxeo.war/WEB-INF/classes");
        if (!i18n.exists()) {
            return;
        }
        try {
            for (IResource m : i18n.members()) {
                deltaFactory.change((IFile) m);
            }
        } catch (CoreException e) {
            status.addError("Cannot list i18n resource bundles");
            return;
        }
    }

    @Override
    public Change createChange(IProgressMonitor pm) throws CoreException,
            OperationCanceledException {
        IFile src = type.getProject().getFile(ExtensionModel.getPath(id));
        String content = getContent(src);
        if (content == null) {
            return new NullChange("No extension found for renamed class");
        }
        content = content.replace(id, newId);
        CompositeChange result = new CompositeChange("Synchronizing extensions");
        result.add(new ExtensionChange(type.getProject().getFile(
                ExtensionModel.getPath(newId)), content, false));
        result.add(new DeleteResourceChange(type.getProject().getFile(
                ExtensionModel.getPath(id)).getFullPath(), true));
        IFile mf = type.getProject().getFile(ManifestWriter.PATH);
        if (mf.exists()) {
            ManifestChange change = new ManifestChange(mf);
            change.remove("Nuxeo-Component", ExtensionModel.getRuntimePath(id));
            change.append("Nuxeo-Component",
                    ExtensionModel.getRuntimePath(newId));
            result.add(change);
        }
        createI18nChange(result);
        createResourceChange(result);
        return result;
    }

    protected void createResourceChange(final CompositeChange result)
            throws CoreException {
        final String fqn = type.type.getFullyQualifiedName();
        final IFolder resources = type.getProject().getFolder(
                "src/main/resources");

        resources.accept(new ResourceVisitor(fqn) {

            @Override
            public void visitResource(IFile file, String suffix,
                    @SuppressWarnings("hiding") ContentType type) {
                result.add(new RenameResourceChange(file.getFullPath(), newId
                        + suffix));
            }

        });

    }

    protected void createI18nChange(CompositeChange result)
            throws CoreException {
        try {
            IFolder i18n = type.getProject().getFolder(
                    "src/main/i18n/web/nuxeo.war/WEB-INF/classes");
            if (!i18n.exists()) {
                return;
            }
            for (IResource m : i18n.members()) {
                result.add(new ReplaceIdChange((IFile) m, id, newId));
            }
        } catch (CoreException e) {
            throw new CoreException(new Status(IStatus.ERROR,
                    SDKPlugin.PLUGIN_ID,
                    "Cannot access to i18n resource bundles", e));
        }
    }

    public static String getContent(IFile file) throws CoreException {
        if (file.exists()) {
            InputStream in = file.getContents(true);
            try {
                return IOUtils.read(in);
            } catch (IOException e) {
                throw new CoreException(new Status(IStatus.ERROR,
                        SDKPlugin.PLUGIN_ID, "Failed to read extension file: "
                                + file, e));
            }
        }
        return null;
    }
}
