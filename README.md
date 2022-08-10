# quarkus-template

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Purpose

**Don't forget to change the app name !**

The purpose of this template is to guide you in creating a Splio compliant Quarkus app. 

You'll find example of how to use Quarkus with REST API, Kafka, Avro schema registy, Prometheus metrics, some tests...

A very important part of the template is the application.properties all configuration is explained and should allow you to have all the steps needed to do Splio stuff : 
- Log in ELK
- Add metrics in the Prometheus format for it to be scrapped
- A Gitlab-ci.yml that should run tests & use AutoDevOps 
- The usage of the Java linter we use at Splio !
- Connect to the Splio Kafka brokers
- Connect to the Splio MySQL servers
- Log errors into Sentry for alerting 
- Deploy your app in K8s


## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./gradlew quarkusDev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:

```shell script
./gradlew build
```

It produces the `quarkus-run.jar` file in the `build/quarkus-app/` directory. Be aware that it’s not an _über-jar_ as
the dependencies are copied into the `build/quarkus-app/lib/` directory.

## NATIVE

####  To deploy the application in native don't forget to add JVM_NATIVE=1 to your cicd env
