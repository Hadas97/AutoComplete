# syntax=docker/dockerfile:1
   
FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/assignment*.jar
COPY ${JAR_FILE} app.jar
COPY application.properties application.properties
EXPOSE 9090
ENTRYPOINT ["java","-jar","/app.jar","--spring.config.location=/application.properties"]

