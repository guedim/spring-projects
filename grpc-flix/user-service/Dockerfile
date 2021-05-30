FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} user-service.jar
EXPOSE 6565
ENTRYPOINT ["java","-jar","/user-service.jar"]