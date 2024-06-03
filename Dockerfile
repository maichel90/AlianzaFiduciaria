FROM openjdk:21-ea-17-slim

EXPOSE 8080
RUN mkdir /opt/service
COPY target/poc-0.0.1-SNAPSHOT.jar /opt/service/app.jar


ADD docker-entrypoint.sh /
RUN chmod +x /docker-entrypoint.sh

WORKDIR /opt/service

ENTRYPOINT ["java","-jar","app.jar"]
