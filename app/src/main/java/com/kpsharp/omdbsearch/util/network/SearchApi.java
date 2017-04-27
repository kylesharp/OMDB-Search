package com.kpsharp.omdbsearch.util.network;

import com.kpsharp.omdbsearch.util.network.responses.MovieSearchResponse;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SearchApi {

    @GET("/")
    Flowable<MovieSearchResponse> searchMovies(@Query("s") String query);
}
