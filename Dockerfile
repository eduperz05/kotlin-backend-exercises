# Stage 1: Build the application
FROM maven:3.8.5-openjdk-17-slim AS build

WORKDIR /app
COPY . .

RUN mvn clean package

# Copy the JaCoCo report to the static resources directory
RUN mkdir -p src/main/resources/static/jacoco && \
    cp -r target/site/jacoco/* src/main/resources/static/jacoco/

# Stage 2: Run the application
FROM openjdk:17-jdk-slim

WORKDIR /app
# Copy the built application and the JaCoCo report from the build stage
COPY --from=build /app/target/*.jar app.jar
COPY --from=build /app/src/main/resources/static/jacoco /app/src/main/resources/static/jacoco

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
