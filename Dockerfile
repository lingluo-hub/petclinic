FROM azul/zulu-openjdk:17.0.6
ARG JAR_FILE=build/libs/petclinic-3.0.0.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]