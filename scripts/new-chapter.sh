#!/usr/bin/env bash
set -euo pipefail
CH_ID="${1:?Usage: new-chapter.sh chNN-name}"
BASE="chapters/${CH_ID}"
mkdir -p "${BASE}/src/main/java" "${BASE}/src/test/java"

cat > "${BASE}/pom.xml" <<'POM'
<project xmlns="http://maven.apache.org/POM/4.0.0"  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <parent>
    <groupId>it.tb.training</groupId>
    <artifactId>ocp-java17-course</artifactId>
    <version>1.0.0</version>
    <relativePath>../../pom.xml</relativePath>
  </parent>
  <artifactId>#{CH_ID}</artifactId>
  <name>#{CH_ID}</name>
  <properties>
    <maven.compiler.release>17</maven.compiler.release>
  </properties>
  <dependencies>
    <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter</artifactId>
      <scope>test</scope>
    </dependency>
  </dependencies>
</project>
POM

sed -i "s/#{CH_ID}/${CH_ID}/g" "${BASE}/pom.xml"

cat > "${BASE}/README.md" <<'MD'
# Titolo Capitolo

Obiettivi didattici

Contenuti

Tip traps d’esame

Esercizi

Extra “Exam Prep”
MD

echo "Creato ${BASE}"
