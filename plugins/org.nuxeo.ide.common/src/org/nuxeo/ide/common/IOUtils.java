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
package org.nuxeo.ide.common;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class IOUtils {

    private static final int BUFFER_SIZE = 1024 * 64; // 64K

    private static final int MAX_BUFFER_SIZE = 1024 * 1024; // 64K

    private static final int MIN_BUFFER_SIZE = 1024 * 8; // 64K

    /**
     * Copies recursively source to destination.
     * <p>
     * The source file is assumed to be a directory.
     * 
     * @param src the source directory
     * @param dst the destination directory
     * @throws IOException
     */
    public static void copyTree(File src, File dst) throws IOException {
        if (src.isFile()) {
            copyFile(src, dst);
        } else if (src.isDirectory()) {
            if (dst.exists()) {
                dst = new File(dst, src.getName());
                dst.mkdir();
            } else { // allows renaming dest dir
                dst.mkdirs();
            }
            File[] files = src.listFiles();
            for (File file : files) {
                copyTree(file, dst);
            }
        }
    }

    /**
     * Copy the files contained by 'src' directory into the destination 'dst'
     * directory. if destination directory doesn't exists it will be created.
     * 
     * If src is a file and not a directory then copy it inside the dst
     * directory.
     * 
     * @throws IOException
     */
    public static void copyTreeContent(File src, File dst) throws IOException {
        if (src.isFile()) {
            copyFile(src, dst);
        } else if (src.isDirectory()) {
            dst.mkdirs();
            File[] files = src.listFiles();
            for (File file : files) {
                copyTree(file, dst);
            }
        }
    }

    public static void copyFile(File src, File dst) throws IOException {
        if (dst.isDirectory()) {
            dst = new File(dst, src.getName());
        }
        FileInputStream in = null;
        FileOutputStream out = new FileOutputStream(dst);
        try {
            in = new FileInputStream(src);
            copy(in, out);
        } finally {
            if (in != null) {
                in.close();
            }
            out.close();
        }
    }

    public static void copy(InputStream in, OutputStream out)
            throws IOException {
        byte[] buffer = createBuffer(in.available());
        int read;
        while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }
    }

    public static void copyToFile(InputStream in, File file) throws IOException {
        OutputStream out = null;
        try {
            out = new FileOutputStream(file);
            byte[] buffer = createBuffer(in.available());
            int read;
            while ((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    private static byte[] createBuffer(int preferredSize) {
        if (preferredSize < 1) {
            preferredSize = BUFFER_SIZE;
        }
        if (preferredSize > MAX_BUFFER_SIZE) {
            preferredSize = MAX_BUFFER_SIZE;
        } else if (preferredSize < MIN_BUFFER_SIZE) {
            preferredSize = MIN_BUFFER_SIZE;
        }
        return new byte[preferredSize];
    }

    public static void unzip(InputStream zipStream, File dir)
            throws IOException {
        ZipInputStream in = null;
        try {
            in = new ZipInputStream(new BufferedInputStream(zipStream));
            unzip(in, dir);
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    public static void unzip(File zip, File dir) throws IOException {
        ZipInputStream in = null;
        try {
            in = new ZipInputStream(new BufferedInputStream(
                    new FileInputStream(zip)));
            unzip(in, dir);
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    public static void unzip(ZipInputStream in, File dir) throws IOException {
        dir.mkdirs();
        ZipEntry entry = in.getNextEntry();
        while (entry != null) {
            // System.out.println("Extracting "+entry.getName());
            File file = new File(dir, entry.getName());
            if (entry.isDirectory()) {
                file.mkdirs();
            } else {
                file.getParentFile().mkdirs();
                copyToFile(in, file);
            }
            entry = in.getNextEntry();
        }
    }

    public static void unzip(InputStream zipStream, String prefix, File dir)
            throws IOException {
        ZipInputStream in = null;
        try {
            in = new ZipInputStream(new BufferedInputStream(zipStream));
            unzip(in, prefix, dir);
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    public static void unzip(File zip, String prefix, File dir)
            throws IOException {
        ZipInputStream in = null;
        try {
            in = new ZipInputStream(new BufferedInputStream(
                    new FileInputStream(zip)));
            unzip(in, prefix, dir);
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    /**
     * If prefix ends in / the content of that directory is unziped - otherwise
     * the root directory will be also unziped.
     * 
     * @param in
     * @param prefix
     * @param dir
     * @throws IOException
     */
    public static void unzip(ZipInputStream in, String prefix, File dir)
            throws IOException {
        if (!prefix.endsWith("/")) {
            prefix = prefix.concat("/");
        }
        int prefixLen = prefix.length();
        dir.mkdirs();
        ZipEntry entry = in.getNextEntry();
        while (entry != null) {
            // System.out.println("Extracting "+entry.getName());
            String name = entry.getName();
            System.out.println("unzip: " + name + " ... Prefix is: " + prefix);
            if (name.length() > prefixLen && name.startsWith(prefix)) {
                name = name.substring(prefixLen);
                System.out.println("unzip OK: " + name);
                File file = new File(dir, name);
                if (entry.isDirectory()) {
                    file.mkdirs();
                } else {
                    file.getParentFile().mkdirs();
                    copyToFile(in, file);
                }
            } else {
                System.out.println("Unzip not OK");
            }
            entry = in.getNextEntry();
        }
    }

    public static void deleteTree(File root) {
        File[] files = root.listFiles();
        if (files != null) {
            for (File file : files) {
                deleteTree(file);
            }
        }
        root.delete();
    }

    public static File createTempDir(File root) throws IOException {
        File file = File.createTempFile("nuxeo-ide-", ".tmp", root);
        // TODO not atomic ...
        file.delete();
        file.mkdir();
        return file;
    }

    public static List<String> readLines(File file) throws IOException {
        List<String> lines = new ArrayList<String>();
        BufferedReader reader = null;
        try {
            InputStream in = new FileInputStream(file);
            reader = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                }
            }
        }
        return lines;
    }

    public static void writeLines(File file, List<String> lines)
            throws IOException {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileOutputStream(file));
            for (String line : lines) {
                out.println(line);
            }
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    public static String readFile(File file) throws IOException {
        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
            return read(in);
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    public static String read(URL url) throws IOException {
        InputStream in = url.openStream();
        try {
            return read(in);
        } finally {
            in.close();
        }
    }

    public static String read(InputStream in) throws IOException {
        StringBuilder sb = new StringBuilder();
        byte[] buffer = createBuffer(in.available());
        try {
            int read;
            while ((read = in.read(buffer)) != -1) {
                sb.append(new String(buffer, 0, read));
            }
        } finally {
            in.close();
        }
        return sb.toString();
    }

    public static void writeFile(File file, byte[] buf) throws IOException {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write(buf);
        } finally {
            if (fos != null) {
                fos.close();
            }
        }
    }

    public static void writeFile(File file, String buf) throws IOException {
        writeFile(file, buf.getBytes());
    }

    /**
     * Delete the given file then delete all its empty parents.
     * 
     * @param file
     */
    public static void deleteFilePath(File file) {
        file.delete();
        // delete empty hierarchy
        File dir = file.getParentFile();
        while (dir.delete()) {
            dir = dir.getParentFile();
        }
    }
}
