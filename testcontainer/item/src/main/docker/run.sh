#!/bin/sh

echo "********************************************************"
echo "Starting Item Service"
echo "********************************************************"

java -Xms128m -Xmx128m -Djava.security.egd=file:/dev/./urandom -jar /usr/local/item/@project.build.finalName@.jar