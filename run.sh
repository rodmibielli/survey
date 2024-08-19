#!/bin/sh

export PORT=${1:-8080}

./mvnw clean install -P${2:-default} && \
./mvnw spring-boot:build-image -P${2:-default} && \
./mvnw docker:stop docker:build docker:run -P${2:-default} -DPORT=$PORT
./mvnw spring-boot:run -P${2:-default} -DPORT=$PORT
