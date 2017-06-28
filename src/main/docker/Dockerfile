FROM openjdk

VOLUME /tmp
ADD maven/@docker.project.name@.jar @docker.project.name@.jar
RUN sh -c 'touch @docker.project.name@.jar'
ENV WEATHER_CITY_NAME Zlin
ENV WEATHER_SERVICE_URL 192.168.1.104
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/@docker.project.name@.jar", "--weather.city.name=${WEATHER_CITY_NAME}", "--weather.service.url=${WEATHER_SERVICE_URL}"]