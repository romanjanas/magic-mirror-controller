package cz.janas.mirror.service.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WeatherService {

    @Autowired
    WeatherHandler weatherHandler;

    @Scheduled(fixedDelay =  5 * 60 * 1000)
    public void sendWeatherUpdate() {
        weatherHandler.updateWeather();
    }
}
