# Prepare environment
FROM alpine:3.21
RUN apk add openjdk21

# Download source code
RUN git clone https://github.com/MCBanners/banner-api.git /app
WORKDIR /app

# Build the source into a binary
RUN ./gradlew clean build shadowJar

# Package the application
ENV BANNERAPI_MARIADB_NAME=""
ENV BANNERAPI_MARIADB_USER=""
ENV BANNERAPI_MARIADB_PASS=""
ENV BANNERAPI_JWT_SECRET=""
CMD /bin/sh -c "BANNERAPI_MARIADB_NAME=$BANNERAPI_MARIADB_NAME BANNERAPI_MARIADB_USER=$BANNERAPI_MARIADB_USER BANNERAPI_MARIADB_PASS=$BANNERAPI_MARIADB_PASS BANNERAPI_JWT_SECRET=$BANNERAPI_JWT_SECRET java -Xms128M -Xmx128M -jar build/libs/bannerapi.jar"