FROM adoptopenjdk/openjdk11:latest
EXPOSE 9090
RUN mkdir /opt/app
COPY target/spring-jwt-demo.jar /opt/app
CMD ["java", "-jar", "/opt/app/spring-jwt-demo.jar"]
