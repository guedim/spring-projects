FROM maven:3.5-jdk-8 as builder
WORKDIR /projects/java/externalize-config
COPY . /projects/java/externalize-config
RUN mvn clean install -DskipTests

FROM openjdk:alpine
VOLUME /tmp
COPY entrypoint.sh /
COPY --from=builder /projects/java/externalize-config/target/*.jar app.jar
RUN apk update && apk upgrade && apk add --no-cache bash wget && rm -rf /var/cache/apk/* \
    && bash -c 'touch /app.jar' \
    && mkdir configs \
    && chmod 700 /entrypoint.sh

ENTRYPOINT ["./entrypoint.sh"]

CMD [ "start" ]