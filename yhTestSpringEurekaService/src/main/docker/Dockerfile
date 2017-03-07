FROM java:8
VOLUME /opt/spring-cloud-eureka-service
ADD spring-cloud-eureka-service.jar /opt/spring-cloud-eureka-service.jar
USER root
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/opt/spring-cloud-eureka-service.jar"]
