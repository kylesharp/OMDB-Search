package com.kpsharp.omdbsearch.util.network.responses;

import com.google.gson.annotations.SerializedName;

public class MovieSearchItem {

    @SerializedName("Title")
    public String title;

    @SerializedName("imdbID")
    public String imdbId;

    @SerializedName("Poster")
    public String poster;
}
