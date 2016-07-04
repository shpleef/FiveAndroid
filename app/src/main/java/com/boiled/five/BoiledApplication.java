package com.boiled.five;

import android.app.Application;
import android.content.Context;

import com.boiled.five.injection.component.ApplicationComponent;
import com.boiled.five.injection.component.DaggerApplicationComponent;
import com.boiled.five.injection.module.ApplicationModule;

import timber.log.Timber;

public class BoiledApplication extends Application {

    ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) Timber.plant(new Timber.DebugTree());

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        mApplicationComponent.inject(this);
    }

    public static BoiledApplication get(Context context) {
        return (BoiledApplication) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
