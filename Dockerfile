FROM    openjdk:11-alpine AS build
WORKDIR /app

# copy gradle only files over
COPY    gradlew gradlew
COPY    gradle/ gradle/
RUN     .gradlew --version

# copy project build files over
COPY    build.gradle        build.gradle
COPY    settings.gradle     settings.gradle
COPY    gradle.properties   gradle.properties

# download dependencies only
RUN     ./gradlew assemble

# copy full solution and build
COPY . .
RUN     ./gradlew assemble

# take a smaller runtime image for the final output
FROM alpine:latest

COPY --from=build /app/web-ui/build/libs/*.jar app/libs/
CMD
