FROM openjdk:8
WORKDIR /app
COPY pom.xml /app/pom.xml
COPY src /app/src
RUN mvn clean install
CMD ["mvn", "test"]