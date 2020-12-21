FROM openjdk:8
ADD drunker-web/build/libs/drunker.jar drunker.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "drunker.jar"]