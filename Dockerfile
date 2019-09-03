FROM gradle:jdk10 as builder
COPY --chown=gradle:gradle . /app
WORKDIR /app
RUN gradle bootJar


#let use OpenJDK docker image
FROM openjdk:8
EXPOSE 8080

VOLUME /tmp
ARG LIBS=app/build/libs
COPY --from=builder ${LIBS}/ /build/libs
ENTRYPOINT ["java","-jar","build/libs/MetroCenter-0.0.1-SNAPSHOT.jar"]

#deploy the jar file to the container
#COPY build/libs/MetroCenter-0.0.1-SNAPSHOT.jar build/libs/MetroCenter-0.0.1-SNAPSHOT.jar

