FROM openjdk:17
EXPOSE 9191
ADD ./build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]