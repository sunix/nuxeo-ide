/*
 * (C) Copyright 2006-2013 Nuxeo SAS (http://nuxeo.com/) and contributors.
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
 *     ldoguin
 */
package org.nuxeo.ide.sdk.templates.cmd;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.nuxeo.ide.sdk.IConnectProvider;
import org.nuxeo.ide.sdk.SDKPlugin;
import org.nuxeo.ide.sdk.model.Artifact;
import org.nuxeo.ide.sdk.model.PomModel;
import org.nuxeo.ide.sdk.templates.TemplateContext;
import org.w3c.dom.Element;

/**
 * Add Studio projects dependencies to pom.
 * 
 * @author <a href="mailto:ldoguin@nuxeo.com">Laurent Doguin</a>
 * 
 */
public class StudioDependenciesCommand implements PostCreateCommand {

	protected Set<Artifact> artifacts;

	@Override
	public void init(Element element) {
		artifacts = new HashSet<Artifact>();
	}

	@Override
	public void execute(IProject project, TemplateContext ctx) throws Exception {
		for (IConnectProvider.Infos infos : SDKPlugin.getDefault()
				.getConnectProvider()
				.getLibrariesInfos(project.getProject(), null)) {
			Artifact artifact = Artifact.fromGav(infos.gav);
			artifact.setUnmanaged();
			artifacts.add(artifact);
		}
		IPath pomPath = project.getFile("pom.xml").getLocation();
		if (pomPath == null) {
			throw new IllegalArgumentException("given project as no pom file");
		}
		File pomFile = pomPath.toFile();
		PomModel pom = new PomModel(pomFile);
		for (Artifact a : pom.getDependencies()) {
			if (artifacts.contains(a)) {
				artifacts.remove(a);
			}
		}
		for (Artifact artifact : artifacts) {
			pom.addDependency(artifact);
		}
		pom.write(pomFile);
	}

}
