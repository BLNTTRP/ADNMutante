# Usar una imagen oficial de OpenJDK como base
FROM openjdk:17-jdk-slim

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo pom.xml y otros archivos necesarios para la compilación
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# Copiar el código fuente del proyecto
COPY src ./src

# Convertimos el archivo mvnw a formato UNIX
RUN apt-get update && apt-get install -y dos2unix
RUN dos2unix ./mvnw

# Da permisos de ejecución al script mvnw
RUN chmod +x ./mvnw

# Dependencias offline
RUN ./mvnw dependency:go-offline

# Compilar la aplicación
RUN ./mvnw clean package -DskipTests

# Establecer el archivo .jar como punto de entrada
CMD ["java", "-jar", "target/Parcial1Prog3-0.0.1-SNAPSHOT.jar"]