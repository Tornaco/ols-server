#!/usr/bin/env bash

set -eo pipefail

if [ ! -n "$1" ] ;then
    echo "You have to give a port number"
    exit -1
fi



docker rm -f $(docker ps -a | grep team-b | awk '{print $1}') || echo 'Not existed'
echo $(pwd)
docker images
docker run --rm -d --name team-b-html -p $1:8080 -v $(pwd)/frontend/build/:/usr/share/nginx/html -v $(pwd)/config/:/etc/nginx/conf.d nginx
docker run --rm -d --name team-b-java -p 5005:5000 -v $(pwd)/build/libs/:/app/build/libs -w /app java:8 /bin/bash -c "java -jar /app/build/libs/ci-example-0.0.1-SNAPSHOT.jar"
docker ps -a