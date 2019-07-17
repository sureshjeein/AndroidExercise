package com.example.jpmccodingexercise.di;

import com.example.jpmccodingexercise.app.App;

public class TestApp extends App {
    @Override
    public void onCreate() {
        super.onCreate();
        DaggerTestAppComponent.builder()
                .application(this)
                .build()
                .inject(this);
    }
}
