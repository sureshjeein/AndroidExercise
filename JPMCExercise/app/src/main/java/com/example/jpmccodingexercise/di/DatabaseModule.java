package com.example.jpmccodingexercise.di;

import android.app.Application;

import androidx.room.Room;

import com.example.jpmccodingexercise.BuildConfig;
import com.example.jpmccodingexercise.db.AppDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
class DatabaseModule {
    @Provides
    @Singleton
    AppDatabase provideAppDatabase(Application application) {
        return Room.databaseBuilder(application, AppDatabase.class, BuildConfig.DATABASE_NAME).build();
    }
}
