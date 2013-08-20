package org.nuxeo.ide.sdk.comp.contentassist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IAnnotation;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMemberValuePair;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.wst.sse.core.StructuredModelManager;
import org.eclipse.wst.sse.core.internal.provisional.IStructuredModel;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocumentRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegionList;
import org.eclipse.wst.sse.ui.contentassist.CompletionProposalInvocationContext;
import org.eclipse.wst.xml.core.internal.provisional.document.IDOMNode;
import org.eclipse.wst.xml.ui.internal.contentassist.ContentAssistRequest;
import org.eclipse.wst.xml.ui.internal.contentassist.DefaultXMLCompletionProposalComputer;
import org.nuxeo.ide.sdk.SDKPlugin;
import org.w3c.dom.Node;

@SuppressWarnings("restriction")
public class NuxeoXmlComponentProposalComputer extends
        DefaultXMLCompletionProposalComputer {

    public static final String XOBJECT = "org.nuxeo.common.xmap.annotation.XObject";

    public static final String XNODEMAP = "org.nuxeo.common.xmap.annotation.XNodeMap";

    public static final String XNODELIST = "org.nuxeo.common.xmap.annotation.XNodeList";

    public static final String XNODE = "org.nuxeo.common.xmap.annotation.XNode";

    @Override
    protected void addAttributeNameProposals(
            ContentAssistRequest contentAssistRequest,
            CompletionProposalInvocationContext context) {

        IDOMNode node = (IDOMNode) contentAssistRequest.getNode();
        int offset = getOffset(context);
        List<Node> nodePath = getNodePath(contentAssistRequest);
        String prefix = extractPrefix(context.getViewer(), offset);

        // detect current element
        if ("component".equals(node.getNodeName()) && nodePath.size() == 2) {
            // find open region
            IStructuredDocumentRegion open = node.getFirstStructuredDocumentRegion();
            ITextRegionList openRegions = open.getRegions();
            int i = openRegions.indexOf(contentAssistRequest.getRegion());
            if (i < 0) {
                return;
            }

            contentAssistRequest.addProposal(new CompletionProposal(
                    "name=\"\" ", offset - prefix.length(), prefix.length(), 6,
                    SDKPlugin.getDefault().getImageRegistry().get(
                            "icons/comp/component.gif"),
                    "name - Component name ", null, "The name of the component"));
            return;
        }

        if ("extension".equals(node.getNodeName()) && nodePath.size() == 3) {
            ExtensionProposalProcessor extensionProposalProcessor = new ExtensionProposalProcessor(
                    context);
            extensionProposalProcessor.findAndAddExtensionProposal(prefix,
                    contentAssistRequest, offset);
            return;
        }

        ExtensionPointNodeResolver extensionPointNodeResolver = new ExtensionPointNodeResolver();
        extensionPointNodeResolver.resolve(nodePath, context);

        IType nodeDescriptorType = extensionPointNodeResolver.getNodeDescriptorType();
        String currentNodePath = extensionPointNodeResolver.getCurrentNodePath();

        if (nodeDescriptorType != null) {
            // propose the current object attribute

            IField[] fields;
            try {
                fields = nodeDescriptorType.getFields();
            } catch (JavaModelException e) {
                SDKPlugin.log(
                        IStatus.WARNING,
                        "exception while trying to get fields from the node type descriptor",
                        e);
                return;
            }
            for (IField field : fields) {
                IAnnotation xnodeAnnotation = field.getAnnotation(XNODE);
                if (xnodeAnnotation != null) {
                    String elementName = getAnnotationValue(xnodeAnnotation);

                    // specific completion proposal for attribute name
                    if (elementName == null) {
                        continue;
                    }
                    if (currentNodePath != null
                            && !elementName.startsWith(currentNodePath)) {
                        continue;
                    }
                    elementName = currentNodePath == null ? elementName
                            : elementName.substring(currentNodePath.length());
                    if (elementName.toLowerCase().contains(prefix.toLowerCase())
                            && elementName.startsWith("@")) {
                        String replacementString = elementName.substring(1)
                                + "=\"\"";
                        CompletionProposal newProposal;
                        try {
                            newProposal = new CompletionProposal(
                                    replacementString,
                                    offset - prefix.length(),
                                    prefix.length(),
                                    replacementString.length() - 1,
                                    SDKPlugin.getDefault().getImageRegistry().get(
                                            "icons/comp/xpoint.gif"),
                                    replacementString, null,
                                    field.getAttachedJavadoc(null));
                            contentAssistRequest.addProposal(newProposal);
                        } catch (JavaModelException e) {
                            SDKPlugin.log(
                                    IStatus.ERROR,
                                    "An error occured while generating xpoints completion proposal",
                                    e);
                        }
                    }
                }

            }

        }

    }

    @Override
    protected void addEntityProposals(
            ContentAssistRequest contentAssistRequest,
            ITextRegion completionRegion, IDOMNode treeNode,
            CompletionProposalInvocationContext context) {
        // TODO suggest elements to add
        super.addEntityProposals(contentAssistRequest, completionRegion,
                treeNode, context);
    }

    @Override
    protected void addTagNameProposals(
            ContentAssistRequest contentAssistRequest, int childPosition,
            CompletionProposalInvocationContext context) {
        int offset = getOffset(context);
        List<Node> nodePath = getNodePath(contentAssistRequest);
        String prefix = extractPrefix(context.getViewer(), offset);

        // TODO special case if root -> propose extension

        ExtensionPointNodeResolver extensionPointNodeResolver = new ExtensionPointNodeResolver();
        extensionPointNodeResolver.resolve(nodePath, context);
        IType nodeDescriptorType = extensionPointNodeResolver.getNodeDescriptorType();
        String currentNodePath = extensionPointNodeResolver.getCurrentNodePath();
        List<IType> descriptorCandidate = extensionPointNodeResolver.getDescriptorCandidates();

        if (descriptorCandidate != null) {
            for (IType iType : descriptorCandidate) {
                // get the xobject field of each type
                IAnnotation xobjectAnnotation = iType.getAnnotation(XOBJECT);

                if (xobjectAnnotation == null || !xobjectAnnotation.exists()) {
                    continue;
                }
                String xobjectName = getAnnotationValue(xobjectAnnotation);

                contentAssistRequest.addProposal(new CompletionProposal(
                        xobjectName, offset - prefix.length(), prefix.length(),
                        xobjectName.length(),
                        SDKPlugin.getDefault().getImageRegistry().get(
                                "icons/comp/xpoint.gif"), xobjectName, null,
                        null));
            }
            return;
        }
        if (nodeDescriptorType != null) {
            // propose the current object attribute

            IField[] fields;
            try {
                fields = nodeDescriptorType.getFields();
            } catch (JavaModelException e) {
                SDKPlugin.log(
                        IStatus.WARNING,
                        "exception while trying to get fields from the node type descriptor",
                        e);
                return;
            }
            for (IField field : fields) {
                IAnnotation xnodeAnnotation = field.getAnnotation(XNODE);
                if (xnodeAnnotation == null || !xnodeAnnotation.exists()) {
                    xnodeAnnotation = field.getAnnotation(XNODEMAP);
                }
                if (xnodeAnnotation == null || !xnodeAnnotation.exists()) {
                    xnodeAnnotation = field.getAnnotation(XNODELIST);
                }
                if (xnodeAnnotation == null || !xnodeAnnotation.exists()) {
                    continue;
                }

                if (xnodeAnnotation != null) {
                    String elementName = getAnnotationValue(xnodeAnnotation);

                    // specific completion proposal for attribute name
                    if (elementName == null) {
                        continue;
                    }
                    if (currentNodePath != null
                            && !elementName.startsWith(currentNodePath)) {
                        continue;
                    }
                    elementName = currentNodePath == null ? elementName
                            : elementName.substring(currentNodePath.length());
                    if (elementName.toLowerCase().contains(prefix.toLowerCase())
                            && !elementName.startsWith("@")) {
                        CompletionProposal newProposal;
                        try {
                            newProposal = new CompletionProposal(
                                    elementName,
                                    offset - prefix.length(),
                                    prefix.length(),
                                    elementName.length(),
                                    SDKPlugin.getDefault().getImageRegistry().get(
                                            "icons/comp/xpoint.gif"),
                                    elementName, null,
                                    field.getAttachedJavadoc(null));
                            contentAssistRequest.addProposal(newProposal);
                        } catch (JavaModelException e) {
                            SDKPlugin.log(
                                    IStatus.ERROR,
                                    "An error occured while generating xpoints completion proposal",
                                    e);
                        }
                    }
                }

            }

        }

    }

    protected int getOffset(CompletionProposalInvocationContext context) {
        int offset = context.getInvocationOffset();
        ITextViewer viewer = context.getViewer();
        ITextSelection selection = (ITextSelection) viewer.getSelectionProvider().getSelection();

        // adjust offset to end of normalized selection
        if (selection.getOffset() == offset) {
            offset = selection.getOffset() + selection.getLength();
        }
        return offset;
    }

    protected ITextSelection getSelection(
            CompletionProposalInvocationContext context) {
        ITextViewer viewer = context.getViewer();
        return (ITextSelection) viewer.getSelectionProvider().getSelection();
    }

    protected List<Node> getNodePath(ContentAssistRequest contentAssistRequest) {
        Node tmpNode = contentAssistRequest.getNode();
        List<Node> nodePath = new ArrayList<Node>();
        if (tmpNode.getNodeType() != Node.TEXT_NODE) {
            nodePath.add(tmpNode);
        }
        while (tmpNode.getParentNode() != null) {
            tmpNode = tmpNode.getParentNode();
            nodePath.add(tmpNode);
        }
        Collections.reverse(nodePath);
        return nodePath;
    }

    // copied from
    // org.eclipse.jface.text.templates.TemplateCompletionProcessor.extractPrefix(ITextViewer,
    // int)
    protected String extractPrefix(ITextViewer viewer, int offset) {
        int i = offset;
        IDocument document = viewer.getDocument();
        if (i > document.getLength()) {
            return ""; //$NON-NLS-1$
        }

        try {
            while (i > 0) {
                char ch = document.getChar(i - 1);
                if (!Character.isJavaIdentifierPart(ch)) {
                    break;
                }
                i--;
            }

            return document.get(i, offset - i);
        } catch (BadLocationException e) {
            return ""; //$NON-NLS-1$
        }
    }

    protected String getAnnotationValue(IAnnotation xnodeAnnotation) {
        return getAnnotationValue(xnodeAnnotation, "value");
    }

    protected String getAnnotationValue(IAnnotation xnodeAnnotation,
            String memberName) {
        IMemberValuePair[] memberValuePairs;
        try {
            memberValuePairs = xnodeAnnotation.getMemberValuePairs();
        } catch (JavaModelException e) {
            SDKPlugin.log(IStatus.ERROR,
                    "Couldn't get member value pairs for annotation"
                            + xnodeAnnotation, e);
            return null;
        }
        for (IMemberValuePair member : memberValuePairs) {
            if (memberName.equals(member.getMemberName())) {
                return (String) member.getValue();
            }
        }
        return null;
    }

    protected IJavaProject getJavaProjectForDocument(IDocument document) {
        IStructuredModel model = StructuredModelManager.getModelManager().getExistingModelForRead(
                document);
        if (model == null) {
            return null;
        }
        Path path = new Path(model.getBaseLocation());
        IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
        if (!file.exists()) {
            return null;
        }

        IProject project = file.getProject();
        if (project != null) {
            IJavaProject javaProject = JavaCore.create(project);
            if (javaProject != null && !javaProject.exists()) {
                return null;
            }
            return javaProject;
        }
        return null;

    }
}
