package com.pondthaitay.mvp.tweentyscoops.api;

import com.google.gson.GsonBuilder;
import com.pondthaitay.mvp.tweentyscoops.configuration.BuildConfiguration;
import com.pondthaitay.mvp.tweentyscoops.configuration.Config;

import java.util.concurrent.TimeUnit;

import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class BaseService<T> {
    private static final int TIMEOUT = 60;

    private String baseUrl;

    protected abstract Class<T> getApiClassType();

    private String getBaseUrl() {
        return baseUrl;
    }

    protected void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public T getApi(T api) {
        T t = api;
        if (t == null) {
            t = createApi();
        }
        return t;
    }

    private T createApi() {
        return getBaseRetrofitBuilder()
                .build()
                .create(getApiClassType());
    }

    private Retrofit.Builder getBaseRetrofitBuilder() {
        return new Retrofit.Builder()
                .baseUrl(getBaseUrl())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(addConverter())
                .client(getClient());
    }

    private Converter.Factory addConverter() {
        return GsonConverterFactory.create(new GsonBuilder().setPrettyPrinting().create());
    }

    private OkHttpClient getClient() {
        Config config = new BuildConfiguration();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        return builder
                .addInterceptor(getDefaultHttpLogging(config.isDebug()))
                .certificatePinner(getDefaultCertificatePinner())
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(chain -> {
                    Request original = chain.request();
                    Request.Builder requestBuilder = original.newBuilder();
                    if (config.userToken() != null)
                        requestBuilder.header("Authorization", config.userToken());
                    requestBuilder.header("device", "android");
                    requestBuilder.header("appversion", config.version());
                    requestBuilder.method(original.method(), original.body());
                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                }).build();
    }

    private HttpLoggingInterceptor getDefaultHttpLogging(boolean isLog) {
        if (isLog) {
            return new HttpLoggingInterceptor(new HttpLogger()).setLevel(HttpLoggingInterceptor.Level.BODY);
        }
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE);
    }

    private CertificatePinner getDefaultCertificatePinner() {
        return new CertificatePinner.Builder().build();
    }

//    private Cache provideOkHttpCache(Context context) {
//        int cacheSize = 10 * 1024 * 1024;
//        return new Cache(context.getCacheDir(), cacheSize);
//    }
//
//    private Interceptor provideInterceptor(Context context) {
//        return chain -> {
//            Response response = chain.proceed(chain.request());
//            if (Utils.getInstance().isNetworkAvailable(context)) {
//                int maxAge = 60; // read from cache for 1 minute
//                return response.newBuilder()
//                        .header("Cache-Control", "public, max-age=" + maxAge)
//                        .build();
//            } else {
//                int maxStale = 60 * 60 * 24 * 28; // tolerate 4-weeks stale
//                return response.newBuilder()
//                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
//                        .build();
//            }
//        };
//    }
}
