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
import org.eclipse.jdt.core.dom.ArrayInitializer;
import org.eclipse.jdt.core.dom.BooleanLiteral;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.IExtendedModifier;
import org.eclipse.jdt.core.dom.MemberValuePair;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.NumberLiteral;
import org.eclipse.jdt.core.dom.PrimitiveType;
import org.eclipse.jdt.core.dom.QualifiedName;
import org.eclipse.jdt.core.dom.SimpleType;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.StringLiteral;
import org.eclipse.jdt.core.dom.Type;
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
        @SuppressWarnings({ "unchecked" })
        public boolean visit(TypeDeclaration node) {
            List<IExtendedModifier> mods = node.modifiers();
            for (IExtendedModifier m : mods) {
                if (m instanceof NormalAnnotation) {
                    NormalAnnotation anno = (NormalAnnotation) m;
                    if (!"Operation".equals(anno.getTypeName().getFullyQualifiedName())) {
                        continue;
                    }
                    List<MemberValuePair> attrs = (List<MemberValuePair>) anno.values();
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

            // build signature
            MethodDeclaration[] methods = node.getMethods();
            ArrayList<String> sig = new ArrayList<String>();
            for (MethodDeclaration method : methods) {
                mods = method.modifiers();
                for (IExtendedModifier m : mods) {
                    if (m instanceof NormalAnnotation) {
                        NormalAnnotation anno = (NormalAnnotation) m;
                        if (!"OperationMethod".equals(anno.getTypeName().getFullyQualifiedName())) {
                            continue;
                        }

                        List<SingleVariableDeclaration> params = method.parameters();
                        if (params.size() > 1) {
                            // invalid operation - ignore
                            continue;
                        }
                        String out = getTypeSignature(method.getReturnType2());
                        String in = params.isEmpty() ? "void"
                                : getTypeSignature(params.get(0).getType());
                        sig.add(in);
                        sig.add(out);
                    }
                }
            }
            op.signature = sig.toArray(new String[sig.size()]);

            // build params
            FieldDeclaration[] fields = node.getFields();

            for (FieldDeclaration field : fields) {
                mods = field.modifiers();
                for (IExtendedModifier m : mods) {
                    if (m instanceof NormalAnnotation) {
                        NormalAnnotation anno = (NormalAnnotation) m;
                        if ("Param".equals(anno.getTypeName().getFullyQualifiedName())) {
                            OperationModel.Param param = new OperationModel.Param();
                            param.setType(getTypeSignature(field.getType()));
                            List<MemberValuePair> attrs = (List<MemberValuePair>) anno.values();
                            for (MemberValuePair attr : attrs) {
                                String key = attr.getName().getFullyQualifiedName();
                                Expression expr = attr.getValue();
                                if ("name".equals(key)) {
                                    param.setName(((StringLiteral) expr).getLiteralValue());
                                } else if ("required".equals(key)) {
                                    param.setRequired(((BooleanLiteral) expr).booleanValue());
                                } else if ("widget".equals(key)) {
                                    param.setWidget(((StringLiteral) expr).getLiteralValue());
                                } else if ("values".equals(key)) {
                                    List<Expression> values = ((ArrayInitializer) expr).expressions();
                                    if (!values.isEmpty()) {
                                        ArrayList<String> vlist = new ArrayList<String>();
                                        for (Expression v : values) {
                                            vlist.add(((StringLiteral) v).getLiteralValue());
                                        }
                                        param.setValues(vlist.toArray(new String[vlist.size()]));
                                    }
                                } else if ("order".equals(key)) {
                                    param.setOrder(Integer.parseInt(((NumberLiteral) expr).getToken()));
                                }
                            }
                            op.addParam(param);
                        }
                    }
                }
            }

            return false;
        }

        public String getTypeSignature(Type type) {
            if (type.isSimpleType()) {
                SimpleType stype = (SimpleType) type;
                String name = stype.getName().getFullyQualifiedName();
                if ("DocumentModel".equals(name) || "DocumentRef".equals(name)) {
                    return "doc";
                } else if ("Blob".equals(name)) {
                    return "blob";
                } else if ("DocumentModelList".equals(name)
                        || "DocumentRefList".equals(name)) {
                    return "docs";
                } else if ("BlobList".equals(name)) {
                    return "blobs";
                }
            } else if (type.isPrimitiveType()) {
                if (((PrimitiveType) type).getPrimitiveTypeCode() == PrimitiveType.VOID) {
                    return "void";
                }
            }
            return "object";
        }

    }

}
