FROM maven:3.6.3-jdk-8-slim AS MAVEN_BUILD

COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/

RUN mvn clean compile assembly:single

WORKDIR /build/target/

COPY sampleData.json /build/target/

ENTRYPOINT ["java", "-jar", "JsonProject-0.0.1-SNAPSHOT-jar-with-dependencies.jar"]

CMD ["sampleData.json"]