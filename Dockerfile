# Use a lightweight Eclipse Temurin JDK runtime image
FROM eclipse-temurin:17-jre-alpine

# Set the deployment directory inside the container
WORKDIR /app

# Copy the built JAR file into the container image
COPY target/*.jar app.jar

# Expose Spring Boot's default port
EXPOSE 8080

# Execute the application
ENTRYPOINT ["java", "-jar", "app.jar"]