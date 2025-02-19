FROM maven:3.8.2-jdk-11-slim

WORKDIR /project

COPY pom.xml .

CMD mvn package

#CMD mvn clean verify -Dplatform=ios -Dlocation=bs -Dtest="RunCucumberTest" test "-Dcucumber.options=--tags \"@regular-poi\""
