
ROM openjdk:21
COPY target/hng-stage-one-0.0.1-SNAPSHOT.jar hng-stage-one-0.0.1-SNAPSHOT.jar
EXPOSE 9000
ENTRYPOINT ["java", "-jar", "hng-stage-one-0.0.1-SNAPSHOT.jar"]




NEW







