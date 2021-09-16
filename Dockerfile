FROM openjdk:11
MAINTAINER Dzmitry Parkheichuk <dzmitry_parkheichuk@epam.com>
ENV APP_HOME=/usr/app

WORKDIR $APP_HOME

# copy gradle only files and download grale
ADD    gradlew   $APP_HOME
ADD    gradle    $APP_HOME/gradle

RUN     ./gradlew --version

# copy project web-ui build files
ADD    build.gradle    settings.gradle     gradle.properties   $APP_HOME
ADD    web-ui/                 $APP_HOME/web-ui
ADD    common/                 $APP_HOME/common

## download dependencies and compile test classes
RUN ./gradlew testClasses

ENTRYPOINT /usr/app/gradlew :web-ui:test -Dbrowser=$BROWSER -Dgrid=$GRID -Dhub-host=$HUBHOST


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

