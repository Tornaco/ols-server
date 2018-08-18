FROM openjdk:8-alpine

MAINTAINER sjyuan <sjyuan@thoughtworks.com>

COPY build/libs/ols-core-server-*.jar /app/ols-core-server-*.jar

COPY frontend/build/* /usr/share/nginx/html/*

WORKDIR /app

CMD java -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintGCDateStamps -XX:+PrintHeapAtGC -verbose:gc -XX:+PrintTenuringDistribution -XX:+PrintGCApplicationStoppedTime -Xloggc:gc_cdm.log -jar ols-core-server-*.jar
