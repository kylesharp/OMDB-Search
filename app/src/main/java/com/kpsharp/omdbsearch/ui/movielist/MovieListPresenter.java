package com.kpsharp.omdbsearch.ui.movielist;

import com.kpsharp.omdbsearch.ui.base.BasePresenter;

import android.support.annotation.Nullable;

public class MovieListPresenter extends BasePresenter<MovieListMvp.View> implements MovieListMvp.Presenter {

    // region BasePresenterMvp.Presenter

    @Override
    public void subscribeToObservables() {

    }

    @Override
    public void unsubscribeFromObservables() {

    }

    // endregion

    // region MovieListMvp.Presenter

    @Override
    public void userSearchedForMovie(@Nullable String movieTitle) {
    }

    // endregion
}
