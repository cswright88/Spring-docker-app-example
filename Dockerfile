FROM openjdk:11-jre-slim AS demoVideo
ADD target/demo.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","demo.jar"]


