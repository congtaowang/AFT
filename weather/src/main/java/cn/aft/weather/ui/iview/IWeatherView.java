package cn.aft.weather.ui.iview;

import cn.aft.framework.mvp.BaseView;
import cn.aft.weather.net.result.Weather;

/**
 * 2016/02/25 by congtaowang.
 * Version 1.0
 */
public interface IWeatherView extends BaseView {

    void setWeatherDetail(Weather weatherDetail);
}
