FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy your Maven project into the container
COPY . .

# Build the application
RUN ./mvnw clean install

# Run the application
CMD ["java", "-jar", "target/backend-0.0.1-SNAPSHOT.jar"]
