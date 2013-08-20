package org.nuxeo.ide.sdk.comp.contentassist;

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
import org.eclipse.jdt.core.Signature;
import org.eclipse.jface.text.IDocument;
import org.eclipse.wst.sse.core.StructuredModelManager;
import org.eclipse.wst.sse.core.internal.provisional.IStructuredModel;
import org.eclipse.wst.sse.ui.contentassist.CompletionProposalInvocationContext;
import org.nuxeo.ide.sdk.SDKPlugin;
import org.w3c.dom.Node;

@SuppressWarnings("restriction")
public class ExtensionPointNodeResolver {

    IType nodeDescriptorType = null;

    String currentNodePath = null;

    List<IType> descriptorCandidates = null;

    public void resolve(List<Node> nodePath,
            CompletionProposalInvocationContext context) {
        descriptorCandidates = null;
        nodeDescriptorType = null;
        currentNodePath = null;

        // this will need to be improve, to allow node fast forward
        loop: for (Node currentNode : nodePath) {

            if ("extension".equals(currentNode.getNodeName())) {
                ExtensionProposalProcessor extensionProposalProcessor = new ExtensionProposalProcessor(
                        context);
                descriptorCandidates = extensionProposalProcessor.getDescriptorCandidates(currentNode);
                continue;
            }

            if (descriptorCandidates != null && !descriptorCandidates.isEmpty()) {
                DescriptorNodeProposalProcessor descriptorNodeProposalProcessor = new DescriptorNodeProposalProcessor();
                nodeDescriptorType = descriptorNodeProposalProcessor.findMatchingDescriptorType(
                        descriptorCandidates, currentNode);
                // so the next node, we don't get into this
                descriptorCandidates = null;
            }

            if (nodeDescriptorType != null) {
                if (currentNodePath == null) {
                    currentNodePath = "";
                } else if (currentNodePath.equals("")) {
                    currentNodePath = currentNode.getNodeName();
                } else {
                    currentNodePath = currentNodePath + "/"
                            + currentNode.getNodeName();
                }
                // for all fields and methods that has the XNode, XNodeList and
                // XNodeMap annotations
                try {
                    IField[] fields = nodeDescriptorType.getFields();
                    for (IField field : fields) {
                        IAnnotation xnodeAnnotation = field.getAnnotation(NuxeoXmlComponentProposalComputer.XNODE);
                        if (xnodeAnnotation == null
                                || !xnodeAnnotation.exists()) {
                            xnodeAnnotation = field.getAnnotation(NuxeoXmlComponentProposalComputer.XNODEMAP);
                        }
                        if (xnodeAnnotation == null
                                || !xnodeAnnotation.exists()) {
                            xnodeAnnotation = field.getAnnotation(NuxeoXmlComponentProposalComputer.XNODELIST);
                        }
                        if (xnodeAnnotation == null
                                || !xnodeAnnotation.exists()) {
                            continue;
                        }

                        // here we are trying to match the xpath extracted from
                        // the annotation value and the current node path.

                        // node1/node2 -> use the currentNodePath string to
                        // figure out the next current path node
                        // @ -> ignore
                        String xnodeAnnotationValue = getAnnotationValue(xnodeAnnotation);

                        if (xnodeAnnotationValue != null
                                && xnodeAnnotationValue.equals(currentNodePath)) {

                            // we have our new descriptor here or our element
                            // if descriptor,
                            // retrieve the type and set nodeDescriptorType,
                            // reset the other variable and ... go to the next
                            // node

                            String typeSignature = field.getTypeSignature();
                            // a better way to do ?
                            String newDescriptorTypeStr = Signature.getSignatureQualifier(typeSignature)
                                    + "."
                                    + Signature.getSignatureSimpleName(typeSignature);
                            IType newDescriptorType = getJavaProjectForDocument(
                                    context.getDocument()).findType(
                                    newDescriptorTypeStr);
                            if (newDescriptorType != null
                                    && newDescriptorType.getAnnotation(NuxeoXmlComponentProposalComputer.XOBJECT) != null) {
                                nodeDescriptorType = newDescriptorType;
                                currentNodePath = "";
                                continue loop;
                            }
                            // XNodeMap or XNodeList
                            String annotationValue = getAnnotationValue(
                                    xnodeAnnotation, "componentType");
                            if (annotationValue == null) {
                                continue loop;
                            }
                            newDescriptorType = getJavaProjectForDocument(
                                    context.getDocument()).findType(
                                    annotationValue);
                            if (newDescriptorType != null
                                    && newDescriptorType.getAnnotation(NuxeoXmlComponentProposalComputer.XOBJECT) != null) {
                                nodeDescriptorType = newDescriptorType;
                                currentNodePath = null;
                                continue loop;
                            }
                        }
                    }

                } catch (JavaModelException e) {
                    SDKPlugin.log(IStatus.ERROR,
                            "couldn't get fields for type "
                                    + nodeDescriptorType, e);
                }

            }

        }

    }

    public IType getNodeDescriptorType() {
        return nodeDescriptorType;
    }

    public String getCurrentNodePath() {
        return currentNodePath;
    }

    public List<IType> getDescriptorCandidates() {
        return descriptorCandidates;
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
