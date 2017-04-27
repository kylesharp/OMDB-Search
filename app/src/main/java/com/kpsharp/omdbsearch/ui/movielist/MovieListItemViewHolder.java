package com.kpsharp.omdbsearch.ui.movielist;

import com.kpsharp.omdbsearch.R;
import com.kpsharp.omdbsearch.models.Movie;
import com.kpsharp.omdbsearch.modules.DaggerUtil;
import com.kpsharp.omdbsearch.util.image.ImageUtil;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieListItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    // region Variables

    @BindView(R.id.movie_item_poster)
    ImageView mMoviePoster;

    @Inject
    ImageUtil mImageUtil;

    private MovieListAdapterCallback mMovieListAdapterCallback;
    private Movie mMovie;

    // endregion

    // region Lifecycle

    public MovieListItemViewHolder(@NonNull View itemView) {

        super(itemView);

        ButterKnife.bind(this, itemView);

        DaggerUtil.getInstance().getApplicationComponent().inject(this);

        itemView.setOnClickListener(this);
    }

    public void bindViewHolder(@NonNull Movie movie, MovieListAdapterCallback movieListAdapterCallback) {

        mMovie = movie;
        mMovieListAdapterCallback = movieListAdapterCallback;

        mImageUtil.loadImage(mMoviePoster, movie.getPosterUrl());
    }

    // endregion

    // region OnClickListener

    @Override
    public void onClick(View v) {

        if (mMovieListAdapterCallback != null) {

            mMovieListAdapterCallback.onMovieClicked(mMovie);
        }
    }

    // endregion
}
