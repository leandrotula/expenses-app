FROM openjdk:11-jre-slim

ARG EXPENSES_API_VERSION

COPY target/app-${EXPENSES_API_VERSION}.jar /opt/expenses-api/expenses-api.jar

WORKDIR /opt/expenses-api
ENTRYPOINT ["java", "-Djsse.enableSNIExtension=false", "-jar", "expenses-api.jar"]