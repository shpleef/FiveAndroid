package com.boiled.five.injection.component;

import android.app.Application;
import android.content.Context;

import com.boiled.five.BoiledApplication;
import com.boiled.five.data.DataManager;
import com.boiled.five.data.local.PreferencesHelper;
import com.boiled.five.data.remote.AndroidBoilerplateService;
import com.boiled.five.injection.ApplicationContext;
import com.boiled.five.injection.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(BoiledApplication boiledApplication);

    @ApplicationContext
    Context context();
    Application application();
    AndroidBoilerplateService androidBoilerplateService();
    PreferencesHelper preferencesHelper();
    DataManager dataManager();

}
