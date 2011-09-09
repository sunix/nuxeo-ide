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
package org.nuxeo.ide.connect.completion;

import java.util.List;

import org.eclipse.jdt.ui.text.java.JavaContentAssistInvocationContext;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.swt.graphics.Image;
import org.nuxeo.ide.connect.StudioProjectBinding;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public interface StudioProposalCollector {

    /**
     * Initialize the collector with context location informations
     * 
     * @param offset
     * @param replacementLength
     * @param prefix
     */
    public void initialize(int offset, int replacementLength, String prefix);

    /**
     * Where the code completion occurred (and potential completion must be
     * inserted)
     */
    public int getOffset();

    /**
     * The string to replace that starts at offset. If <=0 no replacement (but
     * insert) is done
     */
    public int getReplacementLength();

    /**
     * Not null only if the completion occurs in a string literal. In that case
     * it represent the prefix of the schema xpath where the completion should
     * be done.
     */
    public String getPrefix();

    /**
     * The studio binding used to fetch completion proposals
     * 
     * @return
     */
    public StudioProjectBinding getBinding();

    /**
     * The default image to be used for proposals
     * 
     * @return
     */
    public Image getImage();

    /**
     * Get the java completion context
     * 
     * @return
     */
    public JavaContentAssistInvocationContext getContext();

    /**
     * Get the collected proposals
     * 
     * @return
     */
    public List<ICompletionProposal> getProposals();

}
