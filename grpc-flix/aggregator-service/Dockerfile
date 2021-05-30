FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} aggregator-service.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/aggregator-service.jar"]