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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.ui.text.java.JavaContentAssistInvocationContext;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.swt.graphics.Image;
import org.nuxeo.ide.connect.ConnectPlugin;
import org.nuxeo.ide.connect.StudioProjectBinding;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class StudioAssignmentProposalCollector implements
        StudioProposalCollector {

    protected Image img;

    protected StudioProjectBinding binding;

    protected JavaContentAssistInvocationContext ctx;

    protected int offset;

    protected int replacementLength;

    protected String prefix;

    public StudioAssignmentProposalCollector(
            JavaContentAssistInvocationContext jctx,
            StudioProjectBinding binding) {
        this.ctx = jctx;
        this.binding = binding;
        this.img = ConnectPlugin.getDefault().getImageRegistry().get(
                "icons/studio_project.gif");
    }

    @Override
    public void initialize(int offset, int replacementLength, String prefix) {
        this.offset = offset;
        this.replacementLength = replacementLength;
        this.prefix = prefix;
    }

    @Override
    public String getPrefix() {
        return prefix;
    }

    @Override
    public Image getImage() {
        return img;
    }

    @Override
    public StudioProjectBinding getBinding() {
        return binding;
    }

    @Override
    public JavaContentAssistInvocationContext getContext() {
        return ctx;
    }

    @Override
    public int getReplacementLength() {
        return replacementLength;
    }

    @Override
    public int getOffset() {
        return offset;
    }

    @Override
    public List<ICompletionProposal> getProposals() {
        return computeProposals();
    }

    public List<ICompletionProposal> computeProposals() {
        ArrayList<ICompletionProposal> proposals = new ArrayList<ICompletionProposal>();
        try {
            if (prefix != null) {
                for (String path : binding.getSchemaPaths()) {
                    if (path.startsWith(prefix)) {
                        proposals.add(StudioProposal.createProposal(this, path,
                                "\"" + path + "\""));
                    } else {
                        if (!proposals.isEmpty()) {
                            break;
                        }
                    }
                }
            } else {
                for (String path : binding.getSchemaPaths()) {
                    proposals.add(StudioProposal.createProposal(this, path,
                            "\"" + path + "\""));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return proposals;
    }

}
