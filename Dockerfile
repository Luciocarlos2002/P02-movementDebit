FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ms-movementDebit.jar
ENTRYPOINT ["java","-jar","/ms-movementDebit.jar"]