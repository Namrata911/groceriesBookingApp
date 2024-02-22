# Use the official OpenJDK 11 image as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the executable JAR file from the target directory into the container at /app
COPY target/groceriesBookingApp-0.0.1-SNAPSHOT.jar /app/groceriesBookingApp-0.0.1-SNAPSHOT.jar

# Expose the port the application runs on
EXPOSE 8080

# Specify the command to run on container start
CMD ["java", "-jar", "groceriesBookingApp-0.0.1-SNAPSHOT.jar"]