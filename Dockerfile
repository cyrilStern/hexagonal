FROM gradle:jdk16-hotspot AS build

RUN mkdir /app
WORKDIR /app
COPY build.gradle.kts settings.gradle.kts gradle.properties /app/
COPY src/main/resources/application.yml.dist /app/src/main/resources/application.yml
COPY src /app/src

RUN gradle build

FROM adoptopenjdk/openjdk16:alpine-slim

RUN mkdir /app
WORKDIR /app

COPY run-java.sh /app/run-java.sh
# We make four distinct layers so if there are application changes the library layers can be re-used
COPY --from=build /app/build/quarkus-app/lib/ /app/lib/
COPY --from=build /app/build/quarkus-app/*.jar /app/
COPY --from=build /app/build/quarkus-app/app/ /app/app/
COPY --from=build /app/build/quarkus-app/quarkus/ /app/quarkus/

ARG TRUSTSTORE_URL
ARG TRUSTSTORE_PATH
ADD $TRUSTSTORE_URL $TRUSTSTORE_PATH
ENTRYPOINT [ "/app/run-java.sh" ]
