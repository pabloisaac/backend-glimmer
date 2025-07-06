FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy built jar into container
COPY target/admin-panel-*.jar app.jar

# Expose port
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]