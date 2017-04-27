package com.kpsharp.omdbsearch.util.network.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieSearchResponse {

    @SerializedName("Search")
    public List<MovieSearchItem> movieSearchItemList;

}
