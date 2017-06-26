FROM armv7/armhf-ubuntu_core

VOLUME /tmp
ADD maven/@docker.project.name@.jar @docker.project.name@.jar
ENV DEBIAN_FRONTEND noninteractive
ENV WEATHER_CITY_NAME Zlín
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/@docker.project.name@.jar", "--weather.city.name=${WEATHER_CITY_NAME}"]