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
package org.nuxeo.ide.connect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.MemberValuePair;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.QualifiedName;
import org.eclipse.jdt.core.dom.StringLiteral;
import org.eclipse.jdt.core.dom.TypeDeclaration;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class OperationScanner {

    public static List<OperationModel> getOperations(IJavaProject project)
            throws Exception {
        List<OperationModel> result = new ArrayList<OperationModel>();
        for (IPackageFragmentRoot root : project.getPackageFragmentRoots()) {
            if (root.getKind() == IPackageFragmentRoot.K_SOURCE) {
                scanPackageRoot(root, result);
            }
        }
        return result;
    }

    protected static void scanPackageRoot(IPackageFragmentRoot root,
            Collection<OperationModel> result) throws Exception {
        for (Object pkg : root.getChildren()) {
            scanPackage((IPackageFragment) pkg, result);
        }
    }

    protected static void scanPackage(IPackageFragment pkg,
            Collection<OperationModel> result) throws Exception {
        for (ICompilationUnit unit : pkg.getCompilationUnits()) {
            OperationModel op = tryCompile(unit, null);
            if (op != null) {
                result.add(op);
            }
        }
    }

    /**
     * Get the operation model corresponding to the given compilation unit - if
     * any is found.
     * 
     * Try to compile the given compilation unit and return the corresponding
     * operation model if one is found. If the compilation unit doesn't contains
     * any operation - null is returned.
     * <p>
     * Note that the effective compilation is done only if the compilation unit
     * represents an operation.
     * 
     * @param unit
     * @return the operation model or null
     */
    public static OperationModel tryCompile(ICompilationUnit unit,
            IProgressMonitor monitor) throws JavaModelException {
        IType[] types = unit.getTypes();
        if (types.length == 0) {
            return null;
        }
        IType type = types[0];
        if (type.getAnnotation("Operation").exists()) {
            ASTNode node = compile(unit, monitor);
            OperationBuilder builder = new OperationBuilder(type);
            node.accept(builder);
            return builder.op;
        }
        return null;
    }

    public static ASTNode compile(ICompilationUnit unit,
            IProgressMonitor monitor) {
        ASTParser parser = ASTParser.newParser(AST.JLS3);
        parser.setResolveBindings(true);
        parser.setSource(unit);
        parser.setStatementsRecovery(true);
        parser.setBindingsRecovery(true);
        return parser.createAST(monitor);
    }

    static class OperationBuilder extends ASTVisitor {

        protected OperationModel op;

        public OperationBuilder(IType type) {
            op = new OperationModel(type);
        }

        @Override
        @SuppressWarnings({ "rawtypes", "unchecked" })
        public boolean visit(TypeDeclaration node) {
            List list = node.modifiers();
            for (Object m : list) {
                if (m instanceof NormalAnnotation) {
                    NormalAnnotation anno = (NormalAnnotation) m;
                    if (!"Operation".equals(anno.getTypeName().getFullyQualifiedName())) {
                        continue;
                    }
                    List<MemberValuePair> attrs = (List<MemberValuePair>) ((NormalAnnotation) m).values();
                    for (MemberValuePair attr : attrs) {
                        String key = attr.getName().getFullyQualifiedName();
                        String value = null;
                        Expression expr = attr.getValue();
                        if (expr instanceof StringLiteral) {
                            value = ((StringLiteral) expr).getLiteralValue();
                        } else if (expr instanceof QualifiedName) {
                            value = (String) ((QualifiedName) expr).resolveConstantExpressionValue();
                        }
                        op.properties.put(key, value);
                    }
                    break;
                }
            }
            return false;
        }

    }

}
