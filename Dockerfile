# Stage 1: Build
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . . 

# Clean and build the project, skipping tests
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the generated JAR file from the build stage
COPY --from=build /app/target/SaveMate-0.0.1-SNAPSHOT.jar app.jar

# Expose the application on port 8080
EXPOSE 8081

# Command to run the application
CMD ["java", "-jar", "app.jar"]
