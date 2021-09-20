FROM openjdk:11
MAINTAINER Dzmitry Parkheichuk <dzmitry_parkheichuk@epam.com>
ENV APP_HOME=/usr/app

WORKDIR $APP_HOME

# copy gradle only files and download grale
ADD    ../gradlew   $APP_HOME
ADD    ../gradle    $APP_HOME/gradle

RUN     ./gradlew --version

# copy project web-ui build files
ADD    ../build.gradle    settings.gradle     gradle.properties   docker.gradle $APP_HOME
ADD    ../web-ui                 $APP_HOME/web-ui
ADD    ../common                 $APP_HOME/common

## download dependencies and compile test classes
RUN ./gradlew testClasses
RUN ./gradlew assemble

CMD /usr/app/gradlew :web-ui:webtests -Dbrowser=$BROWSER -Dgrid=$GRID -Dhub-host=$HUB_HOST

# docker image rm pkt/rp-taf:1.1
# docker run -it -e BROWSER=opera --env GRID=true --env HUB_HOST=100.64.8.174 --name rp-taf pkt/rp-taf:1.1
# docker run -ti --rm --entrypoint=/bin/bash -e BROWSER=opera --env GRID=true --env HUB_HOST=100.64.8.174 --name rp-taf pkt/rp-taf:1.1
# docker run -ti --rm --entrypoint=/bin/bash -e BROWSER=opera --env GRID=true --env HUB_HOST=100.64.8.174 -v D:/app/build:/usr/app/build -v D:/app/common/build:/usr/app/common/build -v D:/app/web-ui/build:/usr/app/web-ui/build --name rp-taf pkt/rp-taf:1.1

# FROM alpine
# COPY --from=builder usr/local/openjdk-11 /java
# ENV JAVA_HOME=/java
# COPY --from=builder usr/app usr/app
# ENV JAVA_VERSION=11.0.12
# ENV PATH="${JAVA_HOME}/bin":$PATH

# docker image rm rp-taf
# docker build -t=shikofx/rp-taf .
# docker build -t rp-taf .
# docker run -it --rm -e BROWSER=firefox --env GRID=true --env HUBHOST=100.64.8.174 -v D:\epam\learn\rp-taf:\usr\app --name rp-taf shikofx/rp-taf
# PATH=/usr/local/openjdk-11/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin

