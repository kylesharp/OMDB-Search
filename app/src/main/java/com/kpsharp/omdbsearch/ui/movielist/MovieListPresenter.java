package com.kpsharp.omdbsearch.ui.movielist;

import com.kpsharp.omdbsearch.models.Movie;
import com.kpsharp.omdbsearch.modules.DaggerUtil;
import com.kpsharp.omdbsearch.ui.base.BasePresenter;
import com.kpsharp.omdbsearch.util.data.DataManager;

import android.support.annotation.Nullable;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class MovieListPresenter extends BasePresenter<MovieListMvp.View> implements MovieListMvp.Presenter {

    // region Variables

    @Inject
    DataManager mDataManager;

    private Disposable mSearchDisposable;

    // endregion

    // region Lifecycle

    public MovieListPresenter() {

        DaggerUtil.getInstance().getApplicationComponent().inject(this);
    }

    // endregion

    // region BasePresenterMvp.Presenter

    @Override
    public void subscribeToObservables() {

        if (mSearchDisposable == null) {
            mSearchDisposable = mDataManager.getSearchSubscription().observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<Movie>>() {

                @Override
                public void accept(@NonNull List<Movie> movies) throws Exception {

                    if (isAttached()) {
                        getView().updateMovieList(movies);
                    }
                }
            });
        }
    }

    @Override
    public void unsubscribeFromObservables() {

        if (mSearchDisposable != null && !mSearchDisposable.isDisposed()) {
            mSearchDisposable.dispose();
            mSearchDisposable = null;
        }
    }

    // endregion

    // region MovieListMvp.Presenter

    @Override
    public void userSearchedForMovie(@Nullable String movieTitle) {

        mDataManager.searchForMovies(movieTitle);
    }

    // endregion
}
