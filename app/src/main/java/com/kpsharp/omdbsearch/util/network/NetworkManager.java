package com.kpsharp.omdbsearch.util.network;

import com.kpsharp.omdbsearch.util.network.responses.MovieSearchItem;
import com.kpsharp.omdbsearch.util.network.responses.MovieSearchResponse;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public interface NetworkManager {

    /**
     * Queries the server for up to 10 results (API limitation) based on title
     * Uses a background thread
     * @param titleQuery The {@link String} title to search with
     * @return A {@link MovieSearchResponse} response, which is a list of {@link MovieSearchItem}
     */
    @NonNull
    MovieSearchResponse searchMovies(@Nullable String titleQuery);
}
