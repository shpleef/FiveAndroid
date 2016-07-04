package com.boiled.five.injection.component;

import android.app.LauncherActivity;

import com.boiled.five.injection.PerActivity;
import com.boiled.five.injection.module.ActivityModule;
import com.boiled.five.ui.activity.CharacterActivity;
import com.boiled.five.ui.activity.DetailActivity;
import com.boiled.five.ui.activity.LoginActivity;
import com.boiled.five.ui.activity.MainActivity;
import com.boiled.five.ui.fragment.DetailFragment;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(LoginActivity loginActivity);
    void inject(LauncherActivity launcherActivity);
    void inject(MainActivity mainActivity);
    void inject(CharacterActivity characterActivity);
    void inject(DetailActivity detailActivity);

    void inject(DetailFragment detailFragment);
}

