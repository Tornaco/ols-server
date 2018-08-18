#!/usr/bin/env bash
set -eo pipefail

if [ ! -n "$1" ] ;then
    echo "You have to give a port number"
    exit -1
fi

docker rm -f $(docker ps -a | grep greeting-app-b | awk '{print $1}') || echo 'Not existed'
docker run -d --name greeting-app-b -p $1:5000 -v $(pwd)/build/libs/:/app/build/libs -w /app java:8 /bin/bash -c "java -jar /app/build/libs/ci-example-0.0.1-SNAPSHOT.jar"