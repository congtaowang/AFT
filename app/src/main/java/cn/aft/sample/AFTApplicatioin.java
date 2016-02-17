package cn.aft.sample;

import android.app.Application;

import cn.aft.sample.tools.Initor;

/**
 * 16/1/26 by congtaowang.
 * Version 1.0
 */
public class AFTApplicatioin extends Application {

    private static AFTApplicatioin instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Initor.init(this);
    }

    public static AFTApplicatioin getInstance() {
        return instance;
    }
}
