FROM openjdk:8-jdk-alpine
ADD target/Core_User-*.jar coreuser.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar", "coreuser.jar"]