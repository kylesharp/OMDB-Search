package com.kpsharp.omdbsearch.models;

import android.support.annotation.NonNull;

public class Movie {

    private String mTitle;

    public Movie() {

        mTitle = "";
    }

    public Movie(@NonNull String title) {

        mTitle = title;
    }

    @NonNull
    public String getTitle() {

        return mTitle;
    }
}
