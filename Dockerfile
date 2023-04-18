FROM openjdk:8-jdk-slim

# Instalação do Maven
RUN apt-get update && apt-get install -y maven

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean install

CMD ["mvn", "test"]