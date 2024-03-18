FROM gradle:8.6.0-jdk17-alpine as builder
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
COPY gradlew ./
COPY build.gradle settings.gradle ./
COPY ./src ./src
RUN gradle build

FROM eclipse-temurin:17-jdk-jammy
WORKDIR /home/gradle/src
EXPOSE 8080
COPY --from=builder /home/gradle/src/build/libs/*.jar /home/gradle/src/*.jar
ENTRYPOINT ["java", "-jar", "/opt/app/*.jar"]