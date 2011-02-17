package org.nuxeo.ide.studio.internal.launcher;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.jdt.launching.IRuntimeClasspathEntry;
import org.eclipse.jdt.launching.StandardClasspathProvider;

public class RuntimeClasspathProvider extends StandardClasspathProvider {

    @Override
    public IRuntimeClasspathEntry[] resolveClasspath(
            IRuntimeClasspathEntry[] entries, ILaunchConfiguration configuration)
            throws CoreException {
        return super.resolveClasspath(entries, configuration);
    }
    
    @Override
    public IRuntimeClasspathEntry[] computeUnresolvedClasspath(
            ILaunchConfiguration configuration) throws CoreException {
        return super.computeUnresolvedClasspath(configuration);
    }
}
