package cn.aft.weather.interactor;

import com.hwangjr.rxbus.RxBus;

import javax.inject.Inject;

import cn.aft.weather.event.CitiesLoadedEvent;
import cn.aft.weather.event.EventType;
import cn.aft.weather.interactor.cities.Loader;
import cn.aft.weather.interactor.cities.WeatherCities;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 2016/02/25 by congtaowang.
 * Version 1.0
 */
public class InteractorImpl implements Interactor {

    @Override
    public void loadCities(Loader loader) {
        loader.load().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.newThread())
                .doOnNext(new Action1<WeatherCities>() {
                    @Override
                    public void call(WeatherCities weatherCities) {

                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WeatherCities>() {

                    @Inject
                    CitiesLoadedEvent event;

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        CitiesLoadedEvent event = new CitiesLoadedEvent(null, EventType.USELESS);
                        RxBus.get().post(event);
                    }

                    @Override
                    public void onNext(WeatherCities weatherCities) {
                        CitiesLoadedEvent event = new CitiesLoadedEvent(weatherCities, EventType.USEFUL);
                        RxBus.get().post(event);
                    }
                });
    }
}
