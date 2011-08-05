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
package org.nuxeo.ide.sdk;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import jdbm.RecordManager;
import jdbm.RecordManagerFactory;
import jdbm.RecordManagerOptions;
import jdbm.btree.BTree;
import jdbm.helper.StringComparator;
import jdbm.helper.Tuple;
import jdbm.helper.TupleBrowser;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class Index {

    public static final String DB_NAME = "/Users/bstefanescu/tmp/NuxeoSDK";

    /**
     * classname -> jarName/groupId:artifactId:version/symbolicName#version
     */
    public static final String CLASSES_BTREE_NAME = "classes";

    /**
     * symbolicName#version -> groupId:artifactId:version
     */
    public static final String BUNDLES_BTREE_NAME = "bundles";

    /**
     * groupId:artifactId -> symbolicName#version
     */
    public static final String ARTIFACTS_BTREE_NAME = "artifacts";

    protected RecordManager recman;

    protected BTree tree;

    public void open() throws IOException {
        Properties props = new Properties();
        props.setProperty(RecordManagerOptions.DISABLE_TRANSACTIONS, "true");
        recman = RecordManagerFactory.createRecordManager(DB_NAME, props);
        // try to reload an existing B+Tree
        long recid = recman.getNamedObject(CLASSES_BTREE_NAME);
        if (recid != 0) {
            tree = BTree.load(recman, recid);
            System.out.println("Reloaded existing BTree with " + tree.size()
                    + " NuxeoSDK index.");
        } else {
            // create a new B+Tree data structure and use a StringComparator
            // to order the records based on package names.
            tree = BTree.createInstance(recman, new StringComparator());
            recman.setNamedObject(CLASSES_BTREE_NAME, tree.getRecid());
            System.out.println("Created a new empty BTree");

            // build index
            // insert people with their respective occupation
            System.out.println("Building the index");
            buildIndex(tree);

            // make the data persistent in the database
            recman.commit();

        }

    }

    protected void buildIndex(BTree tree) throws IOException {
        File[] roots = new File[2];
        roots[0] = new File(
                "/Users/bstefanescu/work/nuxeo/nuxeo-distribution/nuxeo-distribution-tomcat/target/nuxeo-dm-5.4.3-SNAPSHOT-tomcat/nxserver/bundles");
        roots[1] = new File(
                "/Users/bstefanescu/work/nuxeo/nuxeo-distribution/nuxeo-distribution-tomcat/target/nuxeo-dm-5.4.3-SNAPSHOT-tomcat/nxserver/lib");
        Map<String, String> map = NuxeoSDK.buildIndex(roots);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            tree.insert(entry.getKey(), entry.getValue(), false);
        }
    }

    public String getClassEntry(String className) throws IOException {
        return (String) tree.find(className);
    }

    public String getPackageEntry(String prefix) throws IOException {
        Tuple tuple = tree.findGreaterOrEqual(prefix);
        if (tuple == null) {
            return null;
        }
        System.out.println("found: " + tuple.getKey());
        return (String) tuple.getValue();
    }

    public List<String> getPackageEntries(String prefix) throws IOException {
        ArrayList<String> result = new ArrayList<String>();
        TupleBrowser browser = tree.browse(prefix);
        Tuple tuple = new Tuple();
        while (browser.getNext(tuple)) {
            result.add((String) tuple.getValue());
        }
        return result;
    }

    public static void main(String[] args) throws IOException {

        Index index = new Index();

        index.open();

        System.out.println(index.getPackageEntry("org.nuxeo.runtime.api"));
        System.out.println(index.getClassEntry("org.nuxeo.runtime.api.Framework"));
        // System.out.println(">> "
        // + index.getClassEntry("org.nuxeo.runtime.api.Framework"));
        // System.out.println(index.getPackageEntries("org.nuxeo.runtime.api"));

    }
}
