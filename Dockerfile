FROM gcr.io/distroless/java:11
COPY target/*-*.jar /app/service.jar
ENTRYPOINT ["java", "-jar", "/app/service.jar"]
