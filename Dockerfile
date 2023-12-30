FROM gradle:8.5-jdk17 as build-step
ENV GRADLE_OPTS -Dorg.gradle.daemon=false
WORKDIR /app
COPY ./ .
RUN gradle build -x test

FROM openjdk:17
COPY --from=build-step /app/build/libs/pfindus-backend-0.0.1-SNAPSHOT.jar ./app.jar
CMD ["java","-jar","-Dspring.profiles.active=prod","app.jar"]
