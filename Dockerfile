# Etapa 1: Construção do JAR
FROM maven:3.8.8-eclipse-temurin-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Construção da imagem final
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=builder /app/target/front_gestao_vagas-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]