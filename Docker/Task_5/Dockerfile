# ==================== STAGE 1: Build Stage (Maven) ====================
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app
COPY . .

# Build the application
RUN mvn clean package -DskipTests

# ==================== STAGE 2: Runtime Stage (Java) ====================
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copy only the built JAR from the builder stage
COPY --from=builder /app/target/demo-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

# Run the Spring Boot application
CMD ["java", "-jar", "app.jar"]
