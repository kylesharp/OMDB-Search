package com.kpsharp.omdbsearch.modules;

import com.kpsharp.omdbsearch.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules={PresenterModule.class, UtilModule.class})
public interface ApplicationComponent {

    void inject(MainActivity mainActivity);
}
