FROM gradle:jdk21 AS build

RUN mkdir /app
WORKDIR /app

COPY ./ /app/

RUN gradle build -x test --stacktrace

FROM eclipse-temurin:21-jre-alpine

RUN mkdir /app
WORKDIR /app
RUN apk update && apk add --no-cache gcompat &&  apk add --no-cache libstdc++

# We make four distinct layers so if there are application changes the library layers can be re-used
COPY --chown=1001 --from=build /app/infrastructure/build/quarkus-app/lib/ /app/build/quarkus-app/lib/
COPY --chown=1001 --from=build /app/infrastructure/build/quarkus-app/*.jar /app/build/quarkus-app/
COPY --chown=1001 --from=build /app/infrastructure/build/quarkus-app/*.txt /app/build/quarkus-app/
COPY --chown=1001 --from=build /app/infrastructure/build/quarkus-app/app/ /app/build/quarkus-app/app/
COPY --chown=1001 --from=build /app/infrastructure/build/quarkus-app/quarkus/ /app/build/quarkus-app/quarkus/

USER 1001
EXPOSE 8044

ENTRYPOINT [ "java", "-jar", "build/quarkus-app/quarkus/quarkus-run.jar" ]
