# ---------- Stage 1 : Build ----------
FROM maven:3.9-eclipse-temurin-21-alpine AS build
WORKDIR /app

# Pre‑fetch dependencies for better build caching
COPY pom.xml .
RUN mvn -B dependency:go-offline

# Copy source and package
COPY . .
RUN mvn -B package -DskipTests

# ---------- Stage 2 : Runtime ----------
FROM eclipse-temurin:21-jre-alpine

# Create non‑root user
RUN adduser -D -u 1001 appuser

WORKDIR /app
COPY --from=build /app/target/divan-camileri-service-*.jar app.jar

EXPOSE 9001
USER appuser

HEALTHCHECK --interval=30s --timeout=5s --start-period=10s --retries=3 \
  CMD wget -qO- http://localhost:9001/actuator/health | grep '"status":"UP"' || exit 1

ENTRYPOINT ["java","-jar","app.jar"]