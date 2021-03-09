package com.du.technicaltest.di.component;

import android.app.Application;


import com.du.technicaltest.AppController;
import com.du.technicaltest.di.module.ActivityModule;
import com.du.technicaltest.di.module.ApiModule;
import com.du.technicaltest.di.module.ViewModelModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;


/*
 * We mark this interface with the @Component annotation.
 * And we define all the modules that can be injected.
 * Note that we provide AndroidSupportInjectionModule.class
 * here. This class was not created by us.
 * It is an internal class in Dagger 2.10.
 * Provides our activities and fragments with given module.
 * */
@Component(modules = {
                ApiModule.class,
                ViewModelModule.class,
                ActivityModule.class,
                AndroidSupportInjectionModule.class})

@Singleton
public interface AppComponent{
    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }
    //void inject(AppController appController);
}


