#!/bin/bash
echo "Building the containers and running selenium server instance"
docker -v
echo "-------------- Starting Selenium Grid -------------------"
docker-compose -f docker-compose-standalone.yml up &>/dev/null &
echo "-------------- Started Selenium Grid --------------------"
