# Usamos JRE 21 sobre una base ligera de Ubuntu (Jammy)
FROM eclipse-temurin:21-jre-jammy

# Directorio de trabajo
WORKDIR /app

# Copiamos el JAR generado (asegúrate de que el nombre coincida o usa comodines)
COPY target/*.jar app.jar

# Exponer el puerto por defecto de Spring Boot
EXPOSE 8080

# Ejecución optimizada para contenedores
ENTRYPOINT ["java", "-jar", "app.jar"]