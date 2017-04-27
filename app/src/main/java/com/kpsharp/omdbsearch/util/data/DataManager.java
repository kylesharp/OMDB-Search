package com.kpsharp.omdbsearch.util.data;

import com.kpsharp.omdbsearch.models.Movie;

import android.support.annotation.Nullable;

import java.util.List;

import io.reactivex.subjects.BehaviorSubject;

public interface DataManager {

    /**
     * Gets the {@link BehaviorSubject} to subscribe to whenever our {@link Movie} list is updated
     * @return The BehaviorSubject
     */
    BehaviorSubject<List<Movie>> getSearchSubscription();

    /**
     * Searches for movies based on the title query
     * Subscribe to the {@link #getSearchSubscription()} to get the results
     * @param titleQuery The {@link String} title to search with
     */
    void searchForMovies(@Nullable String titleQuery);
}
