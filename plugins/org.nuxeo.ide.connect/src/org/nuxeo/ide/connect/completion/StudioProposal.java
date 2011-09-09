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

import org.eclipse.core.runtime.Assert;
import org.eclipse.jdt.ui.text.java.IJavaCompletionProposal;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class StudioProposal implements IJavaCompletionProposal {

    public static StudioProposal createProposal(
            StudioProposalCollector collector, String label, String text) {
        return new StudioProposal(text, collector.getOffset(),
                collector.getReplacementLength(), text.length(),
                collector.getImage(), label, null, null);
    }

    /** The string to be displayed in the completion proposal popup. */
    private String displayString;

    /** The replacement string. */
    private String replacementString;

    /** The replacement offset. */
    private int replacementOffset;

    /** The replacement length. */
    private int replacementLength;

    /** The cursor position after this proposal has been applied. */
    private int cursorPosition;

    /** The image to be displayed in the completion proposal popup. */
    private Image image;

    /** The context information of this proposal. */
    private IContextInformation contextInformation;

    /** The additional info of this proposal. */
    private String additionalProposalInfo;

    /** The proposal relevance: [0, 100] */
    private int relevance = 0;

    /**
     * Creates a new completion proposal based on the provided information. The
     * replacement string is considered being the display string too. All
     * remaining fields are set to <code>null</code>.
     * 
     * @param replacementString the actual string to be inserted into the
     *            document
     * @param replacementOffset the offset of the text to be replaced
     * @param replacementLength the length of the text to be replaced
     * @param cursorPosition the position of the cursor following the insert
     *            relative to replacementOffset
     */
    public StudioProposal(String replacementString, int replacementOffset,
            int replacementLength, int cursorPosition) {
        this(replacementString, replacementOffset, replacementLength,
                cursorPosition, null, null, null, null);
    }

    /**
     * Creates a new completion proposal. All fields are initialized based on
     * the provided information.
     * 
     * @param replacementString the actual string to be inserted into the
     *            document
     * @param replacementOffset the offset of the text to be replaced
     * @param replacementLength the length of the text to be replaced
     * @param cursorPosition the position of the cursor following the insert
     *            relative to replacementOffset
     * @param image the image to display for this proposal
     * @param displayString the string to be displayed for the proposal
     * @param contextInformation the context information associated with this
     *            proposal
     * @param additionalProposalInfo the additional information associated with
     *            this proposal
     */
    public StudioProposal(String replacementString, int replacementOffset,
            int replacementLength, int cursorPosition, Image image,
            String displayString, IContextInformation contextInformation,
            String additionalProposalInfo) {
        Assert.isNotNull(replacementString);
        Assert.isTrue(replacementOffset >= 0);
        Assert.isTrue(replacementLength >= 0);
        Assert.isTrue(cursorPosition >= 0);

        this.replacementString = replacementString;
        this.replacementOffset = replacementOffset;
        this.replacementLength = replacementLength;
        this.cursorPosition = cursorPosition;
        this.image = image;
        this.displayString = displayString;
        this.contextInformation = contextInformation;
        this.additionalProposalInfo = additionalProposalInfo;
    }

    public void apply(IDocument document) {
        try {
            document.replace(replacementOffset, replacementLength,
                    replacementString);
        } catch (BadLocationException x) {
            // ignore
        }
    }

    public Point getSelection(IDocument document) {
        return new Point(replacementOffset + cursorPosition, 0);
    }

    public IContextInformation getContextInformation() {
        return contextInformation;
    }

    public Image getImage() {
        return image;
    }

    public String getDisplayString() {
        if (displayString != null)
            return displayString;
        return replacementString;
    }

    public String getAdditionalProposalInfo() {
        return additionalProposalInfo;
    }

    public void setRelevance(int relevance) {
        this.relevance = relevance;
    }

    @Override
    public int getRelevance() {
        return relevance;
    }
}
