package com.kpsharp.omdbsearch.models;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class Movie {

    private String mTitle;
    private String mPosterUrl;
    private String mImdbId;

    public Movie() {

        mTitle = "";
        mPosterUrl = "";
    }

    public Movie(@Nullable String title, @Nullable String posterUrl, @Nullable String imdbId) {

        mTitle = title != null ? title : "";
        mPosterUrl = posterUrl != null ? posterUrl : "";
        mImdbId = imdbId != null ? imdbId : "";
    }

    @NonNull
    public String getTitle() {

        return mTitle;
    }

    @NonNull
    public String getPosterUrl() {

        return mPosterUrl;
    }

    @NonNull
    public String getImdbId() {

        return mImdbId;
    }
}
