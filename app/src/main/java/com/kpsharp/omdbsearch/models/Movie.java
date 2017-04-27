package com.kpsharp.omdbsearch.models;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class Movie {

    private String mTitle;
    private String mPosterUrl;

    public Movie() {

        mTitle = "";
        mPosterUrl = "";
    }

    public Movie(@Nullable String title, @Nullable String posterUrl) {

        mTitle = title != null ? title : "";
        mPosterUrl = posterUrl != null ? posterUrl : "";
    }

    @NonNull
    public String getTitle() {

        return mTitle;
    }

    public String getPosterUrl() {

        return mPosterUrl;
    }
}
