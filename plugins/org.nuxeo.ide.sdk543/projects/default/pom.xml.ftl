<?xml version="1.0"?>
<project>
  <modelVersion>4.0.0</modelVersion>

  <parent>
    <groupId>${parentGroupId}</groupId>
    <artifactId>${parentArtifactId}</artifactId>
    <version>${parentVersion}</version>
  </parent>

  <groupId>${groupId}</groupId>
  <artifactId>${artifactId}</artifactId>
  <name>${artifactName}</name>
  <description>
    ${artifactDescription}
  </description>

  <dependencies>
    <dependency>
      <groupId>javax.ws.rs</groupId>
      <artifactId>jsr311-api</artifactId>
    </dependency>
    <dependency>
      <groupId>org.nuxeo.ecm.webengine</groupId>
      <artifactId>nuxeo-webengine-core</artifactId>
    </dependency>
    <dependency>
      <groupId>org.nuxeo.ecm.webengine</groupId>
      <artifactId>nuxeo-webengine-base</artifactId>
    </dependency>

    <dependency>
      <groupId>org.osgi</groupId>
      <artifactId>osgi-core</artifactId>
    </dependency>

    <dependency>
      <groupId>commons-codec</groupId>
      <artifactId>commons-codec</artifactId>
      <optional>false</optional>
    </dependency>
  </dependencies>

</project>