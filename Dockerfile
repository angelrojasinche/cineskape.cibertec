FROM tomcat:10-jdk21

RUN rm -rf /usr/local/tomcat/webapps/*

COPY dist/LPI_T1_ROJAS_AYMAR.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

