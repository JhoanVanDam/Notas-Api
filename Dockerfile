FROM openjdk:11-jdk-alpine
MAINTAINER JhoanVanDam
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} Notas-Api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/Notas-Api-0.0.1-SNAPSHOT.jar"]