#let use OpenJDK docker image
FROM openjdk:8

#ADD

#RUN chmod 755 MetroCenter-0.0.1-SNAPSHOT.jar

#deploy the jar file to the container
COPY build/libs/MetroCenter-0.0.1-SNAPSHOT.jar build/libs/MetroCenter-0.0.1-SNAPSHOT.jar

