FROM openjdk:11-jre
COPY target/openapi-merlin-0.0.1-SNAPSHOT.jar app.jar
RUN mkdir ./openapi
EXPOSE 8080/tcp
ENTRYPOINT ["java","-jar","app.jar"]