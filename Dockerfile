FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim AS app
COPY --from=build /target/datalytics-0.0.1-SNAPSHOT.jar datalytics.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","datalytics.jar"]