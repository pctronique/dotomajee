#!/bin/bash

if [ -z ${JAVA_FOLDER_PROJECT} ]
then
    JAVA_FOLDER_PROJECT=/home/project/
fi

if [ -z ${JAVA_NAME_PROJECT} ]
then
    JAVA_NAME_PROJECT=project
fi

if [ -e ${JAVA_FOLDER_PROJECT}/build.xml ]
then
  sed -i "s/project name=\".*\"/project name=\"${JAVA_NAME_PROJECT}\"/" "${JAVA_FOLDER_PROJECT}/build.xml"
  sed -i "s/Builds, tests, and runs the project .*\./Builds, tests, and runs the project ${JAVA_FOLDER_PROJECT}./" "${JAVA_FOLDER_PROJECT}/build.xml"
fi

if [ -e ${JAVA_FOLDER_PROJECT}/nbproject/project.xml ]
then
  sed -i "s/<name>.*<\/name>/<name>${JAVA_NAME_PROJECT}<\/name>/" "${JAVA_FOLDER_PROJECT}/nbproject/project.xml"
fi

if [ -e ${JAVA_FOLDER_PROJECT}/nbproject/build-impl.xml ]
then
  sed -i "s/default=\"default\" name=\".*-impl\"/default=\"default\" name=\"${JAVA_NAME_PROJECT}-impl\"/" "${JAVA_FOLDER_PROJECT}/nbproject/build-impl.xml"
  sed -i "s/suitename=\".*\"/suitename=\"${JAVA_NAME_PROJECT}\"/" "${JAVA_FOLDER_PROJECT}/nbproject/build-impl.xml"
  sed -i "s/-suitename .* -testname/-suitename ${JAVA_NAME_PROJECT} -testname/" "${JAVA_FOLDER_PROJECT}/nbproject/build-impl.xml"
fi

exit 0