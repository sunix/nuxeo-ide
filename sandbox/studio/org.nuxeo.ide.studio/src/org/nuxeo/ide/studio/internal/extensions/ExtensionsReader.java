package org.nuxeo.ide.studio.internal.extensions;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.nuxeo.ide.studio.StudioIDEConstants;
import org.nuxeo.ide.studio.connector.StudioIDEContentProvider;

public class ExtensionsReader {
    
    StudioIDEContentProvider getWorkenchProvider() {
        IExtensionRegistry registry = Platform.getExtensionRegistry();
        IExtensionPoint point = registry.getExtensionPoint(StudioIDEConstants.EXTENSION_WORKBENCH_PROVIDER);
        if (point == null) {
            throw new Error("No NxStudio workbench provider available");
        }
        IExtension[] extensions = point.getExtensions();
        if (extensions.length != 1) {
            throw new Error("Only one NxStudio workbench provider allowed");
        }
        IConfigurationElement config = extensions[0].getConfigurationElements()[0];
        try {
            StudioIDEContentProvider provider = (StudioIDEContentProvider)config.createExecutableExtension("class");
            return provider;
        } catch (CoreException e) {
            throw new Error("Cannot load NxStudio workbench provider", e);
        }
    }

}
