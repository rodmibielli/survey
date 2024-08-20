FROM openjdk:17-oracle
ADD ./survey.jar survey.jar
ENTRYPOINT ["java","-jar","survey.jar"]