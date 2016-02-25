package cn.aft.weather.ui.presenter;

import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.thread.EventThread;

import cn.aft.weather.event.CitiesLoadedEvent;
import cn.aft.weather.event.WeatherDetailLoadedEvent;
import cn.aft.weather.interactor.InteractorProxy;
import cn.aft.weather.interactor.cities.AssertLoader;
import cn.aft.weather.ui.iview.IWeatherView;
import cn.aft.weather.net.RxApiImpl;
import cn.aft.weather.utils.EventPredictor;

/**
 * 2016/02/25 by congtaowang.
 * Version 1.0
 */
public class WeatherPresenter extends BasePresenterDecorator<IWeatherView> {

    public void loadWeatherDetail(String cityID) {
        InteractorProxy.getProxy().loadCities(new AssertLoader());
        RxApiImpl.loadWeatherDetail(cityID);
    }

    @Subscribe(
            thread = EventThread.MAIN_THREAD
    )
    public void onCitiesLoaded(CitiesLoadedEvent event) {
        if (isViewAttached()) {
            if (EventPredictor.isUsefulEvent(event)) {
                getView().showToastMsg("success");
            } else {
                getView().showToastMsg("Fail");
            }
        }
    }

    @Subscribe(
            thread = EventThread.MAIN_THREAD
    )
    public void onWeatherDetailLoaded(WeatherDetailLoadedEvent event) {
        if (isViewAttached()) {
            if (EventPredictor.isUsefulEvent(event)) {
                getView().setWeatherDetail(event.getWeatherDetail());
            } else {
                getView().showToastMsg("");
            }
        }
    }
}
