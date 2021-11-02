#!/bin/sh
ps -ef | grep ruoyi-admin.jar | awk '{print $2}' | xargs kill -9

