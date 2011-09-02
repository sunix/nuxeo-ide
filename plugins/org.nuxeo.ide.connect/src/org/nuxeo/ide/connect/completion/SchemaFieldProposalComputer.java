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
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.ui.text.java.ContentAssistInvocationContext;
import org.eclipse.jdt.ui.text.java.IJavaCompletionProposalComputer;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class SchemaFieldProposalComputer implements
        IJavaCompletionProposalComputer {

    protected SchemaProposalProcessor processor;

    public SchemaFieldProposalComputer() {
        processor = new SchemaProposalProcessor();
    }

    @Override
    public void sessionStarted() {
    }

    @Override
    public List computeCompletionProposals(
            ContentAssistInvocationContext context, IProgressMonitor monitor) {
        return Arrays.asList(processor.computeCompletionProposals(
                context.getViewer(), context.getInvocationOffset()));
    }

    @Override
    public List computeContextInformation(
            ContentAssistInvocationContext context, IProgressMonitor monitor) {
        return Arrays.asList(processor.computeContextInformation(
                context.getViewer(), context.getInvocationOffset()));
    }

    @Override
    public String getErrorMessage() {
        return processor.getErrorMessage();
    }

    @Override
    public void sessionEnded() {
    }

}
