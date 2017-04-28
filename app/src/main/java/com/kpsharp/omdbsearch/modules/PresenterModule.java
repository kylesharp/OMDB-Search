package com.kpsharp.omdbsearch.modules;

import com.kpsharp.omdbsearch.ui.movielist.MovieListPresenter;
import com.kpsharp.omdbsearch.util.data.DataManager;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    // region Lifecycle

    public PresenterModule() {
    }

    // endregion

    // region Provides

    @Provides
    MovieListPresenter providesMovieListPresenter(DataManager dataManager) {

        return new MovieListPresenter(dataManager);
    }

    // endregion
}
