package com.kpsharp.omdbsearch.modules;

import com.kpsharp.omdbsearch.ui.movielist.MovieListActivity;
import com.kpsharp.omdbsearch.ui.movielist.MovieListItemViewHolder;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules={PresenterModule.class, UtilModule.class})
public interface ApplicationComponent {

    // region Injects

    void inject(MovieListActivity movieListActivity);

    void inject(MovieListItemViewHolder movieListItemViewHolder);

    // endregion
}
