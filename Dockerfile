FROM openjdk:17
ADD ./survey.jar survey.jar
ENTRYPOINT ["java","-jar","survey.jar"]