FROM openjdk:8
ADD com.vsu.drunker-web/build/libs/com.vsu.drunker-web.jar com.vsu.drunker.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "com.vsu.drunker.jar"]