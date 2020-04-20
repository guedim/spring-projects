#!/bin/bash

cd user
mvn clean package docker:build -DskipTests
cd ..

cd item
mvn clean package docker:build -DskipTests
cd ..