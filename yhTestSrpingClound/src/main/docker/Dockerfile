FROM java:8
VOLUME /opt/spring-cloud-web
ADD spring-cloud-web.jar /opt/spring-cloud-web.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/spring-cloud-web.jar"]
