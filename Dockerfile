FROM openjdk:23-rc-oraclelinux8
WORKDIR /app
COPY ./target/telegram-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]