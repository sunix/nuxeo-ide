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

import org.eclipse.jdt.core.CompletionProposal;
import org.eclipse.jdt.core.CompletionRequestor;
import org.eclipse.jdt.ui.text.java.JavaContentAssistInvocationContext;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.swt.graphics.Image;
import org.nuxeo.ide.connect.ConnectPlugin;
import org.nuxeo.ide.connect.StudioProjectBinding;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class StudioCompletionProposalCollector extends CompletionRequestor {

    protected JavaContentAssistInvocationContext ctx;

    protected MethodArgumentMatcher[] matchers;

    protected List<ICompletionProposal> proposals;

    /**
     * The studio binding used to get schema paths
     */
    protected StudioProjectBinding binding;

    /**
     * The image used for proposals. This is a shared image should not be
     * disposed.
     */
    protected Image img;

    /**
     * Where the code completion occurred (and potential completion must be
     * inserted)
     */
    protected int offset = -1;

    /**
     * The string to replace that starts at offset. If <=0 no replacement (but
     * insert) is done
     */
    protected int replacementLength = 0;

    /**
     * Not null only if the completion occurs in a string literal. In that case
     * it represent the prefix of the schema xpath where the completion should
     * be done.
     */
    protected String prefix;

    /**
     * The cached matcher that was selected to provide completion proposal. Null
     * If no matcher was selected.
     */
    private MethodArgumentMatcher matcher;

    public StudioCompletionProposalCollector(
            JavaContentAssistInvocationContext ctx, StudioProjectBinding binding) {
        super(false);
        setRequireExtendedContext(true);
        this.ctx = ctx;
        this.binding = binding;
        proposals = new ArrayList<ICompletionProposal>();
        img = ConnectPlugin.getDefault().getImageRegistry().get(
                "icons/studio_project.gif");
        initMatchers();
    }

    public void initialize(int offset, int replacementLength, String prefix) {
        this.offset = offset;
        this.replacementLength = replacementLength;
        this.prefix = prefix;
        this.matcher = null;
    }

    public StudioProjectBinding getBinding() {
        return binding;
    }

    public String[] getSchemaPaths() {
        return binding.getSchemaPaths();
    }

    protected void initMatchers() {
        matchers = new MethodArgumentMatcher[] { new GetPropertyValueMatcher(),
                new GetPropertyMatcher() };
    }

    public String getPrefix() {
        return prefix;
    }

    protected org.eclipse.jface.text.contentassist.CompletionProposal createProposal(
            JavaContentAssistInvocationContext ctx,
            CompletionProposal proposal, String label, String text) {
        return new org.eclipse.jface.text.contentassist.CompletionProposal(
                text, offset, replacementLength, text.length(), img, label,
                null, null);
    }

    public List<ICompletionProposal> getProposals() {
        return proposals;
    }

    public void addProposal(ICompletionProposal proposal) {
        proposals.add(proposal);
    }

    public void addProposal(CompletionProposal proposal, String label,
            String text) {
        proposals.add(createProposal(ctx, proposal, label, text));
    }

    @Override
    public void accept(CompletionProposal proposal) {
        if (matcher != null) {
            // already found a matcher
            return;
        }
        if (CompletionProposal.METHOD_REF != proposal.getKind()) {
            // only works on method ref.
            return;
        }
        if (proposal.getReplaceEnd() != proposal.getReplaceStart()) {
            // do not accept proposals when method name is not completed
            // (i.e. the '(' is not before |)
            // e.g.getPropertyVal| or getPropertyValue|
            // Accept only if | is inside ( )
            return;
        }
        // we should be inside the parenthesis
        for (MethodArgumentMatcher m : matchers) {
            if (m.matches(ctx, proposal)) {
                matcher = m;
                break;
            }
        }
        if (matcher != null) {
            printContext(proposal);
            matcher.fillProposals(this, proposal);
        }
    }

    /**
     * only for debug
     * 
     * @param proposal
     */
    protected void printContext(CompletionProposal proposal) {
        if (proposal == null || proposal.getName() == null) {
            return;
        }
        try {
            System.out.println("------------");
            System.out.println("Name: " + new String(proposal.getName()));
            System.out.println("Proposal Kind: " + proposal.getKind());
            System.out.println("Offset: " + ctx.getInvocationOffset());
            System.out.println("Suggested completion: "
                    + new String(proposal.getCompletion()) + " at "
                    + proposal.getCompletionLocation());
            System.out.println("Signature: "
                    + new String(proposal.getSignature()));
            System.out.println("Token Range: " + proposal.getTokenStart()
                    + ", " + proposal.getTokenEnd());
            System.out.println("Replace Range: " + proposal.getReplaceStart()
                    + ", " + proposal.getReplaceEnd());
            System.out.println("Context Token: "
                    + new String(ctx.getCoreContext().getToken()));
            System.out.println("Context Token Location: "
                    + ctx.getCoreContext().getTokenLocation());
            System.out.println("Context Token Kind : "
                    + ctx.getCoreContext().getTokenKind());
            System.out.println("Partition: "
                    + ctx.getDocument().getPartition(ctx.getInvocationOffset()));
            System.out.println("ident: " + ctx.computeIdentifierPrefix());
            System.out.println("------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
