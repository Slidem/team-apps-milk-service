#!/usr/bin/env bash

java -jar -Dspring.datasource.url=$1 -Dserver.port=$2 -Doauth.checkTokenUrl=$3 /milk-service.jar
