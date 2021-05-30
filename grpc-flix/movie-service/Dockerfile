FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} movie-service.jar
EXPOSE 7575
ENTRYPOINT ["java","-jar","/movie-service.jar"]