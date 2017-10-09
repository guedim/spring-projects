#!/usr/bin/env bash

docker run -d -p 80:8080 -e PROFILE=production -e GIT_REPO="https://github.com/guedim/spring-projects" \
    -e LABEL=master -e REL_PATH="externalize-config/src/main/resources" \
    -e APP_NAME="application" guedim/spring-externalize-config
