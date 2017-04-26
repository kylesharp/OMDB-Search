package com.kpsharp.omdbsearch;

import com.kpsharp.omdbsearch.models.Movie;
import com.kpsharp.omdbsearch.movielist.MovieListAdapter;
import com.kpsharp.omdbsearch.movielist.MovieListMvp;

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

    // endregion

    // region Lifecycle

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        loadViews();
    }

    // region Lifecycle Helpers

    // We should only call this once when we're first loading
    private void loadViews() {

        ButterKnife.bind(this);

        mMovieListAdapter = new MovieListAdapter();

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
