FROM openjdk:21
EXPOSE 8080
COPY build/libs/prices-data-0.0.1-SNAPSHOT.jar prices.jar
ENTRYPOINT ["java", "-jar", "/prices.jar"]