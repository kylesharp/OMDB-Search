package com.kpsharp.omdbsearch.modules;

import com.kpsharp.omdbsearch.ui.MovieListActivity;
import com.kpsharp.omdbsearch.ui.movielist.MovieListItemViewHolder;
import com.kpsharp.omdbsearch.ui.movielist.MovieListPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules={PresenterModule.class, UtilModule.class})
public interface ApplicationComponent {

    void inject(MovieListActivity movieListActivity);

    void inject(MovieListPresenter movieListPresenter);

    void inject(MovieListItemViewHolder movieListItemViewHolder);
}
