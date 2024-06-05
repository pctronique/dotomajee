#********** start CmakeLists.txt **********

cmake_minimum_required(VERSION 3.5)

project(PROJECT_JEE)

#set(CMAKE_BUILD_TYPE Debug)
set(CMAKE_BUILD_TYPE Release)

find_package(Java REQUIRED)
include(UseJava)

file(GLOB_RECURSE java_SRCS ${CMAKE_CURRENT_SOURCE_DIR}/src/*.java)
file(GLOB lib_SRCS ${CMAKE_CURRENT_SOURCE_DIR}/lib/*.jar)
file(GLOB libTomcat_SRCS /var/docker/tomcat/tomcat/lib/*.jar)

set(JAR_NAME ROOT)
set(JAVA_SOURCE_FILES ${java_SRCS})

add_jar(${JAR_NAME} SOURCES ${JAVA_SOURCE_FILES} INCLUDE_JARS ${lib_SRCS} ${libTomcat_SRCS})

get_target_property(_classDir ${JAR_NAME} CLASSDIR)

file(GLOB_RECURSE class_SRCS ${CMAKE_CURRENT_SOURCE_DIR}/build/*.class)

file(COPY ${PROJECT_JEE_SOURCE_DIR}/web DESTINATION ${PROJECT_JEE_SOURCE_DIR}/build/tmp/)
file(COPY ${PROJECT_JEE_SOURCE_DIR}/lib DESTINATION ${PROJECT_JEE_SOURCE_DIR}/build/tmp/web/WEB-INF/)

#********** end CmakeLists.txt **********