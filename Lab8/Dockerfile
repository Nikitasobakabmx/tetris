FROM openjdk:8-jdk-alpine

VOLUME /tmp

EXPOSE 8080 
# 8080 on docker machine 8081 on realMachine
EXPOSE 5432
# 5432 on docker machine 5234 on realMachine#need for db

RUN mkdir -p /app
RUN mkdir -p /app/logs
RUN mkdir -p /app/classes
RUN mkdir -p /app/classes/static
COPY /target/classes/static/* /app/classes/static/
COPY /target/HiberAJAX.html-0.0.1-SNAPSHOT.jar /app/app.jar

ENTRYPOINT ["java","-Dspring.profiles.active=container", "-jar", "/app/app.jar"]