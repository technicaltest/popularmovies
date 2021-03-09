package com.du.technicaltest.di.module;



import com.du.technicaltest.ui.activity.PopularMoviesActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector()
    abstract PopularMoviesActivity contributePopularMoviesActivity();
}