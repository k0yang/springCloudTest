FROM java:8
VOLUME /opt/spring-cloud-eureka
ADD spring-cloud-eureka.jar /opt/spring-cloud-eureka.jar
USER root
EXPOSE 8761
EXPOSE 8762
EXPOSE 8763
ENTRYPOINT ["java", "-jar", "/opt/spring-cloud-eureka.jar"]
