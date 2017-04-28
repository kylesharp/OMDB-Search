package com.kpsharp.omdbsearch.util.network;

import com.kpsharp.omdbsearch.util.network.responses.MovieSearchResponse;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;

import java.util.ArrayList;

import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.kpsharp.omdbsearch.util.network.NetworkConstants.BASE_URL;

public class NetworkManagerImpl implements NetworkManager {

    // region Variables

    private SearchApi mSearchApi;

    // endregion

    // region Lifecycle

    public NetworkManagerImpl() {

        Retrofit.Builder builder = new Retrofit.Builder();
        Retrofit retrofit = builder.baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        mSearchApi = retrofit.create(SearchApi.class);
    }

    // endregion

    // region NetworkManager

    @Override
    @NonNull
    public MovieSearchResponse searchMovies(@Nullable String titleQuery) {

        return mSearchApi.searchMovies(titleQuery)
                .subscribeOn(Schedulers.io())
                .onErrorReturn(new Function<Throwable, MovieSearchResponse>() {

            @Override
            public MovieSearchResponse apply(@NonNull Throwable throwable) throws Exception {

                // Any error is fine, just return an empty list
                // Will be thrown if titleQuery is null

                return getEmptyMovieSearchResponse();
            }
        })
                .blockingFirst();
    }

    // endregion

    // region Data Helpers

    @NonNull
    private MovieSearchResponse getEmptyMovieSearchResponse() {

        MovieSearchResponse movieSearchResponse = new MovieSearchResponse();
        movieSearchResponse.movieSearchItemList = new ArrayList<>();
        return movieSearchResponse;
    }

    // endregion

    // region Testing

    @VisibleForTesting
    public void setSearchApi(SearchApi searchApi) {

        mSearchApi = searchApi;
    }

    // endregion
}
