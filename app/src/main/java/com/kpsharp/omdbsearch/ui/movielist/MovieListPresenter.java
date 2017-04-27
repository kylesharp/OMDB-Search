package com.kpsharp.omdbsearch.ui.movielist;

import com.kpsharp.omdbsearch.ui.base.BasePresenter;
import com.kpsharp.omdbsearch.util.data.DataManager;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class MovieListPresenter extends BasePresenter<MovieListMvp.View> implements MovieListMvp.Presenter {

    // region Variables

    private DataManager mDataManager;

    // endregion

    // region Lifecycle

    public MovieListPresenter(@NonNull DataManager dataManager) {

        mDataManager = dataManager;
    }

    // endregion

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
