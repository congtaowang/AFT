package cn.aft.weather.interactor.cities;

import rx.Observable;

/**
 * 2016/02/24 by congtaowang.
 * Version 1.0
 */
public interface Loader {

    Observable<WeatherCities> load();
}
