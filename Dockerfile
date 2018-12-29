FROM javatechy/openjdk-8-slim

MAINTAINER Raul Astudillo <onimurasame@gmail.com>

EXPOSE 8081

ADD myresume-${BUILD_VERSION}.jar myresume.jar

ENTRYPOINT exec java -jar /myresume.jar