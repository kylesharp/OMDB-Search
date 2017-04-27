package com.kpsharp.omdbsearch.ui.movielist;

import com.kpsharp.omdbsearch.modules.DaggerUtil;
import com.kpsharp.omdbsearch.ui.base.BasePresenter;
import com.kpsharp.omdbsearch.util.data.DataManager;

import android.support.annotation.Nullable;

import javax.inject.Inject;

public class MovieListPresenter extends BasePresenter<MovieListMvp.View> implements MovieListMvp.Presenter {

    // region Variables

    @Inject
    DataManager mDataManager;

    // endregion

    // region Lifecycle

    public MovieListPresenter() {

        DaggerUtil.getInstance().getApplicationComponent().inject(this);
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
