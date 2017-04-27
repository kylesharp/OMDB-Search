package com.kpsharp.omdbsearch.modules;

import com.kpsharp.omdbsearch.ui.MainActivity;
import com.kpsharp.omdbsearch.ui.movielist.MovieListPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules={PresenterModule.class, UtilModule.class})
public interface ApplicationComponent {

    void inject(MainActivity mainActivity);

    void inject(MovieListPresenter movieListPresenter);
}
