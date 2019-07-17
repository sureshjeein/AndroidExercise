package com.example.jpmccodingexercise.di;

import android.app.Application;

import com.example.jpmccodingexercise.BuildConfig;
import com.example.jpmccodingexercise.net.TypiCodeService;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Module
class NetworkModule {
    @Provides
    @Singleton
    Cache provideCache(Application application) {
        return new Cache(application.getCacheDir(), BuildConfig.CACHE_SIZE);
    }

    //Can create custom qualifiers or use named if we have two interceptors, e.g for auth
    @Provides
    @Singleton
    Interceptor provideHttpLoggingInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Cache cache, Interceptor httpLoggingInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .readTimeout(BuildConfig.API_TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(BuildConfig.API_TIMEOUT, TimeUnit.SECONDS)
                .cache(cache)
                .build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    TypiCodeService provideTypiCodeService(Retrofit retrofit) {
        return retrofit.create(TypiCodeService.class);
    }


}
