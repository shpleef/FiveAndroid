package com.boiled.five.injection.module;

import android.app.Application;
import android.content.Context;

import com.boiled.five.data.remote.AndroidBoilerplateService;
import com.boiled.five.injection.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Provide application-level dependencies. Mainly singleton object that can be injected from
 * anywhere in the app.
 */
@Module
public class ApplicationModule {
    protected final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    AndroidBoilerplateService provideAndroidBoilerplateService() {
        return AndroidBoilerplateService.Factory.makeAndroidBoilerplateService(mApplication);
    }

}