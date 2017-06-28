package cz.janas.mirror.service.weather;

import cz.janas.mirror.service.weather.entity.WeatherData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
class WeatherProvider {

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${weather.service.url:192.168.1.104}")
    private String weatherServiceUrl;

    WeatherData getWeather(String city) {
        ResponseEntity<WeatherData> weatherDataEntity = restTemplate.getForEntity(
                "http://" + weatherServiceUrl +":8081/weather/" + city,
                WeatherData.class);
        if (weatherDataEntity.getStatusCode() == HttpStatus.OK) {
            return weatherDataEntity.getBody();
        }
        return new WeatherData();
    }

}
