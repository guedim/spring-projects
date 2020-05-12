FROM adoptopenjdk/openjdk11

RUN mkdir -p /usr/local/micrometer

COPY @project.build.finalName@.jar /usr/local/micrometer/
COPY run.sh run.sh

RUN chmod +x run.sh
CMD ./run.sh