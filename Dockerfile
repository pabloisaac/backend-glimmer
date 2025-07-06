# Etapa 1: build del JAR
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: imagen final con JAR construido
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=builder /app/target/admin-panel-*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]