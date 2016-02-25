package cn.aft.weather.event;

import cn.aft.weather.interactor.cities.WeatherCities;

/**
 * 2016/02/25 by congtaowang.
 * Version 1.0
 */
public class CitiesLoadedEvent extends Event {

    private WeatherCities cities;

    public CitiesLoadedEvent(WeatherCities cities, EventType eventType) {
        super(eventType);
        this.cities = cities;
    }

    public WeatherCities getCities() {
        return cities;
    }
}
