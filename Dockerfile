FROM ubuntu:bionic
RUN apt-get update
RUN apt-get install openjdk-8-jdk -y
RUN apt-get install maven -y
VOLUME /src
WORKDIR /src
CMD "bash"