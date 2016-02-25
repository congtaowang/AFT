package cn.aft.weather.interactor.cities;

import java.util.List;

/**
 * 2016/02/24 by congtaowang.
 * Version 1.0
 */
public class WeatherCities {

    private List<Province> cities;

    public WeatherCities() {
    }

    public List<Province> getCities() {
        return cities;
    }

    public void setCities(List<Province> cities) {
        this.cities = cities;
    }
}
