#!/usr/bin/env bash

docker run -d -it -p 8082:8082 -e DB_URL="jdbc:postgresql://192.168.0.118:5432/postgres?currentSchema=teamapps" -e SERVER_PORT=8082 -e OAUTH_URL="http://192.168.0.118:8080/teamapps-auth/oauth/check_token" --name=milk-service milk-service

