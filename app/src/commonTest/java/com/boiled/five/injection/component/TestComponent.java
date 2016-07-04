package com.boiled.five.injection.component;

import javax.inject.Singleton;

import dagger.Component;
import com.boiled.five.injection.module.ApplicationTestModule;

@Singleton
@Component(modules = ApplicationTestModule.class)
public interface TestComponent extends ApplicationComponent {

}
