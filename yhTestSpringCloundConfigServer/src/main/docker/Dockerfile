FROM java:8
VOLUME /opt/spring-cloud-config
ADD yh-test-web-1.0-SNAPSHOT.jar /spring-cloud-config.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/spring-cloud-config.jar"]
