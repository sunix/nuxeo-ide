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

import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.CompletionContext;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.ui.text.java.ContentAssistInvocationContext;
import org.eclipse.jdt.ui.text.java.IJavaCompletionProposalComputer;
import org.eclipse.jdt.ui.text.java.JavaContentAssistInvocationContext;
import org.eclipse.swt.graphics.Point;
import org.nuxeo.ide.connect.ConnectPlugin;
import org.nuxeo.ide.connect.StudioProjectBinding;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class SchemaFieldProposalComputer implements
        IJavaCompletionProposalComputer {

    public SchemaFieldProposalComputer() {
    }

    @Override
    public void sessionStarted() {
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List computeCompletionProposals(
            ContentAssistInvocationContext context, IProgressMonitor monitor) {

        if (context instanceof JavaContentAssistInvocationContext) {
            JavaContentAssistInvocationContext jctx = (JavaContentAssistInvocationContext) context;
            IJavaProject jproject = jctx.getProject();
            if (jproject == null) {
                return Collections.emptyList();
            }
            StudioProjectBinding binding = ConnectPlugin.getStudioProvider().getBinding(
                    jproject.getProject());
            if (binding == null) {
                return Collections.emptyList();
            }
            ICompilationUnit unit = jctx.getCompilationUnit();
            StudioCompletionProposalCollector collector = new StudioCompletionProposalCollector(
                    jctx, binding);
            CompletionContext cc = jctx.getCoreContext();
            int start = -1;
            if (cc.getTokenKind() == CompletionContext.TOKEN_KIND_STRING_LITERAL) {
                start = cc.getTokenStart();
                int end = cc.getTokenEnd();
                collector.initialize(start, end - start + 1,
                        new String(cc.getToken()));
            } else {
                start = context.getInvocationOffset();
                Point p = jctx.getViewer().getSelectedRange();
                collector.initialize(start, p.y, null);
            }
            try {
                unit.codeComplete(start, collector, new NullProgressMonitor());
                return collector.getProposals();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Collections.emptyList();
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List computeContextInformation(
            ContentAssistInvocationContext context, IProgressMonitor monitor) {
        System.out.println("compute context info");
        return Collections.emptyList();
    }

    @Override
    public String getErrorMessage() {
        return null;
    }

    @Override
    public void sessionEnded() {
    }

}
