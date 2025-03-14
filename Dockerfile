FROM maven:3.9.6-amazoncorretto-21 AS build
RUN mkdir -p /opt/dev
WORKDIR /opt/dev
COPY pom.xml /opt/dev
COPY src /opt/dev/src
RUN mvn -f pom.xml clean package

FROM amazoncorretto:21.0.2-alpine3.19
COPY --from=build /opt/dev/target/*.jar app.jar
EXPOSE 8080/tcp
ENTRYPOINT ["java", "-Dspring.profiles. active=docker", "-jar","/app.jar"]

# FROM ubuntu
# CMD tail -f /dev/null