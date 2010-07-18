package org.nuxeo.ide.files;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;

public class DotResourcesSyncher {

    private final class Eraser implements IResourceVisitor {

        private final IFolder root;

        private final IProgressMonitor monitor;

        private final IPath basepath;

        private Eraser(IPath basepath, IFolder root, IProgressMonitor monitor) {
            this.root = root;
            this.monitor = monitor;
            this.basepath = basepath;
        }

        @Override
        public boolean visit(IResource resource) throws CoreException {
            IPath path = relocatePath(basepath, resource);
            if (!root.exists(path)) {
                resource.delete(false, monitor);
                return false;
            }
            return true;
        }

    }

    private final class Duplicator implements IResourceVisitor {

        private final IContainer root;

        private final IProgressMonitor monitor;

        private final IPath basepath;

        private Duplicator(IPath basepath, IContainer root, IProgressMonitor monitor) {
            this.root = root;
            this.monitor = monitor;
            this.basepath = basepath;
        }

        @Override
        public boolean visit(IResource resource) throws CoreException {
            IPath path = relocatePath(basepath, resource);
            if (resource.getType() == IResource.FOLDER) {
                return duplicateFolder((IFolder) resource, path);
            }
            if (resource.getType() == IResource.FILE) {
                return duplicateFile((IFile) resource, path);
            }
            return false;
        }

        public boolean duplicateFile(IFile srcFile, IPath path) throws CoreException {
            IFile targetFile = root.getFile(path);
            if (targetFile.exists()) {
                targetFile.setContents(srcFile.getContents(), 0, monitor);
                return false;
            }
            srcFile.copy(targetFile.getFullPath(), COPY_FLAGS, monitor);
            return false;
        }

        protected boolean duplicateFolder(IFolder srcFolder, IPath path) throws CoreException {
            IFolder dstFolder = root.getFolder(path);
            if (dstFolder.exists()) {
                return true;
            }
            srcFolder.copy(dstFolder.getFullPath(), COPY_FLAGS, monitor);
            return false;
        }
    }

    protected final IPath[] dotsPath;

    protected final IPath resourcePath;

    private static final int COPY_FLAGS = IResource.DERIVED | IResource.REPLACE | IResource.FORCE;

    public DotResourcesSyncher(IPath root, IPath... dots) {
        this.resourcePath = root;
        this.dotsPath = dots;
    }

    public static DotResourcesSyncher mainResourcesSyncher() {
        return new DotResourcesSyncher(new Path("src/main/resources"), new Path("META-INF"), new Path("OSGI-INF"));
    }

    public boolean needsSynchronization(IProject project, IResourceDelta delta) {
        IResource resource = delta.getResource();
        IPath path = resource.getProjectRelativePath();
        for (IPath dotPath : dotsPath) {
            if (!dotPath.isPrefixOf(path)) {
                continue;
            }
            if (isAffected(project, delta)) {
                return true;
            }
        }
        for (IResourceDelta affected : delta.getAffectedChildren()) {
            if (needsSynchronization(project, affected)) {
                return true;
            }
        }
        return false;
    }

    public boolean isAffected(IProject project, IResourceDelta delta) {
        switch (delta.getKind()) {
        case IResourceDelta.NO_CHANGE:
        case IResourceDelta.ADDED_PHANTOM:
        case IResourceDelta.DESCRIPTION:
        case IResourceDelta.MARKERS:
        case IResourceDelta.OPEN:
            return false;
        }
        return true;
    }

    protected void createDerivedHierarchy(IFolder folder, IPath path, IProgressMonitor monitor) throws CoreException {
        if (!folder.exists()) {
            folder.create(IResource.DERIVED, true, monitor);
        }
        if (path.isEmpty()) {
            return;
        }
        folder = folder.getFolder(path.segment(0));
        path = path.removeFirstSegments(1);
        createDerivedHierarchy(folder, path, monitor);
    }

    protected void synchronizeDotFile(IProject project, IResourceDelta delta, IProgressMonitor monitor) throws CoreException {
        IFolder resourceFolder = project.getFolder(resourcePath);
        IResource resource = delta.getResource();
        IPath path = resource.getProjectRelativePath();

        switch (delta.getKind()) {
        case IResourceDelta.REMOVED:
            IResource derived = resourceFolder.findMember(path);
            if (derived == null) {
                return;
            }
            derived.delete(true, monitor);
            break;
        case IResourceDelta.ADDED:
        case IResourceDelta.CHANGED:
            createDerivedHierarchy(resourceFolder, path.removeLastSegments(1), monitor);
            IFile source = (IFile) resource;
            IFile target = resourceFolder.getFile(path);
            if (!target.exists()) {
                resource.copy(resourceFolder.getFullPath().append(path), COPY_FLAGS, monitor);
            } else {
                target.setContents(source.getContents(), 0, monitor);
            }
            break;
        }
    }

    public void copyToResources(IProject project, IResourceDelta delta, IProgressMonitor monitor) throws CoreException {
        if (!needsSynchronization(project, delta)) {
            return;
        }
        if (delta.getResource().getType() == IResource.FILE) {
            synchronizeDotFile(project, delta, monitor);
            return;
        }
        for (IResourceDelta affectedDelta : delta.getAffectedChildren()) {
            copyToResources(project, affectedDelta, monitor);
        }
    }

    public void copyToResources(final IProject project, final IProgressMonitor monitor) throws CoreException {
        final IFolder root = project.getFolder(resourcePath);
        final IPath basepath = project.getFullPath();
        for (IPath dotPath : dotsPath) {
            final IFolder dotFolder = project.getFolder(dotPath);
            if (!dotFolder.exists()) {
                continue;
            }
            dotFolder.accept(new Duplicator(basepath, root, monitor));
        }
    }

    public void copyFromResources(IProject project, IProgressMonitor monitor) throws CoreException {
        IFolder root = project.getFolder(resourcePath);
        IPath basepath = root.getFullPath();
        for (IPath path : dotsPath) {
            IFolder resourcesFolder = root.getFolder(path);
            if (!resourcesFolder.exists()) {
                continue;
            }
            final IFolder dotFolder = project.getFolder(path);
            resourcesFolder.accept(new Duplicator(basepath, project, monitor));
            dotFolder.accept(new Eraser(basepath, resourcesFolder, monitor));
        }

    }

    public static final IPath DOT_PATH = new Path(".");

    public IPath relocatePath(IPath basepath, IResource resource) {
        IPath resourcePath = resource.getFullPath();
        IPath relativePath = resourcePath.removeFirstSegments(basepath.segmentCount());
        return relativePath;
    }

}
