# Используем официальный образ OpenJDK
FROM openjdk:17-jdk-slim

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем pom.xml и скачиваем зависимости
COPY pom.xml ./
RUN apt-get update && apt-get install -y maven && mvn dependency:go-offline

# Копируем исходный код проекта
COPY src ./src

# Собираем проект
RUN mvn package

# Указываем команду для запуска приложения
CMD ["java", "-jar", "target/SelenoidTests-1.0-SNAPSHOT.jar"] 