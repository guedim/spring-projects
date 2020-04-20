#!/bin/sh

echo "********************************************************"
echo "Starting User Service"
echo "********************************************************"

java -Xms128m -Xmx128m -Djava.security.egd=file:/dev/./urandom -jar /usr/local/user/@project.build.finalName@.jar