FROM openjdk:17

COPY target/springboot-restapi-mysql-example-0.0.1-SNAPSHOT.jar /springboot-restapi-mysql-example-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/springboot-restapi-mysql-example-0.0.1-SNAPSHOT.jar"]