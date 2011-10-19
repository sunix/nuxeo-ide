#!/bin/bash

parseversiondetails() {
    IFS='.' read major minor micro
    echo $major $minor $micro
}

parseversion() {
    IFS='-' read version label
    echo $version | parseversiondetails 
    echo $label
    if [ $label = "SNAPSHOT" ]; then
      echo qualifier
    else
      echo $label
    fi
}

set -ex

set -- $1 $(mvn -N -o help:evaluate -Dexpression='project.version' | grep -v '^\[' | parseversion)

operation=$1
major=$2
minor=$3
micro=$4
mvn_label=$5
osgi_label=$6

previous_maven=${major}.${minor}.${micro}-${mvn_label}
previous_osgi=${major}.${minor}.${micro}.${osgi_label}

if [ $operation = release ]; then
  next_label=$(date "+v%Y%m%d_%H%M")
  next_maven=${major}.${minor}.${micro}-${next_label}
  next_osgi=${major}.${minor}.${micro}.${next_label}
elif [ $operation = after-release ]; then
  next_maven=${major}.${minor}.$((micro+1))-SNAPSHOT
  next_osgi=${major}.${minor}.$((micro+1)).qualifier
elif [ $operation = minor-branch]; then
  next_maven=${major}.$((minor+1)).0-${mvn_label}
  next_osgi=${major}.$((minor+1)).0.${osgi_label}
elif [ $operation = major-branch]; then
  next_maven=$((major+1)).0.0-${mvn_label}
  next_osgi=$((major+1)).0.0.${osgi_label}
fi

patch -p1 <<EOF 
diff -r b872b22ad3d5 -r 927d1d313a1d features/org.nuxeo.ide.sdk.feature/feature.xml
--- a/features/org.nuxeo.ide.sdk.feature/feature.xml	Sat Oct 01 00:57:16 2011 +0200
+++ b/features/org.nuxeo.ide.sdk.feature/feature.xml	Sat Oct 01 10:25:17 2011 +0200
@@ -2,7 +2,7 @@
 <feature
       id="org.nuxeo.ide.sdk"
       label="%featureName"
-      version="${previous_osgi}"
+      version="${next_osgi}"
       provider-name="%providerName"
       plugin="org.nuxeo.ide.sdk">
 
diff -r b872b22ad3d5 -r 927d1d313a1d features/org.nuxeo.ide.sdk.feature/pom.xml
--- a/features/org.nuxeo.ide.sdk.feature/pom.xml	Sat Oct 01 00:57:16 2011 +0200
+++ b/features/org.nuxeo.ide.sdk.feature/pom.xml	Sat Oct 01 10:25:17 2011 +0200
@@ -9,7 +9,7 @@
   <parent>
     <groupId>org.nuxeo.ide</groupId>
     <artifactId>org.nuxeo.ide.tycho</artifactId>
-    <version>${previous_maven}</version>
+    <version>${next_maven}</version>
     <relativePath>../..</relativePath>
   </parent>
 
diff -r b872b22ad3d5 -r 927d1d313a1d features/org.nuxeo.ide.shell.feature/feature.xml
--- a/features/org.nuxeo.ide.shell.feature/feature.xml	Sat Oct 01 00:57:16 2011 +0200
+++ b/features/org.nuxeo.ide.shell.feature/feature.xml	Sat Oct 01 10:25:17 2011 +0200
@@ -2,7 +2,7 @@
 <feature
       id="org.nuxeo.ide.shell"
       label="%featureName"
-      version="${previous_osgi}"
+      version="${next_osgi}"
       provider-name="%providerName">
 
    <description>
diff -r b872b22ad3d5 -r 927d1d313a1d features/org.nuxeo.ide.shell.feature/pom.xml
--- a/features/org.nuxeo.ide.shell.feature/pom.xml	Sat Oct 01 00:57:16 2011 +0200
+++ b/features/org.nuxeo.ide.shell.feature/pom.xml	Sat Oct 01 10:25:17 2011 +0200
@@ -9,7 +9,7 @@
   <parent>
     <groupId>org.nuxeo.ide</groupId>
     <artifactId>org.nuxeo.ide.tycho</artifactId>
-    <version>${previous_maven}</version>
+    <version>${next_maven}</version>
     <relativePath>../..</relativePath>
   </parent>
 
diff -r b872b22ad3d5 -r 927d1d313a1d plugins/org.nuxeo.ide.common/META-INF/MANIFEST.MF
--- a/plugins/org.nuxeo.ide.common/META-INF/MANIFEST.MF	Sat Oct 01 00:57:16 2011 +0200
+++ b/plugins/org.nuxeo.ide.common/META-INF/MANIFEST.MF	Sat Oct 01 10:25:17 2011 +0200
@@ -2,7 +2,7 @@
 Bundle-ManifestVersion: 2
 Bundle-Name: Nuxeo IDE Common
 Bundle-SymbolicName: org.nuxeo.ide.common;singleton:=true
-Bundle-Version: ${previous_osgi}
+Bundle-Version: ${next_osgi}
 Require-Bundle: org.eclipse.equinox.registry,
  org.eclipse.core.runtime,
  org.eclipse.core.resources,
diff -r b872b22ad3d5 -r 927d1d313a1d plugins/org.nuxeo.ide.common/pom.xml
--- a/plugins/org.nuxeo.ide.common/pom.xml	Sat Oct 01 00:57:16 2011 +0200
+++ b/plugins/org.nuxeo.ide.common/pom.xml	Sat Oct 01 10:25:17 2011 +0200
@@ -9,7 +9,7 @@
   <parent>
     <groupId>org.nuxeo.ide</groupId>
     <artifactId>org.nuxeo.ide.tycho</artifactId>
-    <version>${previous_maven}</version>
+    <version>${next_maven}</version>
     <relativePath>../..</relativePath>
   </parent>
 
diff -r b872b22ad3d5 -r 927d1d313a1d plugins/org.nuxeo.ide.connect/META-INF/MANIFEST.MF
--- a/plugins/org.nuxeo.ide.connect/META-INF/MANIFEST.MF	Sat Oct 01 00:57:16 2011 +0200
+++ b/plugins/org.nuxeo.ide.connect/META-INF/MANIFEST.MF	Sat Oct 01 10:25:17 2011 +0200
@@ -2,7 +2,7 @@
 Bundle-ManifestVersion: 2
 Bundle-Name: Nuxeo IDE Connect
 Bundle-SymbolicName: org.nuxeo.ide.connect;singleton:=true
-Bundle-Version: ${previous_osgi}
+Bundle-Version: ${next_osgi}
 Bundle-Activator: org.nuxeo.ide.connect.ConnectPlugin
 Require-Bundle: org.eclipse.ui,
  org.eclipse.core.runtime,
diff -r b872b22ad3d5 -r 927d1d313a1d plugins/org.nuxeo.ide.connect/pom.xml
--- a/plugins/org.nuxeo.ide.connect/pom.xml	Sat Oct 01 00:57:16 2011 +0200
+++ b/plugins/org.nuxeo.ide.connect/pom.xml	Sat Oct 01 10:25:17 2011 +0200
@@ -9,7 +9,7 @@
   <parent>
     <groupId>org.nuxeo.ide</groupId>
     <artifactId>org.nuxeo.ide.tycho</artifactId>
-    <version>${previous_maven}</version>
+    <version>${next_maven}</version>
     <relativePath>../..</relativePath>
   </parent>
 
diff -r b872b22ad3d5 -r 927d1d313a1d plugins/org.nuxeo.ide.qatests/META-INF/MANIFEST.MF
--- a/plugins/org.nuxeo.ide.qatests/META-INF/MANIFEST.MF	Sat Oct 01 00:57:16 2011 +0200
+++ b/plugins/org.nuxeo.ide.qatests/META-INF/MANIFEST.MF	Sat Oct 01 10:25:17 2011 +0200
@@ -2,7 +2,7 @@
 Bundle-ManifestVersion: 2
 Bundle-Name: Nuxeo IDE QA Tests
 Bundle-SymbolicName: org.nuxeo.ide.qatests
-Bundle-Version: ${previous_osgi}
+Bundle-Version: ${next_osgi}
 Bundle-Activator: org.nuxeo.ide.qatests.Activator
 Bundle-Vendor: Nuxeo
 Require-Bundle: org.eclipse.core.runtime,
diff -r b872b22ad3d5 -r 927d1d313a1d plugins/org.nuxeo.ide.qatests/pom.xml
--- a/plugins/org.nuxeo.ide.qatests/pom.xml	Sat Oct 01 00:57:16 2011 +0200
+++ b/plugins/org.nuxeo.ide.qatests/pom.xml	Sat Oct 01 10:25:17 2011 +0200
@@ -9,7 +9,7 @@
   <parent>
     <groupId>org.nuxeo.ide</groupId>
     <artifactId>org.nuxeo.ide.tycho</artifactId>
-    <version>${previous_maven}</version>
+    <version>${next_maven}</version>
     <relativePath>../..</relativePath>
   </parent>
 
@@ -63,12 +63,12 @@
             <dependency> 
               <type>p2-installable-unit</type>
               <artifactId>org.nuxeo.ide.sdk.feature.group</artifactId>
-              <version>${previous_osgi}</version>
+              <version>${next_osgi}</version>
             </dependency>
             <dependency> 
               <type>p2-installable-unit</type>
               <artifactId>org.nuxeo.ide.shell.feature.group</artifactId>
-              <version>${previous_osgi}</version>
+              <version>${next_osgi}</version>
             </dependency>
            </dependencies>
         </configuration>
diff -r b872b22ad3d5 -r 927d1d313a1d plugins/org.nuxeo.ide.sdk/META-INF/MANIFEST.MF
--- a/plugins/org.nuxeo.ide.sdk/META-INF/MANIFEST.MF	Sat Oct 01 00:57:16 2011 +0200
+++ b/plugins/org.nuxeo.ide.sdk/META-INF/MANIFEST.MF	Sat Oct 01 10:25:17 2011 +0200
@@ -2,7 +2,7 @@
 Bundle-ManifestVersion: 2
 Bundle-Name: Nuxeo IDE SDK
 Bundle-SymbolicName: org.nuxeo.ide.sdk;singleton:=true
-Bundle-Version: ${previous_osgi}
+Bundle-Version: ${next_osgi}
 Bundle-Activator: org.nuxeo.ide.sdk.SDKPlugin
 Bundle-Vendor: Nuxeo
 Require-Bundle: org.eclipse.ui,
diff -r b872b22ad3d5 -r 927d1d313a1d plugins/org.nuxeo.ide.sdk/pom.xml
--- a/plugins/org.nuxeo.ide.sdk/pom.xml	Sat Oct 01 00:57:16 2011 +0200
+++ b/plugins/org.nuxeo.ide.sdk/pom.xml	Sat Oct 01 10:25:17 2011 +0200
@@ -9,7 +9,7 @@
   <parent>
     <groupId>org.nuxeo.ide</groupId>
     <artifactId>org.nuxeo.ide.tycho</artifactId>
-    <version>${previous_maven}</version>
+    <version>${next_maven}</version>
     <relativePath>../..</relativePath>
   </parent>
 
diff -r b872b22ad3d5 -r 927d1d313a1d plugins/org.nuxeo.ide.sdk543/META-INF/MANIFEST.MF
--- a/plugins/org.nuxeo.ide.sdk543/META-INF/MANIFEST.MF	Sat Oct 01 00:57:16 2011 +0200
+++ b/plugins/org.nuxeo.ide.sdk543/META-INF/MANIFEST.MF	Sat Oct 01 10:25:17 2011 +0200
@@ -2,7 +2,7 @@
 Bundle-ManifestVersion: 2
 Bundle-Name: Project Templates for Nuxeo 5.4.3
 Bundle-SymbolicName: org.nuxeo.ide.sdk543;singleton:=true
-Bundle-Version: ${previous_osgi}
+Bundle-Version: ${next_osgi}
 Bundle-Vendor: Nuxeo
 Fragment-Host: org.nuxeo.ide.sdk
 Bundle-RequiredExecutionEnvironment: JavaSE-1.6
diff -r b872b22ad3d5 -r 927d1d313a1d plugins/org.nuxeo.ide.sdk543/pom.xml
--- a/plugins/org.nuxeo.ide.sdk543/pom.xml	Sat Oct 01 00:57:16 2011 +0200
+++ b/plugins/org.nuxeo.ide.sdk543/pom.xml	Sat Oct 01 10:25:17 2011 +0200
@@ -9,7 +9,7 @@
   <parent>
     <groupId>org.nuxeo.ide</groupId>
     <artifactId>org.nuxeo.ide.tycho</artifactId>
-    <version>${previous_maven}</version>
+    <version>${next_maven}</version>
     <relativePath>../..</relativePath>
   </parent>
 
diff -r b872b22ad3d5 -r 927d1d313a1d plugins/org.nuxeo.ide.shell/META-INF/MANIFEST.MF
--- a/plugins/org.nuxeo.ide.shell/META-INF/MANIFEST.MF	Sat Oct 01 00:57:16 2011 +0200
+++ b/plugins/org.nuxeo.ide.shell/META-INF/MANIFEST.MF	Sat Oct 01 10:25:17 2011 +0200
@@ -2,7 +2,7 @@
 Bundle-ManifestVersion: 2
 Bundle-Name: Nuxeo Shell
 Bundle-SymbolicName: org.nuxeo.ide.shell;singleton:=true
-Bundle-Version: ${previous_osgi}
+Bundle-Version: ${next_osgi}
 Bundle-Activator: org.nuxeo.ide.shell.Activator
 Require-Bundle: org.eclipse.ui,
  org.eclipse.core.runtime
diff -r b872b22ad3d5 -r 927d1d313a1d plugins/org.nuxeo.ide.shell/pom.xml
--- a/plugins/org.nuxeo.ide.shell/pom.xml	Sat Oct 01 00:57:16 2011 +0200
+++ b/plugins/org.nuxeo.ide.shell/pom.xml	Sat Oct 01 10:25:17 2011 +0200
@@ -9,7 +9,7 @@
   <parent>
     <groupId>org.nuxeo.ide</groupId>
     <artifactId>org.nuxeo.ide.tycho</artifactId>
-    <version>${previous_maven}</version>
+    <version>${next_maven}</version>
     <relativePath>../..</relativePath>
   </parent>
 
diff -r b872b22ad3d5 -r 927d1d313a1d pom.xml
--- a/pom.xml	Sat Oct 01 00:57:16 2011 +0200
+++ b/pom.xml	Sat Oct 01 10:25:17 2011 +0200
@@ -10,7 +10,7 @@
   <modelVersion>4.0.0</modelVersion>
   <groupId>org.nuxeo.ide</groupId>
   <artifactId>org.nuxeo.ide.tycho</artifactId>
-  <version>${previous_maven}</version>
+  <version>${next_maven}</version>
   <packaging>pom</packaging>
   <name>Nuxeo IDE Tycho Build</name>
   <description>Provide common tycho build directives.</description>
diff -r b872b22ad3d5 -r 927d1d313a1d sites/org.nuxeo.ide.site/category.xml
--- a/sites/org.nuxeo.ide.site/category.xml	Sat Oct 01 00:57:16 2011 +0200
+++ b/sites/org.nuxeo.ide.site/category.xml	Sat Oct 01 10:25:17 2011 +0200
@@ -1,9 +1,9 @@
 <?xml version="1.0" encoding="UTF-8"?>
 <site>
-   <feature url="features/org.nuxeo.ide.shell.feature_${previous_osgi}.jar" id="org.nuxeo.ide.shell.feature" version="${previous_osgi}">
+   <feature url="features/org.nuxeo.ide.shell.feature_${next_osgi}.jar" id="org.nuxeo.ide.shell.feature" version="${next_osgi}">
       <category name="shell"/>
    </feature>
-   <feature url="features/org.nuxeo.ide.sdk.feature_${previous_osgi}.jar" id="org.nuxeo.ide.sdk.feature" version="${previous_osgi}">
+   <feature url="features/org.nuxeo.ide.sdk.feature_${next_osgi}.jar" id="org.nuxeo.ide.sdk.feature" version="${next_osgi}">
       <category name="ide"/>
    </feature>
    <category-def name="ide" label="Nuxeo IDE">
diff -r b872b22ad3d5 -r 927d1d313a1d sites/org.nuxeo.ide.site/pom.xml
--- a/sites/org.nuxeo.ide.site/pom.xml	Sat Oct 01 00:57:16 2011 +0200
+++ b/sites/org.nuxeo.ide.site/pom.xml	Sat Oct 01 10:25:17 2011 +0200
@@ -10,7 +10,7 @@
   <parent>
     <groupId>org.nuxeo.ide</groupId>
     <artifactId>org.nuxeo.ide.tycho</artifactId>
-    <version>${previous_maven}</version>
+    <version>${next_maven}</version>
     <relativePath>../..</relativePath>
   </parent>
 
diff -r b872b22ad3d5 -r 927d1d313a1d sites/org.nuxeo.ide.site/site.xml
--- a/sites/org.nuxeo.ide.site/site.xml	Sat Oct 01 00:57:16 2011 +0200
+++ b/sites/org.nuxeo.ide.site/site.xml	Sat Oct 01 10:25:17 2011 +0200
@@ -1,9 +1,9 @@
 <?xml version="1.0" encoding="UTF-8"?>
 <site>
-   <feature url="features/org.nuxeo.ide.shell_${previous_osgi}.jar" id="org.nuxeo.ide.shell" version="${previous_osgi}">
+   <feature url="features/org.nuxeo.ide.shell_${next_osgi}.jar" id="org.nuxeo.ide.shell" version="${next_osgi}">
       <category name="shell"/>
    </feature>
-   <feature url="features/org.nuxeo.ide.sdk_${previous_osgi}.jar" id="org.nuxeo.ide.sdk" version="${previous_osgi}">
+   <feature url="features/org.nuxeo.ide.sdk_${next_osgi}.jar" id="org.nuxeo.ide.sdk" version="${next_osgi}">
       <category name="ide"/>
    </feature>
    <category-def name="ide" label="Nuxeo IDE">
EOF
