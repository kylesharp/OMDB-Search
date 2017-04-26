package com.kpsharp.omdbsearch.movielist;

import com.kpsharp.omdbsearch.models.Movie;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter {

    // region Variables

    private List<Movie> mMovieList;

    // endregion

    // region RecyclerView.Adapter

    public MovieListAdapter() {
        mMovieList = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {

        return mMovieList.size();
    }

    // endregion

    // region Data

    public void setMovieList(@NonNull List<Movie> movieList) {

        mMovieList = movieList;

        notifyDataSetChanged();
    }

    // endregion
}
