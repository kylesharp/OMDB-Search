package com.kpsharp.omdbsearch.modules;

import com.kpsharp.omdbsearch.ui.movielist.MovieListPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    public PresenterModule() {
    }

    @Provides
    MovieListPresenter providesMovieListPresenter() {

        return new MovieListPresenter();
    }
}
