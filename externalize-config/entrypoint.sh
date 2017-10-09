#!/usr/bin/env bash

CMD=$1
echo "Command :" $CMD

echo "Downloading configuration files from git repository"
wget  $GIT_REPO/$LABEL/$REL_PATH/$APP_NAME.yml
wget  $GIT_REPO/$LABEL/$REL_PATH/$APP_NAME-$PROFILE.yml

echo "copying yml files to configs directory"
cp $APP_NAME.yml ./configs/$APP_NAME.yml
cp $APP_NAME-$PROFILE.yml ./configs/$APP_NAME-$PROFILE.yml

ls ./configs

JAVA_OPTS="$JAVA_OPTS -Djava.net.preferIPv4Stack=true -Djava.net.preferIPv4Addresses -Duser.timezone=America/Los_Angeles -Djava.security.egd=file:/dev/./urandom"

echo $JAVA_OPTS

case "$CMD" in
    "start")
        echo "Starting SpringBoot application"
        exec java $JAVA_OPTS -jar /app.jar --spring.config.location="./configs/$APP_NAME.yml, ./configs/$APP_NAME-$PROFILE.yml"
    ;;

    * )
    # custom command
    echo "custom command"
    exec $CMD ${@:2}
    ;;
esac