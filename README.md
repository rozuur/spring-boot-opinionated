# spring-boot-opinionated
An opinionated setup of spring boot application

## Java
Uses Java 11

## Docker
[Distroless](https://github.com/GoogleContainerTools/distroless) is the base image.

As java is object-compatible, docker image is generated by copying the packaged jar.
This is preferred over multi-stage docker, as multi-stage docker [downloads internet](http://blog.flurdy.com/2014/11/dont-download-internet-share-maven-ivy-docker.html)

To build and run the application at port 8080 use `docker run --rm -it -p8080:8080 $(docker build -q .)`

## Local Development
Start the application at port 8080 and debug port 5005 using `mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005"`

Code is auto formatted during compilation using [formatter-maven-plugin](https://code.revelc.net/formatter-maven-plugin/) and [impsort-maven-plugin](https://code.revelc.net/impsort-maven-plugin/).

[maven-enforcer-plugin](https://maven.apache.org/enforcer/maven-enforcer-plugin/) is used to enforce `java` and `mvn` versions.

## Database
Liquibase is used for database changes. SQL changes are present at `src/main/resources/db/changelog`

For testing, liquibase is disabled and h2 is used. Database entities are generated from classes instead of running changelog scripts.

## Swagger
Swagger is exposed at **/swagger-ui.html**

## REST API
APIs are exposed with a prefix, here it is **/api/v1**

APIs returns data transfer objects instead of entities, to reduce coupling of models to database schema.

POST APIs should return **201 Created** with inserted resource 
PUT APIs should return updated resource

## Actuator

**actuator/health/readiness** is health check endpoint for load balancer

**actuator/health** shows health stats

**actuator/info** API exposes git state through [git-commit-id-plugin](https://github.com/git-commit-id/git-commit-id-maven-plugin)

**actuator/prometheus** API exposes metrics

**actuator/loggers** Used for changing log levels in runtime

## Static Analysis
Following plugins are used for static analysis

1. [maven-pmd-plugin](https://maven.apache.org/plugins/maven-pmd-plugin/)
2. [spotbugs-maven-plugin](https://spotbugs.github.io/spotbugs-maven-plugin/)
3. [modernizer-maven-plugin](https://github.com/gaul/modernizer-maven-plugin)

## Testing

**maven-surefire-plugin** runs tests through maven.

[jacoco-maven-plugin](https://www.eclemma.org/jacoco/trunk/doc/maven.html) is used for code coverage

## Release
`mvn deploy` fails if local modifications are present using **maven-scm-plugin**

**maven-release-plugin** is used in `tools/jenkins_build.sh` for release

**maven-deploy-plugin** is used for deploying to nexus repository if required 