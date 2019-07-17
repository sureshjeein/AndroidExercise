package com.example.jpmccodingexercise.di;

import android.app.Application;

import com.example.jpmccodingexercise.app.App;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Component(modules = {AndroidInjectionModule.class, BuildersModule.class, NetworkModule.class,
                        DatabaseModule.class, RepositoryModule.class})
@Singleton
public interface AppComponent {
    void inject(App app);

    @Component.Builder()
    interface Builder {
        AppComponent build();
        @BindsInstance
        Builder application(Application application);
    }
}
