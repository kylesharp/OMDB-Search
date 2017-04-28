package com.kpsharp.omdbsearch.util.data;

import com.kpsharp.omdbsearch.models.Movie;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.subjects.BehaviorSubject;

public interface DataManager {

    /**
     * Gets the main thread scheduler
     * @return The {@link Scheduler} scheduler for the main thread
     */
    Scheduler getMainThreadScheduler();

    /**
     * Gets the IO thread scheduler
     * @return The {@link Scheduler} scheduler for the IO thread
     */
    Scheduler getIOThreadScheduler();

    /**
     * Gets the {@link BehaviorSubject} to subscribe to whenever our {@link Movie} list is updated
     * @return The BehaviorSubject
     */
    @NonNull
    BehaviorSubject<List<Movie>> getSearchSubscription();

    /**
     * Searches for movies based on the title query
     * Subscribe to the {@link #getSearchSubscription()} to get the results
     * @param titleQuery The {@link String} title to search with
     */
    void searchForMovies(@Nullable String titleQuery);
}
