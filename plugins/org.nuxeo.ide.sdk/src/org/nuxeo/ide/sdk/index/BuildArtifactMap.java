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
package org.nuxeo.ide.sdk.index;

import java.io.File;
import java.io.FilenameFilter;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class BuildArtifactMap {

    public static void main(String[] args) throws Exception {
        File repo = new File("/Users/bstefanescu/.m2/repository");
        Map<String, File> index = indexRepo(repo);
        File dist = new File(
                "/Users/bstefanescu/work/nuxeo/nuxeo-distribution/nuxeo-distribution-tomcat/target/nuxeo-dm-5.4.3-SNAPSHOT-tomcat");
        File bundles = new File(dist, "nxserver/bundles");
        File libs = new File(dist, "nxserver/lib");
        File[] list1 = getJars(bundles);
        File[] list2 = getJars(libs);
        File[] jars = new File[list1.length + list2.length];
        System.arraycopy(list1, 0, jars, 0, list1.length);
        System.arraycopy(list2, 0, jars, list1.length, list2.length);
        TreeMap<String, String> gav = new TreeMap<String, String>();
        TreeMap<String, String> ga = new TreeMap<String, String>();
        String rp = repo.getAbsolutePath() + "/";
        int rplen = rp.length();
        for (File f : jars) {
            String name = f.getName();
            File file = index.get(name);
            if (file != null) {
                gav.put(name, getGav(file, rplen));
                ga.put(getArtifactIdFromJar(name), getGa(file, rplen));
            } else {
                System.out.println(">>>> NOT FOUND: " + name);
            }
        }
        writeMap(gav, System.out);
        System.out.println("==================");
        writeMap(ga, System.out);
    }

    static Map<String, File> indexRepo(File repo) {
        HashMap<String, File> index = new HashMap<String, File>();
        indexRepo(repo, index);
        return index;
    }

    static void indexRepo(File root, Map<String, File> index) {
        if (root.getName().equals("gwt-dev")) {
            return;
        }
        File[] files = root.listFiles();
        if (files == null) {
            System.out.println(">>>>>>>>>>> NULL:" + root);
            return;
        }
        for (File f : files) {
            if (f.isDirectory()) {
                indexRepo(f, index);
            } else {
                String name = f.getName();
                if (name.endsWith(".pom")) {
                    name = name.substring(0, name.length() - 4) + ".jar";
                    index.put(name, root);
                }
            }
        }
    }

    static void writeMap(Map<String, String> map, PrintStream out) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            out.print(entry.getKey());
            out.print("=");
            out.println(entry.getValue());
        }
        out.flush();
    }

    static File[] getJars(File dir) {
        return dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".jar");
            }
        });
    }

    static File findFile(File repo, String name) {
        File[] files = repo.listFiles();
        if (files == null) {
            return null;
        }
        for (File f : files) {
            if (f.isDirectory()) {
                File result = findFile(f, name);
                if (result != null) {
                    return result;
                }
            } else {
                if (f.getName().equals(name)) {
                    return f;
                }
            }
        }
        return null;
    }

    static String getGav(File file, int prefixlen) {
        File artDir = file.getParentFile();
        File grpDir = artDir.getParentFile();
        String groupId = grpDir.getAbsolutePath().substring(prefixlen).replace(
                '/', '.');
        String artifactId = artDir.getName();
        String version = file.getName();
        return new StringBuilder().append(groupId).append(':').append(
                artifactId).append(':').append(version).toString();
    }

    static String getGa(File file, int prefixlen) {
        File artDir = file.getParentFile();
        File grpDir = artDir.getParentFile();
        String groupId = grpDir.getAbsolutePath().substring(prefixlen).replace(
                '/', '.');
        String artifactId = artDir.getName();
        return new StringBuilder().append(groupId).append(':').append(
                artifactId).toString();
    }

    private static Pattern V = Pattern.compile("\\-[0-9]+");

    public static String getArtifactIdFromJar(String jarName) {
        Matcher m = V.matcher(jarName);
        if (m.find()) {
            int i = m.start();
            return jarName.substring(0, i);
        } else {
            System.out.println(">>> Invalid jar name: " + jarName);
        }
        return jarName;
    }

    static String findGav(File repo, String name) {
        String rp = repo.getAbsolutePath();
        int len = rp.length();
        File file = findFile(repo, name);
        if (file != null) {
            String p = file.getParentFile().getAbsolutePath();
            return p.substring(len);
        } else {
            System.out.println("!!! Not found: " + name);
            return null;
        }
    }
}
