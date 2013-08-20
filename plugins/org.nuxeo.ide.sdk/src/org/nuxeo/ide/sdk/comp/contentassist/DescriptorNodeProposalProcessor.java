package org.nuxeo.ide.sdk.comp.contentassist;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jdt.core.IAnnotation;
import org.eclipse.jdt.core.IMemberValuePair;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.nuxeo.ide.sdk.SDKPlugin;
import org.w3c.dom.Node;

public class DescriptorNodeProposalProcessor {

    /**
     * get one of the types that is matching with the current node by checking
     * xmap annotation
     *
     * @param descriptorCandidates
     * @param currentNode
     * @return
     */
    public IType findMatchingDescriptorType(List<IType> descriptorCandidates,
            Node currentNode) {
        for (IType type : descriptorCandidates) {
            if (isMatchingDescriptorType(type, currentNode)) {
                return type;
            }
        }
        return null;
    }

    /**
     * Check if the type is matching with the current node by checking its xmap
     * annotation
     *
     * @param type
     * @param currentNode
     * @return
     */
    public boolean isMatchingDescriptorType(IType type, Node currentNode) {
        try {

            IAnnotation[] annotations = type.getAnnotations();
            for (IAnnotation iAnnotation : annotations) {

                if (NuxeoXmlComponentProposalComputer.XOBJECT.equals(iAnnotation.getElementName())) {
                    String elementName = null;
                    IMemberValuePair[] memberValuePairs = iAnnotation.getMemberValuePairs();
                    for (IMemberValuePair member : memberValuePairs) {
                        if ("value".equals(member.getMemberName())) {
                            elementName = (String) member.getValue();
                            break;
                        }
                    }
                    if (currentNode.getNodeName().equals(elementName)) {
                        // TODO get the new descriptorCandidates
                        return true;
                    }

                }

            }
        } catch (JavaModelException e) {
            SDKPlugin.log(IStatus.ERROR,
                    "An error occured while parsing the type xmap annotation",
                    e);
        }
        return false;
    }

}
