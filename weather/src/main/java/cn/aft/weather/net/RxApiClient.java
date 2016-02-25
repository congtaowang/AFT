package cn.aft.weather.net;

/**
 * 2016/02/25 by congtaowang.
 * Version 1.0
 */
public class RxApiClient {

    private static RxApi _apiService;

    static{
        _apiService = RetrofitFactory.getRetrofit().create(RxApi.class);
    }

    public static RxApi getApiService() {
        return _apiService;
    }
}
