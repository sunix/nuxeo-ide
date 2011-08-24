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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class StringUtils {

    public static String join(String[] ar, String sep) {
        if (ar == null || ar.length == 0) {
            return null;
        }
        if (ar.length == 1) {
            return ar[0];
        }
        StringBuilder buf = new StringBuilder();
        buf.append(ar[0]);
        for (int i = 1; i < ar.length; i++) {
            buf.append(sep).append(ar[i]);
        }
        return buf.toString();
    }

    public static String join(String[] ar, char sep) {
        if (ar == null || ar.length == 0) {
            return null;
        }
        if (ar.length == 1) {
            return ar[0];
        }
        StringBuilder buf = new StringBuilder();
        buf.append(ar[0]);
        for (int i = 1; i < ar.length; i++) {
            buf.append(sep).append(ar[i]);
        }
        return buf.toString();
    }

    public static String join(List<String> list, String sep) {
        if (list == null || list.size() == 0) {
            return null;
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        StringBuilder buf = new StringBuilder();
        buf.append(list.get(0));
        for (int i = 1, len = list.size(); i < len; i++) {
            buf.append(sep).append(list.get(i));
        }
        return buf.toString();
    }

    public static String join(List<String> list, char sep) {
        if (list == null || list.size() == 0) {
            return null;
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        StringBuilder buf = new StringBuilder();
        buf.append(list.get(0));
        for (int i = 1, len = list.size(); i < len; i++) {
            buf.append(sep).append(list.get(i));
        }
        return buf.toString();
    }

    public static String join(Set<String> list, String sep) {
        if (list == null || list.size() == 0) {
            return null;
        }
        if (list.size() == 1) {
            return list.iterator().next();
        }
        StringBuilder buf = new StringBuilder();
        Iterator<String> it = list.iterator();
        buf.append(it.next());
        while (it.hasNext()) {
            buf.append(sep).append(it.next());
        }
        return buf.toString();
    }

    public static String join(Set<String> list, char sep) {
        if (list == null || list.size() == 0) {
            return null;
        }
        if (list.size() == 1) {
            return list.iterator().next();
        }
        StringBuilder buf = new StringBuilder();
        Iterator<String> it = list.iterator();
        buf.append(it.next());
        while (it.hasNext()) {
            buf.append(sep).append(it.next());
        }
        return buf.toString();
    }

    public static String[] split(String s, char sep) {
        List<String> result = splitAsList(s, sep);
        return result.toArray(new String[result.size()]);
    }

    public static String[] split(String s, char sep, boolean trim) {
        List<String> result = splitAsList(s, sep, trim);
        return result.toArray(new String[result.size()]);
    }

    public static List<String> splitAsList(String s, char sep) {
        return splitAsList(s, sep, false);
    }

    public static List<String> splitAsList(String s, char sep, boolean trim) {
        ArrayList<String> result = new ArrayList<String>();
        int i = 0, j = -1;
        while (true) {
            j = s.indexOf(sep, i);
            if (j == -1) {
                String el = i == 0 ? s : s.substring(i);
                if (trim)
                    el = el.trim();
                result.add(trim ? el.trim() : el);
                break;
            } else {
                String el = s.substring(i, j);
                result.add(trim ? el.trim() : el);
                i = j + 1;
            }
        }
        return result;
    }

}
