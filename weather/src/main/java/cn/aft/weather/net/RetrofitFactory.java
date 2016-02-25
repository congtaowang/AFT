package cn.aft.weather.net;

import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import cn.aft.weather.config.NetConfig;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * 2016/02/25 by congtaowang.
 * Version 1.0
 */
public class RetrofitFactory {

    private static Retrofit _retrofit;

    static {
        OkHttpClient httpClient = new OkHttpClient();
        httpClient.setConnectTimeout(NetConfig.CONNECT_TIMEOUT_60S, TimeUnit.SECONDS);
        _retrofit = new Retrofit.Builder()
                .baseUrl(Api.Domain)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();
    }

    public static Retrofit getRetrofit() {
        return _retrofit;
    }
}
