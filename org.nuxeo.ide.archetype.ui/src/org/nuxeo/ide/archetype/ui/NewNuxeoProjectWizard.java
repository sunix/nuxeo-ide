/**
 * 
 */
package org.nuxeo.ide.archetype.ui;

import org.eclipse.core.runtime.Path;
import org.nuxeo.ide.archetype.ui.providers.BundleArchetypeFileEntry;
import org.nuxeo.ide.archetype.ui.providers.IArchetypeFileEntry;

/**
 * Wizard for generating a Basic Nuxeo Project
 * 
 * @author <a href=mailto:stan@nuxeo.com>Sun Seng David TAN</a>
 * 
 */
public class NewNuxeoProjectWizard extends NewArchetypeListBasedProjectWizard {

	public NewNuxeoProjectWizard() {
		super(new ArchetypeListWizardPage() {
			@Override
			public IArchetypeFileEntry[] getArchetypeFileEntry() {
				return new IArchetypeFileEntry[] { new BundleArchetypeFileEntry(
						Activator.getDefault().getBundle(), new Path(
								"archetypes/nxBundle"), "Nuxeo basic project") };

			}
		});
	}

}
