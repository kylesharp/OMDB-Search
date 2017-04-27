package com.kpsharp.omdbsearch.base;

import com.kpsharp.omdbsearch.util.network.responses.MovieSearchItem;
import com.kpsharp.omdbsearch.util.network.responses.MovieSearchResponse;

import java.util.ArrayList;

public class UnitTestUtil {

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
}
