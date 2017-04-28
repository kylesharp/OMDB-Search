package com.kpsharp.omdbsearch.base;

import com.kpsharp.omdbsearch.models.Movie;
import com.kpsharp.omdbsearch.util.network.responses.MovieSearchItem;
import com.kpsharp.omdbsearch.util.network.responses.MovieSearchResponse;

import android.support.test.InstrumentationRegistry;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class EspressoTestUtil {

    // region Generators
    // region Network Responses

    public static MovieSearchResponse generateMovieSearchResponse(int numberOfResults) {

        MovieSearchResponse movieSearchResponse = new MovieSearchResponse();

        movieSearchResponse.movieSearchItemList = new ArrayList<>();

        for (int i=0; i<numberOfResults; i++) {
            movieSearchResponse.movieSearchItemList.add(generateMovieSearchItem(i));
        }

        return movieSearchResponse;
    }

    public static MovieSearchItem generateMovieSearchItem(int index) {

        MovieSearchItem movieSearchItem = new MovieSearchItem();

        movieSearchItem.title = "title_" + Integer.toString(index);
        movieSearchItem.poster = "poster_" + Integer.toString(index);
        movieSearchItem.imdbId = "imdb_" + Integer.toString(index);

        return movieSearchItem;
    }

    // endregion

    // region Models

    public static List<Movie> generateMovieList(int numberOfMovies) {

        List<Movie> movieList = new ArrayList<>();

        for (int i=0; i<numberOfMovies; i++) {
            movieList.add(generateMovie(i));
        }

        return movieList;
    }

    public static Movie generateMovie(int index) {

        String indexString = Integer.toString(index);

        return new Movie("title_" + indexString, "android.resource://" + InstrumentationRegistry.getContext().getPackageName() + "/" + com.kpsharp.omdbsearch.test.R.mipmap.poster, "imdbId_" + indexString);
    }

    // endregion
    // endregion

    // region Assertions
    // region Network Responses

    public static void assertStandardMovieSearchResponse(MovieSearchResponse movieSearchResponse, int expectedSize) {

        assertNotNull(movieSearchResponse);
        assertNotNull(movieSearchResponse.movieSearchItemList);
        assertEquals(movieSearchResponse.movieSearchItemList.size(), expectedSize);

        for (int i=0; i<movieSearchResponse.movieSearchItemList.size(); i++) {
            assertEquals("title_" + Integer.toString(i), movieSearchResponse.movieSearchItemList.get(i).title);
            assertEquals("poster_" + Integer.toString(i), movieSearchResponse.movieSearchItemList.get(i).poster);
            assertEquals("imdb_" + Integer.toString(i), movieSearchResponse.movieSearchItemList.get(i).imdbId);
        }
    }

    // endregion

    // region Models

    public static void assertStandardMovieList(List<Movie> movieList, int expectedSize) {

        assertNotNull(movieList);
        assertEquals(movieList.size(), expectedSize);

        for (int i=0; i<movieList.size(); i++) {
            assertEquals("title_" + Integer.toString(i), movieList.get(i).getTitle());
            assertEquals("poster_" + Integer.toString(i), movieList.get(i).getPosterUrl());
            assertEquals("imdb_" + Integer.toString(i), movieList.get(i).getImdbId());
        }
    }

    // endregion
    // endregion
}
