package cn.aft.weather.ui;

import cn.aft.framework.mvp.BaseMvpActivity;
import cn.aft.weather.R;
import cn.aft.weather.net.result.Weather;
import cn.aft.weather.ui.iview.IWeatherView;
import cn.aft.weather.ui.presenter.WeatherPresenter;

/**
 * 2016/02/25 by congtaowang.
 * Version 1.0
 */
public class MainActivity extends BaseMvpActivity<IWeatherView, WeatherPresenter> implements IWeatherView {

    @Override
    protected WeatherPresenter createPresenterInstance() {
        return new WeatherPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onViewCreated() {
        _presenter.loadWeatherDetail("101010100");
    }

    @Override
    public void setWeatherDetail(Weather weatherDetail) {

    }
}
