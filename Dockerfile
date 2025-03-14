# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven wrapper and other necessary files
COPY .mvn/ .mvn
COPY mvnw .
COPY pom.xml .

# Grant execute permissions to the Maven wrapper
RUN chmod +x ./mvnw

# Build the application (this will download dependencies too)
COPY src ./src
RUN ./mvnw clean package

# Expose the port your app runs on
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "target/spring_mc-0.0.1-SNAPSHOT.jar"]

