#!/bin/sh
JVM_OPTS="-Dspring.config.location=/apps/application.yml"
nohup java -jar ruoyi-admin.jar >log 2>&1 &

