package com.kpsharp.omdbsearch.util.data;

import com.kpsharp.omdbsearch.base.BaseUnitTest;
import com.kpsharp.omdbsearch.base.UnitTestUtil;
import com.kpsharp.omdbsearch.models.Movie;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DataManagerImplUnitTest extends BaseUnitTest {

    // region Variables

    private DataManager mDataManager;

    // endregion

    // region Lifecycle

    @Override
    public void setUp() throws Exception {

        super.setUp();

        mDataManager = new DataManagerImpl(mNetworkManager);
    }

    // endregion

    // region Tests

    @Test
    public void testGetSearchSubscriptionIsNotNull() throws Exception {

        assertNotNull(mDataManager.getSearchSubscription());
    }

    @Test
    public void testGetSearchSubscriptionIsInitializedOnce() throws Exception {

        BehaviorSubject<List<Movie>> firstBehaviorSubject = mDataManager.getSearchSubscription();
        BehaviorSubject<List<Movie>> secondBehaviorSubject = mDataManager.getSearchSubscription();

        assertEquals(firstBehaviorSubject, secondBehaviorSubject);
    }

    @Test
    public void testSearchForMoviesHandlesEmptyQuery() throws Exception {

        mDataManager.getSearchSubscription().subscribe(new Consumer<List<Movie>>() {

            @Override
            public void accept(@NonNull List<Movie> movies) throws Exception {

                assertNotNull(movies);

                assertEquals(movies.size(), 0);
            }
        });

        String query = "";

        when(mNetworkManager.searchMovies(query)).thenReturn(UnitTestUtil.generateMovieSearchResponse(0));

        mDataManager.searchForMovies(query);
    }

    @Test
    public void testSearchForMoviesForRealResults() throws Exception {

        mDataManager.getSearchSubscription().subscribe(new Consumer<List<Movie>>() {

            @Override
            public void accept(@NonNull List<Movie> movies) throws Exception {

                assertNotNull(movies);

                assertEquals(movies.size(), 5);

                for (int i=0; i<5; i++) {
                    assertEquals("title_" + Integer.toString(i), movies.get(i).getTitle());
                    assertEquals("poster_" + Integer.toString(i), movies.get(i).getPosterUrl());
                    assertEquals("imdb_" + Integer.toString(i), movies.get(i).getImdbId());
                }
            }
        });

        String query = "movie";

        when(mNetworkManager.searchMovies(query)).thenReturn(UnitTestUtil.generateMovieSearchResponse(5));

        mDataManager.searchForMovies(query);
    }

    // endregion
}
