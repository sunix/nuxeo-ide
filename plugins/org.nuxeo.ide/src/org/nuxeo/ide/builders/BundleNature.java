package org.nuxeo.ide.builders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.pde.internal.core.ClasspathComputer;

@SuppressWarnings("restriction")
public class BundleNature implements IProjectNature {

	private static final String ORG_ECLIPSE_JDT_JUNIT_JUNIT_CONTAINER = "org.eclipse.jdt.junit.JUNIT_CONTAINER";

	private static final String ORG_ECLIPSE_JDT_JUNIT_JUNIT_CONTAINER_4 = ORG_ECLIPSE_JDT_JUNIT_JUNIT_CONTAINER + "/4";
	/**
	 * ID of this project nature
	 */
	public static final String NATURE_ID = BundleNature.class.getCanonicalName();

	private IProject project;

	public BundleNature() {
		super();
	}
	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.core.resources.IProjectNature#configure()
	 */
	public void configure() throws CoreException {
		installJ2SE16();
		installJunitLibrary();
		installOutputLocations();
		installBuilder();
	}

	protected void installOutputLocations() throws CoreException {
		IJavaProject javaProject = JavaCore.create(project);
		IPath mainBinPath = project.getFolder("bin/main").getFullPath();
		IPath testBinPath = project.getFolder("bin/test").getFullPath();
		IPath testSrcPath = project.getFolder("src/test").getFullPath();
		javaProject.setOutputLocation(mainBinPath, null);
		IClasspathEntry[] cp = javaProject.getRawClasspath();
		for (int idx = 0; idx < cp.length; ++idx) {
			IClasspathEntry e = cp[idx];
			if (e.getEntryKind() != IClasspathEntry.CPE_SOURCE) {
				continue;
			}
			if (testSrcPath.isPrefixOf(e.getPath())) {
				cp[idx] = JavaCore.newSourceEntry(e.getPath(),e.getInclusionPatterns(), e.getExclusionPatterns(), testBinPath );
			}
		}
		javaProject.setRawClasspath(cp, null);
	}

	protected void installBuilder() throws CoreException {
		IProjectDescription desc = project.getDescription();
		ICommand[] commands = desc.getBuildSpec();

		for (int i = 0; i < commands.length; ++i) {
			if (commands[i].getBuilderName().equals(BundleBuilder.BUILDER_ID)) {
				return;
			}
		}

		ICommand[] newCommands = new ICommand[commands.length + 1];
		System.arraycopy(commands, 0, newCommands, 0, commands.length);
		ICommand command = desc.newCommand();
		command.setBuilderName(BundleBuilder.BUILDER_ID);
		newCommands[newCommands.length - 1] = command;
		desc.setBuildSpec(newCommands);
		project.setDescription(desc, null);
	}

	protected void installJ2SE16() throws JavaModelException {
		IJavaProject javaProject = JavaCore.create(project);
		ClasspathComputer.setComplianceOptions(javaProject, "JavaSE-1.6");
	}

	protected boolean hasTestSources() throws JavaModelException {
		IJavaProject javaProject = JavaCore.create(project);
		IClasspathEntry[] cp = javaProject.getRawClasspath();
		for (IClasspathEntry entry:cp) {
			if (entry.getEntryKind() != IClasspathEntry.CPE_SOURCE) {
				continue;
			}
			String[] segments = entry.getPath().segments();
			if (Arrays.asList(segments).contains("test")) {
				return true;
			}
		}
		return false;
	}

	protected boolean hasJunitLibrary() throws JavaModelException {
		IJavaProject javaProject = JavaCore.create(project);
		IClasspathEntry[] cp = javaProject.getRawClasspath();
		for (IClasspathEntry entry:cp) {
			if (entry.getEntryKind() != IClasspathEntry.CPE_CONTAINER) {
				continue;
			}
			String[] segments = entry.getPath().segments();
			if (Arrays.asList(segments).contains(ORG_ECLIPSE_JDT_JUNIT_JUNIT_CONTAINER)) {
				return true;
			}
		}
		return false;
	}

	protected void installJunitLibrary() throws CoreException {
		if (!hasTestSources()) {
			return;
		}
		if (hasJunitLibrary()) {
			return;
		}
		IJavaProject javaProject = JavaCore.create(project);
		List<IClasspathEntry> entries = new ArrayList<IClasspathEntry>();
		entries.addAll(Arrays.asList(javaProject.getRawClasspath()));
		IClasspathEntry junit = JavaCore.newContainerEntry(new Path(ORG_ECLIPSE_JDT_JUNIT_JUNIT_CONTAINER_4));
		entries.add(junit);
		javaProject.setRawClasspath(entries.toArray(new IClasspathEntry[entries.size()]), null);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.core.resources.IProjectNature#deconfigure()
	 */
	public void deconfigure() throws CoreException {
		IProjectDescription description = getProject().getDescription();
		ICommand[] commands = description.getBuildSpec();
		for (int i = 0; i < commands.length; ++i) {
			if (commands[i].getBuilderName().equals(BundleBuilder.BUILDER_ID)) {
				ICommand[] newCommands = new ICommand[commands.length - 1];
				System.arraycopy(commands, 0, newCommands, 0, i);
				System.arraycopy(commands, i + 1, newCommands, i,
						commands.length - i - 1);
				description.setBuildSpec(newCommands);
				project.setDescription(description, null);
				return;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.core.resources.IProjectNature#getProject()
	 */
	public IProject getProject() {
		return project;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.core.resources.IProjectNature#setProject(org.eclipse.core.resources.IProject)
	 */
	public void setProject(IProject project) {
		this.project = project;
	}

}
