FROM maven:3.6.3-openjdk-8 AS compiler

WORKDIR /server
COPY ./ .
RUN mvn clean install

FROM openjdk:8-jdk

WORKDIR /bin
COPY --from=compiler /server/target/backend-0.0.1.jar .

EXPOSE 8080

CMD ["java","-Dspring.profiles.active=docker","-jar","/bin/backend-0.0.1.jar"]
