package com.kpsharp.omdbsearch.models;

import android.support.annotation.NonNull;

public class Movie {

    private String mTitle;
    private String mPosterUrl;

    public Movie() {

        mTitle = "";
        mPosterUrl = "";
    }

    public Movie(@NonNull String title, @NonNull String posterUrl) {

        mTitle = title;
        mPosterUrl = posterUrl;
    }

    @NonNull
    public String getTitle() {

        return mTitle;
    }

    public String getPosterUrl() {

        return mPosterUrl;
    }
}
