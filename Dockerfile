FROM adoptopenjdk/openjdk11

EXPOSE 8080

ADD ./build/libs/*.jar authorizationService.jar

ENTRYPOINT ["java","-jar","/authorizationService.jar"]