package cn.aft.weather.net;

import cn.aft.weather.net.result.Weather;
import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * 2016/02/25 by congtaowang.
 * Version 1.0
 */
public interface RxApi {

    /**
     * Get city's weather detail information by cityId
     *
     * @param cityID The id of city
     * @return
     */
    @GET(Api.Weather)
    Observable<Weather> loadWeatherDetail(@Query("citykey") String cityID);
}
