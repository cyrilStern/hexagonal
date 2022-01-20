FROM gradle:jdk17 AS build

RUN mkdir /app
WORKDIR /app

COPY build.gradle settings.gradle gradle.properties /app/
COPY src/main/resources/application.properties.dist /app/src/main/resources/application.properties
COPY src /app/src

RUN gradle build -x test

FROM openjdk:17-buster

RUN mkdir /app
WORKDIR /app

# We make four distinct layers so if there are application changes the library layers can be re-used
COPY --chown=1001 --from=build /app/build/quarkus-app/lib/ /app/lib/
COPY --chown=1001 --from=build /app/build/quarkus-app/*.jar /app/
COPY --chown=1001 --from=build /app/build/quarkus-app/*.txt /app/
COPY --chown=1001 --from=build /app/build/quarkus-app/app/ /app/app/
COPY --chown=1001 --from=build /app/build/quarkus-app/quarkus/ /app/quarkus/

USER 1001
EXPOSE 8044

ENTRYPOINT [ "java", "-jar", "quarkus-run.jar" ]