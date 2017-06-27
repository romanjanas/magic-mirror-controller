package cz.janas.mirror.service.weather.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by roman on 26/06/17.
 */
public class WeatherData {
    private double temperature;
    private String conditions;
    private String iconId;
    private Result result;

    public WeatherData() {
        this.conditions = null;
        this.iconId = null;
        this.result = new Result(1,"empty result");
    }

    public WeatherData(double temperature, String conditions, String iconId) {
        this.temperature = temperature;
        this.conditions = conditions;
        this.iconId = iconId;
        this.result = new Result(1,"empty result");
    }

    public WeatherData(double temperature, String conditions, String iconId, Result result) {
        this.temperature = temperature;
        this.conditions = conditions;
        this.iconId = iconId;
        this.result = result;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getIconId() {
        return iconId;
    }

    public void setIconId(String iconId) {
        this.iconId = iconId;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "temperature=" + temperature +
                ", conditions='" + conditions + '\'' +
                ", iconId='" + iconId + '\'' +
                ", result=" + result +
                '}';
    }
}
