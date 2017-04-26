package com.kpsharp.omdbsearch.ui.movielist;

import com.kpsharp.omdbsearch.R;
import com.kpsharp.omdbsearch.ui.models.Movie;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieListItemViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.movie_item_poster)
    ImageView mMoviePoster;

    public MovieListItemViewHolder(@NonNull View itemView) {

        super(itemView);

        ButterKnife.bind(this, itemView);
    }

    public void bindViewHolder(@NonNull Movie movie) {

    }
}
