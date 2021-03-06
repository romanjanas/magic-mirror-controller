/*jslint devel: true */
/*global  WebSocket: false */
var startWeatherWS = function(weatherWSUrl) {
    var weatherSocket = new WebSocket("ws://" + weatherWSUrl + ":8080/weather");
    weatherSocket.onmessage = function (weatherEvent) {
        "use strict";
        console.log('incoming message: ' + weatherEvent.data);
        var weatherData = JSON.parse(weatherEvent.data),
            icon = '<i class="' + weatherData.iconClass + '"></i>',
            temp = '<i class="fa fa-thermometer-half" aria-hidden="true"></i> ' + weatherData.temperature,
            conditions = weatherData.conditions;

        document.getElementById('weather-icon').innerHTML = icon;
        document.getElementById('weather-temperature').innerHTML = temp;
        document.getElementById('weather-conditions').innerHTML = conditions;
    };
};