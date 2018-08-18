#!/usr/bin/env bash

set -eo pipefail

if [ ! -n "$1" ] ;then
    echo "You have to give a port number"
    exit -1
fi

app=$(docker ps -a | grep team-b | awk '{print $1}')
if [ -n "$app" ] ;then
    docker rm -f $app
fi
docker run -d --name team-b -p $1:5000 -v $(pwd)/build/libs/:/app/build/libs -v  -w /app java:8 /bin/bash -c "java -jar /app/build/libs/ci-example-0.0.1-SNAPSHOT.jar"