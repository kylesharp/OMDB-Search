package com.kpsharp.omdbsearch;

import com.kpsharp.omdbsearch.movielist.MovieListAdapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.movie_recycler_view)
    RecyclerView mMovieRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        loadViews();
    }

    private void loadViews() {

        ButterKnife.bind(this);

        mMovieRecyclerView.setAdapter(new MovieListAdapter());
    }
}
