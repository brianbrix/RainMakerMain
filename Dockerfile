#Build Stage
FROM maven:3.6.3-jdk-8  AS builder
#WORKDIR /app
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests=True
#RUN cd /home/app
#RUN ls
#COPY /home/app/target /app


#Run Stage
FROM openjdk:8-alpine
WORKDIR /app
RUN #cd /home/app/
RUN ls
COPY --from=builder /home/app/target/ /app/
RUN cd /app
RUN ls
#COPY /app ~/Documents/rainmaker
RUN #cp /app/rainmakerr-1.1.0.jar  /home/brianbrix/Documents/rainmaker
#EXPOSE 8082
ENTRYPOINT ["java","-jar", "/app/rainmakerr-1.1.0.jar"]

