FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

ENTRYPOINT ["java", "-jar", "app.jar"]
COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jdk


WORKDIR /app

COPY --from=build /app/target/myapp.jar app.jar


ENTRYPOINT ["java", "-jar", "app.jar"]