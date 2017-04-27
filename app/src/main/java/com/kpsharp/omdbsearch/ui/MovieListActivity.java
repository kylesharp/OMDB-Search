package com.kpsharp.omdbsearch.ui;

import com.kpsharp.omdbsearch.R;
import com.kpsharp.omdbsearch.models.Movie;
import com.kpsharp.omdbsearch.modules.DaggerUtil;
import com.kpsharp.omdbsearch.ui.movielist.MovieListAdapter;
import com.kpsharp.omdbsearch.ui.movielist.MovieListMvp;
import com.kpsharp.omdbsearch.ui.movielist.MovieListPresenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieListActivity extends AppCompatActivity implements MovieListMvp.View, SearchView.OnQueryTextListener {

    // region Variables

    @BindView(R.id.movie_search_view)
    SearchView mMovieTitleSearchView;

    @BindView(R.id.movie_recycler_view)
    RecyclerView mMovieRecyclerView;

    private MovieListAdapter mMovieListAdapter;

    @Inject
    MovieListPresenter mMovieListPresenter;

    // endregion

    // region Lifecycle

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        DaggerUtil.getInstance().getApplicationComponent().inject(this);

        setContentView(R.layout.activity_main);

        loadViews();

        mMovieListPresenter.attachView(this);
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

    @Override
    protected void onDestroy() {

        mMovieListPresenter.detachView();

        super.onDestroy();
    }

    // region Lifecycle Helpers

    // We should only call this once when we're first loading
    private void loadViews() {

        ButterKnife.bind(this);

        mMovieTitleSearchView.setQueryHint(getResources().getString(R.string.movie_list_search_view_hint));
        mMovieTitleSearchView.setOnQueryTextListener(this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mMovieRecyclerView.setLayoutManager(gridLayoutManager);

        mMovieListAdapter = new MovieListAdapter(this);

        mMovieRecyclerView.setAdapter(mMovieListAdapter);
    }

    // endregion
    // endregion

    // region OnQueryTextListener

    @Override
    public boolean onQueryTextChange(String newText) {

        // no-op
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        mMovieTitleSearchView.clearFocus();

        mMovieListPresenter.userSearchedForMovie(query);

        return true;
    }

    // endregion

    // region MovieListMvp.View

    @Override
    public void updateMovieList(@NonNull List<Movie> movieList) {

        mMovieListAdapter.setMovieList(movieList);
    }

    // endregion
}
