FROM gradle:7.5-jdk11

RUN mkdir /app

COPY ./gradle /app/gradle
COPY ./src /app/src
COPY build.gradle /app/
COPY settings.gradle /app
COPY gradlew /app/
COPY gradlew.bat /app/

WORKDIR /app

RUN gradle clean build

ENV HOST_KAFKA_DOCKER_INTERNAL=host.docker.internal
ENV MONGODB_HOST=host.docker.internal
ENV MONGODB_PORT=27017
ENV MONGODB_AUTH_DATABASE=admin
ENV MONGODB_DATABASE=dronedb
ENV MONGODB_USERNAME=root
ENV MONGODB_PASSWORD=MongoDB2022!
ENV KAFKA_GROUP=drone_group
ENV KAFKA_TOPIC=drone_topic

ENV CONFIG_GMAIL_USERNAME=ricardosoareslacerda@gmail.com
ENV CONFIG_GMAIL_APP_PASSWORD=bwzrltermsamneyy

ENV MAIL_ADDRESS_FROM=ricardosoareslacerda@gmail.com
ENV MAIL_ADDRESS_TO=ricardosoareslacerda@gmail.com

ENTRYPOINT ["java","-jar","/app/build/libs/drone-cluster-monitor-consumer-0.0.1-SNAPSHOT.jar"]