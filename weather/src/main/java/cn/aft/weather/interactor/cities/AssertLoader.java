package cn.aft.weather.interactor.cities;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import cn.aft.tools.Predictor;
import cn.aft.weather.WeatherApplication;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * 2016/02/24 by congtaowang.
 * Version 1.0
 */
public class AssertLoader implements Loader {

    @Override
    public Observable<WeatherCities> load() {

        return Observable.create(new Observable.OnSubscribe<WeatherCities>() {
            @Override
            public void call(Subscriber<? super WeatherCities> subscriber) {
                try {
                    InputStream is = WeatherApplication.getApp().getAssets().open("cities.json");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                    String line;
                    StringBuilder builder = new StringBuilder();
                    while ((Predictor.isNotNull(line = reader.readLine()))) {
                        builder.append(line);
                    }
                    is.close();
                    WeatherCities weatherCities = new Gson().fromJson(builder.toString(), WeatherCities.class);
                    subscriber.onNext(weatherCities);
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        }).subscribeOn(Schedulers.io());
    }
}
