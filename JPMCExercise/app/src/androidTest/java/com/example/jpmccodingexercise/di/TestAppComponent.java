package com.example.jpmccodingexercise.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Component(modules = {AndroidInjectionModule.class, BuildersModule.class, TestNetworkModule.class,
        DatabaseModule.class, RepositoryModule.class})
@Singleton
interface TestAppComponent extends AppComponent {
    @Component.Builder()
    interface Builder {
        AppComponent build();
        @BindsInstance
        TestAppComponent.Builder application(Application application);
    }
}
