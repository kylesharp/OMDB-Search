package com.kpsharp.omdbsearch.ui.movielist;

import com.kpsharp.omdbsearch.ui.base.BaseMvp;
import com.kpsharp.omdbsearch.ui.models.Movie;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

public interface MovieListMvp extends BaseMvp {

    interface View extends BaseView {

        /**
         * Tells the view to update the UI with the new list of movies
         * @param movieList A list of {@link Movie} movies to be displayed, can be empty but not null
         */
        void updateMovieList(@NonNull List<Movie> movieList);
    }

    interface Presenter extends BasePresenter<View> {

        /**
         * Called when the user searches for a movie based on title
         * @param movieTitle The {@link String} title that the user searched for, can be null
         */
        void userSearchedForMovie(@Nullable String movieTitle);
    }
}
