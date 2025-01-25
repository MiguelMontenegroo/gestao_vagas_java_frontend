# Usar uma imagem base do JDK
FROM openjdk:17-jdk-alpine

# Copiar o arquivo JAR para o contêiner
ARG JAR_FILE=target/front_gestao_vagas.jar
COPY ${JAR_FILE} app.jar

# Expor a porta que o Spring Boot usa (normalmente 8080)
EXPOSE 8080

# Comando para iniciar o aplicativo
ENTRYPOINT ["java", "-jar", "/app.jar"]