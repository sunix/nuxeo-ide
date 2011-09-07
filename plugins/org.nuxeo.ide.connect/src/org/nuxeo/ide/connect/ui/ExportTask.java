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
package org.nuxeo.ide.connect.ui;

import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.util.DefaultPrettyPrinter;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.connect.Connector;
import org.nuxeo.ide.connect.OperationModel;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class ExportTask implements IRunnableWithProgress {

    protected String projectId;

    protected OperationModel[] ops;

    public ExportTask(String projectId, OperationModel[] ops) {
        this.projectId = projectId;
        this.ops = ops;
    }

    @Override
    public void run(IProgressMonitor monitor) throws InvocationTargetException,
            InterruptedException {
        try {
            monitor.beginTask("Generate JSON registries", 1);
            String reg = writeRegistry(ops);
            monitor.worked(1);
            if (monitor.isCanceled()) {
                return;
            }
            monitor.beginTask("Export registries to " + projectId, 1);
            Connector.getDefault().exportOperationRegistry(projectId, reg);
            monitor.worked(1);
        } catch (Exception e) {
            UI.showError("Failed to export operations", e);
        } finally {
            monitor.done();
        }
    }

    public static String writeRegistry(OperationModel[] ops) throws Exception {
        StringWriter out = new StringWriter();
        JsonGenerator jg = new JsonFactory().createJsonGenerator(out);
        jg.setPrettyPrinter(new DefaultPrettyPrinter());
        writeOperations(ops, jg);
        jg.flush();
        return out.getBuffer().toString();
    }

    public static void writeOperations(OperationModel[] ops, JsonGenerator jg)
            throws Exception {
        jg.writeStartObject();
        jg.writeArrayFieldStart("operations");
        for (OperationModel op : ops) {
            writeOperation(op, jg);
        }
        jg.writeEndArray();
        jg.writeEndObject();
    }

    public static void writeOperation(OperationModel op, JsonGenerator jg)
            throws Exception {
        jg.writeStartObject();
        jg.writeObjectField("id", op.getId());
        jg.writeObjectField("label", op.getLabel());
        jg.writeObjectField("category", op.getCategory());
        jg.writeObjectField("description", op.getDescription());
        jg.writeObjectField("url", op.getId());
        jg.writeObjectField("requires", op.getRequires());
        writeSignature(op, jg);
        writeParams(op, jg);
        jg.writeEndObject();
    }

    private static void writeSignature(OperationModel op, JsonGenerator jg)
            throws Exception {
        jg.writeArrayFieldStart("signature");
        for (String sig : op.getSignature()) {
            jg.writeString(sig);
        }
        jg.writeEndArray();
    }

    private static void writeParams(OperationModel op, JsonGenerator jg)
            throws Exception {
        jg.writeArrayFieldStart("params");
        for (OperationModel.Param param : op.getParams()) {
            writeParam(param, jg);
        }
        jg.writeEndArray();
    }

    private static void writeParam(OperationModel.Param param, JsonGenerator jg)
            throws Exception {
        jg.writeStartObject();
        jg.writeObjectField("name", param.getName());
        jg.writeObjectField("type", param.getType());
        jg.writeObjectField("required", param.isRequired());
        jg.writeObjectField("order", param.getOrder());
        jg.writeObjectField("widget", param.getWidget());
        jg.writeArrayFieldStart("values");
        for (String v : param.getValues()) {
            jg.writeString(v);
        }
        jg.writeEndArray();
        jg.writeEndObject();
    }

}
