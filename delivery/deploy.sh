#!/usr/bin/env bash

set -eo pipefail

if [ ! -n "$1" ] ;then
    echo "You have to give a port number"
    exit -1
fi

docker rm -f $(docker ps -a | grep team-b | awk '{print $1}') || echo 'Not existed'

docker run --rm -d --name team-b-html -p $1:80 -v $(pwd)/frontend/build/:/usr/share/nginx/html -v $(pwd)/config/nginx.conf:/etc/nginx/conf.d/default.conf nginx /bin/bash -c "systemctl restart nginx"
docker run --rm -d --name team-b-java -p 5005:5000 -v $(pwd)/build/libs/:/app/build/libs -w /app java:8 /bin/bash -c "java -jar /app/build/libs/ci-example-0.0.1-SNAPSHOT.jar"
