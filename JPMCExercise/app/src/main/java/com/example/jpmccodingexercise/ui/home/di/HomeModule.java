package com.example.jpmccodingexercise.ui.home.di;

import androidx.lifecycle.ViewModelProviders;

import com.example.jpmccodingexercise.ui.home.HomeActivity;
import com.example.jpmccodingexercise.ui.home.HomeViewModel;
import com.example.jpmccodingexercise.ui.home.HomeViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeModule {
    @Provides
    @HomeScope
    HomeViewModel provideHomeViewModel(HomeViewModelFactory
                                               homeViewModelFactory, HomeActivity homeActivity) {
        return ViewModelProviders.of(homeActivity, homeViewModelFactory).get(HomeViewModel.class);
    }
}
