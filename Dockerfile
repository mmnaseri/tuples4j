FROM ubuntu:bionic
RUN apt-get update \
    && apt-get install openjdk-8-jdk -y --no-install-recommends \
    && apt-get install maven -y --no-install-recommends \
    && apt-get clean && rm -rf /var/lib/apt/lists/*
VOLUME /src
WORKDIR /src
CMD "bash"