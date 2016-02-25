package cn.aft.weather.event;

import cn.aft.weather.net.result.Weather;

/**
 * 2016/02/25 by congtaowang.
 * Version 1.0
 */
public class WeatherDetailLoadedEvent extends Event {

    private Weather weatherDetail;

    public WeatherDetailLoadedEvent(Weather weatherDetail,EventType eventType) {
        super(eventType);
        this.weatherDetail = weatherDetail;
    }

    public Weather getWeatherDetail() {
        return weatherDetail;
    }

    public void setWeatherDetail(Weather weatherDetail) {
        this.weatherDetail = weatherDetail;
    }
}
