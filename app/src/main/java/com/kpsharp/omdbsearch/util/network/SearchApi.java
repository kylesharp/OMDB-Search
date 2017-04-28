package com.kpsharp.omdbsearch.util.network;

import com.kpsharp.omdbsearch.util.network.responses.MovieSearchResponse;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SearchApi {

    /**
     * Searches the API for a movie based on the title
     * @param query The {@link String} query to search for
     * @return A {@link Flowable} of the {@link MovieSearchResponse} result
     */
    @GET("/")
    Flowable<MovieSearchResponse> searchMovies(@Query("s") String query);
}
