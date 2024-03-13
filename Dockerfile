FROM maven:3.8.4-openjdk-17 as builder
WORKDIR /app
COPY . /app/.
RUN mvn -f /app/pom.xml clean package -Dmaven.test.skip=true

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar /app/*.jar
EXPOSE 6060
ENTRYPOINT ["java", "-jar", "/app/*.jar"]


#FROM openjdk:17.0.1-jdk-slim
#MAINTAINER delivery_post_service.com
## #if you want to specify jar-file in console use next 3 lines and add after 'docker build'
## #next line '--build-arg JAR_FILE=target/*.jar' for maven build
##ARG JAR_FILE=target/*.jar
##COPY ${JAR_FILE} app.jar
##ENTRYPOINT ["java","${JAVA_OPTS}","-jar","/app.jar"]
## # otherwise directly specify jar
#
#COPY target/*.jar delivery_post_service.jar
#EXPOSE 6060 5432
#ENTRYPOINT ["java","-Dspring.profile.active=test" ,"-jar","delivery_post_service.jar"]
