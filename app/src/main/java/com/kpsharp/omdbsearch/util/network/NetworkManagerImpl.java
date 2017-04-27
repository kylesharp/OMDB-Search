package com.kpsharp.omdbsearch.util.network;

import com.kpsharp.omdbsearch.util.network.responses.MovieSearchResponse;

import java.util.ArrayList;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.kpsharp.omdbsearch.util.network.NetworkConstants.BASE_URL;

public class NetworkManagerImpl implements NetworkManager {

    private SearchApi mSearchApi;

    public NetworkManagerImpl() {

        Retrofit.Builder builder = new Retrofit.Builder();
        Retrofit retrofit = builder.baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        mSearchApi = retrofit.create(SearchApi.class);
    }

    @Override
    public MovieSearchResponse searchMovies(String titleQuery) {

        return mSearchApi.searchMovies(titleQuery)
                .subscribeOn(Schedulers.io())
                .onErrorReturn(new Function<Throwable, MovieSearchResponse>() {

            @Override
            public MovieSearchResponse apply(@NonNull Throwable throwable) throws Exception {

                // Any error is fine, just return an empty list
                MovieSearchResponse movieSearchResponse = new MovieSearchResponse();
                movieSearchResponse.movieSearchItemList = new ArrayList<>();
                return movieSearchResponse;
            }
        })
                .blockingFirst();
    }
}
