FROM java:8
VOLUME /opt/spring-cloud-eureka-service
ADD yh-test-web-1.0-SNAPSHOT.jar /opt/spring-cloud-eureka-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/spring-cloud-eureka-service.jar"]
