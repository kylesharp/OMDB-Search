package com.kpsharp.omdbsearch.util.data;

import com.kpsharp.omdbsearch.models.Movie;
import com.kpsharp.omdbsearch.util.network.NetworkManager;
import com.kpsharp.omdbsearch.util.network.responses.MovieSearchItem;
import com.kpsharp.omdbsearch.util.network.responses.MovieSearchResponse;

import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.subjects.BehaviorSubject;

public class DataManagerImpl implements DataManager {

    private NetworkManager mNetworkManager;

    private BehaviorSubject<List<Movie>> mBehaviorSubject;

    public DataManagerImpl(NetworkManager networkManager) {

        mNetworkManager = networkManager;
    }

    // This is a public method, but we also lazily load mBehaviorSubject, so we need to use this everywhere instead of direct access
    @Override
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

    // Transforms a network response into a model response
    private List<Movie> transformNetworkResponse(MovieSearchResponse movieSearchResponse) {

        List<Movie> movieList = new ArrayList<>();

        for (MovieSearchItem movieSearchItem : movieSearchResponse.movieSearchItemList) {

            movieList.add(new Movie(movieSearchItem.title, movieSearchItem.poster));
        }

        return movieList;
    }
}
