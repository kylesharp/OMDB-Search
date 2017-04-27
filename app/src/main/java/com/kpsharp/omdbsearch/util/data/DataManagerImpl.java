package com.kpsharp.omdbsearch.util.data;

import com.kpsharp.omdbsearch.models.Movie;
import com.kpsharp.omdbsearch.util.network.NetworkManager;
import com.kpsharp.omdbsearch.util.network.responses.MovieSearchItem;
import com.kpsharp.omdbsearch.util.network.responses.MovieSearchResponse;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.subjects.BehaviorSubject;

public class DataManagerImpl implements DataManager {

    // region Variables

    private NetworkManager mNetworkManager;

    // IMPORTANT: Use getSearchSubscription instead of directly accessing this
    private BehaviorSubject<List<Movie>> mBehaviorSubject;

    // endregion

    // region Lifecycle

    public DataManagerImpl(NetworkManager networkManager) {

        mNetworkManager = networkManager;
    }

    // endregion

    // region DataManager

    // This is a public method, but we also lazily load mBehaviorSubject, so we need to use this inside this class instead of direct access
    @Override
    @NonNull
    public BehaviorSubject<List<Movie>> getSearchSubscription() {

        if (mBehaviorSubject == null) {

            mBehaviorSubject = BehaviorSubject.create();
        }

        return mBehaviorSubject;
    }

    @Override
    public void searchForMovies(@Nullable final String titleQuery) {

        getSearchSubscription().onNext(transformNetworkResponse(mNetworkManager.searchMovies(titleQuery)));
    }

    // endregion

    // region Data Transforms

    // Transforms a network response into a model response
    @NonNull
    private List<Movie> transformNetworkResponse(@NonNull MovieSearchResponse movieSearchResponse) {

        List<Movie> movieList = new ArrayList<>();

        for (MovieSearchItem movieSearchItem : movieSearchResponse.movieSearchItemList) {

            movieList.add(new Movie(movieSearchItem.title, movieSearchItem.poster, movieSearchItem.imdbId));
        }

        return movieList;
    }

    // endregion
}
