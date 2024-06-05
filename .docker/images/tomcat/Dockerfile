ARG VALUE_TOMCAT_VERSION
ARG DEF_JAVA_VERSION=${VALUE_TOMCAT_VERSION:-"24.04"}

FROM tomcat:${DEF_JAVA_VERSION}

ARG VALUE_JAVA_VERSION
ENV VALUE_JAVA_VERSION=${VALUE_JAVA_VERSION:-"21"}

ARG TOMCAT_FOLDER_PROJECT
ENV TOMCAT_FOLDER_PROJECT=${TOMCAT_FOLDER_PROJECT:-"/home/project/"}
ENV TOMCAT_FOLDER_LOG="/var/log/tomcat/"
ENV TOMCAT_FOLDER_TMP="/var/tmp/tomcat/"
ENV TOMCAT_FOLDER_INIT="/var/tomcat/"
ENV TOMCAT_FOLDER_INIT_DATA="/docker-entrypoint-initdata.d/"

RUN mkdir -p ${TOMCAT_FOLDER_PROJECT}
RUN mkdir -p ${TOMCAT_FOLDER_LOG}
RUN mkdir -p ${TOMCAT_FOLDER_TMP}
RUN mkdir -p ${TOMCAT_FOLDER_INIT}
RUN mkdir -p ${TOMCAT_FOLDER_INIT_DATA}

#del list
RUN rm -rf /var/lib/apt/lists/*

#COPY updateProject.sh ${TOMCAT_FOLDER_INIT}
#RUN chmod +x ${TOMCAT_FOLDER_INIT}/updateProject.sh

#ADD sample.war /usr/local/tomcat/webapps/

COPY docker-autobash-entrypoint.sh /usr/local/bin/
RUN chmod +x /usr/local/bin/docker-autobash-entrypoint.sh

#COPY startautobash /etc/init.d/
#RUN chmod +x /etc/init.d/startautobash
#RUN update-rc.d startautobash defaults

WORKDIR ${TOMCAT_FOLDER_PROJECT}

ENTRYPOINT ["docker-autobash-entrypoint.sh"]

EXPOSE 8080

RUN chmod +x /usr/local/tomcat/bin/catalina.sh

CMD ["catalina.sh", "run"]
