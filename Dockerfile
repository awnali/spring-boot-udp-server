FROM openjdk:8-jdk-alpine

WORKDIR /usr/app

COPY ./target/UdpConsumer-0.0.1-SNAPSHOT.jar ./

CMD ["java", "-jar", "UdpConsumer-0.0.1-SNAPSHOT.jar"]

