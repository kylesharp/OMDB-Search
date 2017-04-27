package com.kpsharp.omdbsearch.ui.movielist;

import com.kpsharp.omdbsearch.R;
import com.kpsharp.omdbsearch.models.Movie;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

interface MovieListAdapterCallback {

    /**
     * Called whenever a movie item is clicked on
     * @param movie The {@link Movie} movie the user clicked on
     */
    void onMovieClicked(@NonNull Movie movie);
}

public class MovieListAdapter extends RecyclerView.Adapter implements MovieListAdapterCallback {

    // region Variables

    private Context mContext;
    private List<Movie> mMovieList;

    // endregion

    // region Lifecycle

    public MovieListAdapter(@NonNull Context context) {
        mContext = context;
        mMovieList = new ArrayList<>();
    }

    // endregion

    // region RecyclerView.Adapter

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View rootView = LayoutInflater.from(mContext).inflate(R.layout.item_movie_list, parent, false);
        return new MovieListItemViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof MovieListItemViewHolder) {
            ((MovieListItemViewHolder) holder).bindViewHolder(mMovieList.get(position), this);
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

    // region MovieListAdapterCallback

    @Override
    public void onMovieClicked(@NonNull Movie movie) {

        Toast.makeText(mContext, "Clicked on " + movie.getTitle(), Toast.LENGTH_SHORT).show();
    }

    // endregion

    // region Data

    public void setMovieList(@NonNull List<Movie> movieList) {

        mMovieList = movieList;

        notifyDataSetChanged();
    }

    // endregion
}
