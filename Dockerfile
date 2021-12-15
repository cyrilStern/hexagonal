FROM gradle:jdk17 AS build
ARG CI_JOB_TOKEN

RUN mkdir /app
WORKDIR /app

COPY build.gradle settings.gradle gradle.properties /app/
COPY src/main/resources/application.yml.dist /app/src/main/resources/application.yml
COPY src /app/src

RUN gradle build

# No jre image provided anymore by eclipse-temurin, we build our java runtime with jlink
FROM eclipse-temurin:17 as jre-build

ARG TRUSTSTORE_URL
ARG TRUSTSTORE_PATH

RUN mkdir /app
WORKDIR /app
ADD $TRUSTSTORE_URL $TRUSTSTORE_PATH

COPY run-java.sh /app/run-java.sh
# We make four distinct layers so if there are application changes the library layers can be re-used
COPY --from=build /app/build/quarkus-app/lib/ /app/lib/
COPY --from=build /app/build/quarkus-app/*.jar /app/
COPY --from=build /app/build/quarkus-app/app/ /app/app/
COPY --from=build /app/build/quarkus-app/quarkus/ /app/quarkus/

ENTRYPOINT [ "/app/run-java.sh" ]