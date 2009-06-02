/*
 * (C) Copyright 2009 Nuxeo SA (http://nuxeo.com/) and contributors.
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
 *     stan
 */
package org.nuxeo.ide.archetype;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Command line project generator base on templates (archetype)
 *
 * @author stan
 *
 */
public class CommandLineArchetype {

    static boolean batchMode = false;

    /**
     * @param args
     */
    public static void main(String[] args) {

        if (args.length == 0) {
            System.err.println("Syntax Error: you must specify a project template name");
        }
        int k = 0;
        String tpl = args[k];
        if ("-b".equals(tpl)) {
            batchMode = true;
            if (args.length < 2) {
                System.err.println("Syntax Error: you must specify a project template name");
            }
            tpl = args[++k];
        }
        k++;
        String outDir = null;

        if (args.length > k) {
            outDir = args[k];
        }
        k++;

        Archetype archetype = new Archetype();

        File zipFile = null;
        try {
            // TODO may be refactor again
            zipFile = archetype.setArchiveFile(new File(tpl));
            archetype.loadDocFromZip(zipFile);

        } catch (Exception e) {
            System.err.println("An error occured while loading template archetype file");
            e.printStackTrace();
            System.exit(1);
        }

        Map<String, String> values = new HashMap<String, String>();

        // getArchetype
        List<ArchetypeVar> archetypeVars = archetype.getAvailableVars(values);

        // get values from the user
        if (!batchMode) {
            for (ArchetypeVar var : archetypeVars) {
                try {
                    String value = readVar(var.getName(), var.getDefaultValue());
                    values.put(var.getName(), value);
                } catch (IOException e) {
                    System.err.println("An error occured while getting value of "
                            + var.getName() + ", exiting ...");
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }

        // process it
        try {
            archetype.doProcess(values, outDir);
        } catch (Exception e) {
            System.err.println("An error occured while processing the data, exiting ...");
            e.printStackTrace();
        }

    }

    public static String readVar(String key, String value) throws IOException {
        System.out.print(key + (value == null ? ": " : " [" + value + "]: "));
        StringBuilder buf = new StringBuilder();
        int c = System.in.read();
        LOOP: while (c != -1) {
            if (c == '\n' || c == '\r') {
                if (buf.length() == 0) {
                    if (value == null) {
                        System.out.println(key
                                + (value == null ? ": " : " [" + value + "]: "));
                        break LOOP;
                    } else {
                        return value;
                    }
                }
                return buf.toString();
            }
            buf.append((char) c);
            c = System.in.read();
        }
        return value;
    }

}
