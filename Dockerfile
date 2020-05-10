FROM ubuntu:bionic
RUN apt-get update \
    && apt-get install sudo=1.8.21p2-3ubuntu1.2 -y --no-install-recommends \
    && apt-get install openjdk-8-jdk=8u252-b09-1~18.04 -y --no-install-recommends \
    && apt-get install maven=3.6.0-1~18.04.1 -y --no-install-recommends \
    && apt-get clean && rm -rf /var/lib/apt/lists/*
VOLUME /src
WORKDIR /src
CMD "bash"