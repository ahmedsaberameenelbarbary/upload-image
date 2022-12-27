FROM maven:3.8.5-openjdk-17 AS builder

WORKDIR /opt/app

COPY pom.xml .

RUN mvn dependency:go-offline \
  -B -Dorg.slf4j.simpleLogger.log.org.apache.maven.cli.transfer.Slf4jMavenTransferListener=warn

COPY . .

RUN mvn clean install \
  -B -Dorg.slf4j.simpleLogger.log.org.apache.maven.cli.transfer.Slf4jMavenTransferListener=warn \
  -DskipTests

FROM openjdk:17-alpine

WORKDIR /opt/app

RUN apk update \
 && apk upgrade \
 && apk add fontconfig \
 && apk add ttf-dejavu
RUN ln -s /usr/lib/libfontconfig.so.1 /usr/lib/libfontconfig.so && \
    ln -s /lib/libuuid.so.1 /usr/lib/libuuid.so.1 && \
    ln -s /lib/libc.musl-x86_64.so.1 /usr/lib/libc.musl-x86_64.so.1
ENV LD_LIBRARY_PATH /usr/lib

COPY --from=builder /opt/app/target/Picture-Publishing-Service.jar ./

ENTRYPOINT sh -c 'java -jar Picture-Publishing-Service.jar'

# ENTRYPOINT java $JAVA_OPTIONS -XX:+UseParallelGC -XX:MinHeapFreeRatio=20 -XX:MaxHeapFreeRatio=40 -XX:GCTimeRatio=4 -XX:AdaptiveSizePolicyWeight=90 -XX:MaxMetaspaceSize=500m -XX:+ExitOnOutOfMemoryError -XX:PermSize=25m -XX:MaxPermSize=1024m -Duser.timezone=Asia/Riyadh -Djava.security.egd=file:/dev/./urandom  -jar /app.jar
