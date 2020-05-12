#!/bin/sh

echo "********************************************************"
echo "Starting Micrometer Service"
echo "********************************************************"

java -Xms128m -Xmx128m -Djava.security.egd=file:/dev/./urandom -jar /usr/local/micrometer/@project.build.finalName@.jar