FROM java:8
VOLUME /opt/spring-cloud-eureka
ADD spring-cloud-eureka.jar /opt/spring-cloud-eureka.jar
USER root
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "/opt/spring-cloud-eureka.jar"]
