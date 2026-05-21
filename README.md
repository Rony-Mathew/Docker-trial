# Dockerized Spring Boot Application

This project is a simple Spring Boot application that is containerized using Docker.

## Prerequisites

Before you begin, ensure you have the following installed:
- [Docker](https://docs.docker.com/get-docker/)
- [Docker Compose](https://docs.docker.com/compose/install/)
- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven](https://maven.apache.org/install.html)

## Building the Application

To build the application and create the JAR file, run the following command from the `assignment` directory:

```bash
mvn clean install
```

## Running the Application with Docker

To run the application using Docker Compose, run the following command from the root directory of the project:

```bash
docker-compose up --build
```

This will build the Docker image and start the application.

## Accessing the Application

Once the application is running, you can access it at [http://localhost:8080](http://localhost:8080).

## Docker Configuration

### `Dockerfile`

The `Dockerfile` is used to build the Docker image for the application.

- **`FROM eclipse-temurin:17-jre-alpine`**: This specifies the base image to use. It's a lightweight Java 17 runtime environment.
- **`WORKDIR /app`**: This sets the working directory inside the container to `/app`.
- **`COPY target/*.jar app.jar`**: This copies the JAR file from the `target` directory (created during the Maven build) to `app.jar` inside the container.
- **`EXPOSE 8080`**: This exposes port `8080` to allow communication with the application.
- **`ENTRYPOINT ["java", "-jar", "app.jar"]`**: This is the command that is run when the container starts. It executes the Spring Boot application.

### `docker-compose.yaml`

The `docker-compose.yaml` file is used to define and run the multi-container Docker application.

- **`version: '3.8'`**: This specifies the version of the Docker Compose file format.
- **`services:`**: This is where the services are defined.
- **`web:`**: This is the name of our service.
  - **`build: .`**: This tells Docker Compose to build the image from the `Dockerfile` in the current directory.
  - **`ports: - "8080:8080"`**: This maps port `8080` on the host to port `8080` in the container.
  - **`environment:`**: This is used to set environment variables in the container.
    - **`SPRING_PROFILES_ACTIVE=prod`**: This sets the active Spring profile to `prod`.
    - **`SERVER_PORT=8080`**: This sets the server port to `8080`.
