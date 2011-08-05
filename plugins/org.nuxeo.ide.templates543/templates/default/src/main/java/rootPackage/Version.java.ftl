/*
 * Copyright (c) 2006-2011 Nuxeo SA (http://nuxeo.com/) and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     bstefanescu
 */
package ${rootPackage};

/**
 * An artifact version as specified by OSGi 
 * 
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 *
 */
public class Version implements Comparable<Version> {

    public static final Version ANY = new Version(0);
    
    public static Version parse(String expr) {
        int i = 0;
        int eq = expr.indexOf('.');
        if (eq == -1) {
            return new Version(Integer.parseInt(expr));
        }
        int major = Integer.parseInt(expr.substring(i, eq));
        i = eq + 1;
        eq = expr.indexOf('.', i);
        if (eq == -1) {
            return new Version(major, Integer.parseInt(expr.substring(i)));
        }
        int minor = Integer.parseInt(expr.substring(i, eq));
        i = eq + 1;
        eq = expr.indexOf('.', i);
        if (eq == -1) {
            return new Version(major, minor, Integer.parseInt(expr.substring(i)));
        }
        int micro = Integer.parseInt(expr.substring(i, eq));
        return new Version(major, minor, micro, expr.substring(eq+1));
    }

    protected final int major;
    protected final int minor;
    protected final int micro;
    protected final String qualifier;

    public Version(int major) {
        this (major, 0, 0, null);
    }

    public Version(int major, int minor) {
        this (major, minor, 0, null);
    }

    public Version(int major, int minor, int micro) {
        this (major, minor, micro, null);
    }
    
    public Version(int major, int minor, int micro, String qualifier) {
        this.major = major;
        this.minor = minor;
        this.micro = micro;
        this.qualifier = qualifier == null ? "" : qualifier;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder(32);
        buf.append(major).append('.').append(minor).append('.').append(micro);
        if (qualifier.length() > 0) {
            buf.append('.').append(qualifier);
        }
        return buf.toString();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Version) {
            return compareTo((Version)obj) == 0;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (major << 24) + (minor << 16) + (micro << 8) 
            + qualifier.hashCode();
    }
    
    public int compareTo(Version v) {
        if (this == v) {
            return 0;
        }
        int i = major - v.major;
        if (i != 0) {
            return i;
        }
        i = minor - v.minor;
        if (i != 0) {
            return i;
        }
        i = micro - v.micro;
        if (i != 0) {
            return i;
        }
        return qualifier.compareTo(v.qualifier);
    }
    
    public static void main(String[] args) throws Exception {
        Version v0 = Version.parse("0.0.0");
        Version v1 = Version.parse("1");
        Version v2 = Version.parse("1.0");
        Version v3 = Version.parse("1.0.0");
        Version v4 = Version.parse("2.1.0");
        Version v5 = Version.parse("2.1.0.test");
        System.out.println(v0);
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(v4);
        System.out.println(v5);
        
        System.out.println(v0.compareTo(v1));
        System.out.println(v1.compareTo(v2));
        System.out.println(v2.compareTo(v3));
        System.out.println(v3.compareTo(v4));
        System.out.println(v4.compareTo(v5));
    }
    
}
