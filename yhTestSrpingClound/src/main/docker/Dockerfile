FROM java:8
VOLUME /opt/spring-cloud-web
ADD yh-test-web-1.0-SNAPSHOT.jar /opt/spring-cloud-web.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/spring-cloud-web.jar"]
