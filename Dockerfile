FROM azul/zulu-openjdk:17.0.6
RUN addgroup --system spring && adduser petclinic && adduser petclinic spring
USER spring:spring
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]