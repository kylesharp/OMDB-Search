package com.kpsharp.omdbsearch.ui.movielist;

import com.kpsharp.omdbsearch.R;
import com.kpsharp.omdbsearch.ui.models.Movie;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter {

    // region Variables

    private Context mContext;
    private List<Movie> mMovieList;

    // endregion

    // region RecyclerView.Adapter

    public MovieListAdapter(Context context) {
        mContext = context;
        mMovieList = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View rootView = LayoutInflater.from(mContext).inflate(R.layout.item_movie_list, parent, false);
        return new MovieListItemViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof MovieListItemViewHolder) {
            ((MovieListItemViewHolder) holder).bindViewHolder(mMovieList.get(position));
        }
        else {
            throw new IllegalStateException("Received an unexpected ViewHolder type");
        }
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
