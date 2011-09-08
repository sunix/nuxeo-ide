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

import java.util.Arrays;

import org.eclipse.jdt.core.CompletionProposal;
import org.eclipse.jdt.ui.text.java.JavaContentAssistInvocationContext;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public abstract class MethodArgumentMatcher {

    protected char[] name;

    protected char[] decl;

    protected int args;

    public MethodArgumentMatcher(String decl, String name) {
        this(decl, name, 1);
    }

    public MethodArgumentMatcher(String decl, String name, int args) {
        this.name = name.toCharArray();
        this.decl = decl.toCharArray();
        this.args = args;
    }

    public boolean matches(JavaContentAssistInvocationContext ctx,
            CompletionProposal proposal) {
        char[] decl = proposal.getDeclarationSignature();
        char[] name = proposal.getName();
        // TODO: use args check
        if (decl == null || name == null) {
            return false;
        }
        return Arrays.equals(decl, this.decl) && Arrays.equals(name, this.name);
    }

    public void fillProposals(StudioCompletionProposalCollector collector,
            CompletionProposal proposal) {
        String prefix = collector.getPrefix();
        try {
            if (prefix != null) {
                for (String path : collector.getSchemaPaths()) {
                    if (path.startsWith(collector.prefix)) {
                        collector.addProposal(proposal, path, "\"" + path
                                + "\"");
                    } else {
                        if (!collector.getProposals().isEmpty()) {
                            break;
                        }
                    }
                }
            } else {
                for (String path : collector.getSchemaPaths()) {
                    collector.addProposal(proposal, path, "\"" + path + "\"");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
