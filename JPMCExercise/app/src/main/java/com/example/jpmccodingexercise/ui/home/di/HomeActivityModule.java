package com.example.jpmccodingexercise.ui.home.di;

import com.example.jpmccodingexercise.ui.home.HomeActivity;

import dagger.Binds;
import dagger.Module;

@Module
abstract class HomeActivityModule {
    @Binds
    @HomeScope
    abstract HomeActivity provideHomeActivity(HomeActivity homeActivity);
}
