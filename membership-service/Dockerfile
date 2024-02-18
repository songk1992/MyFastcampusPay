FROM openjdk:21-jdk-slim
EXPOSE 8080
ENV PROFILES_ACTIVE="prod"
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
CMD ["java", "-jar", "app.jar"]