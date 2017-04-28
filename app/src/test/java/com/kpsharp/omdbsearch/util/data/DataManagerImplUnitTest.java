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

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertSame;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class DataManagerImplUnitTest extends BaseUnitTest {

    // region Variables

    private DataManagerImpl mDataManagerImpl;

    // endregion

    // region Lifecycle

    @Override
    public void setUp() throws Exception {

        super.setUp();

        mDataManagerImpl = new DataManagerImpl(mNetworkManager);
    }

    // endregion

    // region Tests

    @Test
    public void testGetSearchSubscriptionIsNotNull() throws Exception {

        assertNotNull(mDataManagerImpl.getSearchSubscription());
    }

    @Test
    public void testGetSearchSubscriptionIsInitializedOnce() throws Exception {

        BehaviorSubject<List<Movie>> firstBehaviorSubject = mDataManagerImpl.getSearchSubscription();
        BehaviorSubject<List<Movie>> secondBehaviorSubject = mDataManagerImpl.getSearchSubscription();

        assertSame(firstBehaviorSubject, secondBehaviorSubject);
    }

    @Test
    public void testSearchForMoviesHandlesEmptyQuery() throws Exception {

        mDataManagerImpl.getSearchSubscription().subscribe(new Consumer<List<Movie>>() {

            @Override
            public void accept(@NonNull List<Movie> movies) throws Exception {

                UnitTestUtil.assertStandardMovieList(movies, 0);
            }
        });

        String query = "";

        when(mNetworkManager.searchMovies(query)).thenReturn(UnitTestUtil.generateMovieSearchResponse(0));

        mDataManagerImpl.searchForMovies(query);
    }

    @Test
    public void testSearchForMoviesForRealResults() throws Exception {

        mDataManagerImpl.getSearchSubscription().subscribe(new Consumer<List<Movie>>() {

            @Override
            public void accept(@NonNull List<Movie> movies) throws Exception {

                UnitTestUtil.assertStandardMovieList(movies, 5);
            }
        });

        String query = "movie";

        when(mNetworkManager.searchMovies(query)).thenReturn(UnitTestUtil.generateMovieSearchResponse(5));

        mDataManagerImpl.searchForMovies(query);
    }

    // endregion
}
