# Usar una imagen oficial de OpenJDK como base
FROM openjdk:17-jdk-slim

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo pom.xml y otros archivos necesarios para la compilación
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# Descargar las dependencias del proyecto
RUN ./mvnw dependency:go-offline

# Copiar todo el código fuente del proyecto
COPY src ./src

# Compilar la aplicación
RUN ./mvnw clean package -DskipTests

# Establecer el archivo .jar como punto de entrada
CMD ["java", "-jar", "target/Parcial1Prog3-0.0.1-SNAPSHOT.jar"]