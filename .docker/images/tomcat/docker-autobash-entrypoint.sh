#!/bin/bash

if [ -z ${TOMCAT_FOLDER_PROJECT} ]
then
    TOMCAT_FOLDER_PROJECT=/home/project/
fi

if [ -z ${PHP_FOLDER_LOG} ]
then
    TOMCAT_FOLDER_LOG=/var/log/tomcat/
fi

if [ -z ${VALUE_JAVA_VERSION} ]
then
    VALUE_JAVA_VERSION=21
fi

#rm -r /usr/local/tomcat/webapps/
#cp -r /usr/local/tomcat/webapps.dist/ /usr/local/tomcat/webapps/

cp -r /opt/java/openjdk/ /jvm
cp -r /usr/local/tomcat/ /jvm

rm -r /jvm/tomcat/webapps*
rm -r /jvm/tomcat/work*
rm -r /jvm/tomcat/tmp*
rm -r /jvm/tomcat/log*

#touch ${TOMCAT_FOLDER_LOG}/error.log
#service startautobash start && tail -F ${TOMCAT_FOLDER_LOG}/error.log &

exec "$@"