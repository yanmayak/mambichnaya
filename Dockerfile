FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app
COPY target/*.jar antispam-module-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "antispam-module-0.0.1-SNAPSHOT.jar"]