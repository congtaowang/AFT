package cn.aft.weather.net;

import com.hwangjr.rxbus.RxBus;

import cn.aft.tools.Predictor;
import cn.aft.weather.event.EventType;
import cn.aft.weather.event.WeatherDetailLoadedEvent;
import cn.aft.weather.net.result.Weather;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 2016/02/25 by congtaowang.
 * Version 1.0
 */
public class RxApiImpl {

    public static Subscription loadWeatherDetail(String cityID) {

        return RxApiService.getApiService().loadWeatherDetail(cityID)
                .subscribeOn(Schedulers.newThread())
                .doOnNext(new Action1<Weather>() {
                    @Override
                    public void call(Weather weather) {
                        //Do something time-consuming
                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Weather>() {
                    @Override
                    public void call(Weather weather) {
                        WeatherDetailLoadedEvent event;
                        if (Predictor.isNotNull(weather)) {
                            if (weather.getStatus() == 1000) {
                                event = new WeatherDetailLoadedEvent(weather, EventType.USEFUL);
                            } else {
                                event = new WeatherDetailLoadedEvent(null, EventType.USELESS);
                            }
                        } else {
                            event = new WeatherDetailLoadedEvent(null, EventType.USELESS);
                        }
                        RxBus.get().post(event);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        WeatherDetailLoadedEvent event = new WeatherDetailLoadedEvent(null, EventType.USELESS);
                        RxBus.get().post(event);
                    }
                });
    }
}
