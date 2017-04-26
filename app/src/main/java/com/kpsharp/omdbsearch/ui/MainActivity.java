package com.kpsharp.omdbsearch.ui;

import com.kpsharp.omdbsearch.R;
import com.kpsharp.omdbsearch.models.Movie;
import com.kpsharp.omdbsearch.ui.movielist.MovieListAdapter;
import com.kpsharp.omdbsearch.ui.movielist.MovieListMvp;
import com.kpsharp.omdbsearch.ui.movielist.MovieListPresenter;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MovieListMvp.View {

    // region Variables

    @BindView(R.id.movie_recycler_view)
    RecyclerView mMovieRecyclerView;

    private MovieListAdapter mMovieListAdapter;

    private MovieListPresenter mMovieListPresenter;

    // endregion

    // region Lifecycle

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mMovieListPresenter = new MovieListPresenter();

        loadViews();
    }

    @Override
    protected void onResume() {

        super.onResume();

        mMovieListPresenter.subscribeToObservables();
    }

    @Override
    protected void onPause() {

        mMovieListPresenter.unsubscribeFromObservables();

        super.onPause();
    }

    // region Lifecycle Helpers

    // We should only call this once when we're first loading
    private void loadViews() {

        ButterKnife.bind(this);

        mMovieListAdapter = new MovieListAdapter(this);

        mMovieRecyclerView.setAdapter(mMovieListAdapter);
    }

    // endregion
    // endregion

    // region MovieListMvp.View

    @Override
    public void updateMovieList(@NonNull List<Movie> movieList) {

        mMovieListAdapter.setMovieList(movieList);
    }

    // endregion
}
