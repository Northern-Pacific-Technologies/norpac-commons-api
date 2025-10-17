# docker build -t pareto-factory:latest .
# docker exec -it <container_name_or_id> bash

FROM openjdk:21-jdk-slim

RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*

WORKDIR /app

ARG ARTIFACT=norpac-commons-api
ARG VERSION=0.0.1-SNAPSHOT
COPY target/${ARTIFACT}-${VERSION}.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
