FROM java:8
VOLUME /opt/spring-cloud-config
ADD spring-cloud-config.jar /spring-cloud-config.jar
USER root
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "/opt/spring-cloud-config.jar"]
