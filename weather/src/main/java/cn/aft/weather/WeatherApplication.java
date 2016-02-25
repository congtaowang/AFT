package cn.aft.weather;

import android.app.Application;

import cn.aft.tools.TipToast;

/**
 * 2016/02/25 by congtaowang.
 * Version 1.0
 */
public class WeatherApplication extends Application {

    private static WeatherApplication _app;

    @Override
    public void onCreate() {
        super.onCreate();
        _app = this;
        TipToast.init(_app);
    }

    public static WeatherApplication getApp() {
        return _app;
    }
}
