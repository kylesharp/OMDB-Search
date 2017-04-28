package com.kpsharp.omdbsearch.util.network;

import com.kpsharp.omdbsearch.base.BaseUnitTest;
import com.kpsharp.omdbsearch.base.UnitTestUtil;
import com.kpsharp.omdbsearch.util.network.responses.MovieSearchResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.Flowable;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class NetworkManagerImplUnitTest extends BaseUnitTest {

    // region Variables

    private NetworkManagerImpl mNetworkManagerImpl;

    private SearchApi mSearchApi;

    // endregion

    // region Lifecycle

    @Override
    public void setUp() throws Exception {

        super.setUp();

        mNetworkManagerImpl = new NetworkManagerImpl();

        mSearchApi = mock(SearchApi.class);

        mNetworkManagerImpl.setSearchApi(mSearchApi);
    }

    // endregion

    // region Tests

    @Test
    public void testSearchMoviesForEmptyString() throws Exception {

        Flowable<MovieSearchResponse> movieSearchResponseFlowable = Flowable.just(UnitTestUtil.generateMovieSearchResponse(0));

        String query = "";

        when(mSearchApi.searchMovies(query)).thenReturn(movieSearchResponseFlowable);

        MovieSearchResponse movieSearchResponse = mNetworkManagerImpl.searchMovies(query);

        UnitTestUtil.assertStandardMovieSearchResponse(movieSearchResponse, 0);
    }

    @Test
    public void testSearchMoviesForNullString() throws Exception {

        Flowable<MovieSearchResponse> movieSearchResponseFlowable = Flowable.just(UnitTestUtil.generateMovieSearchResponse(0));

        String query = null;

        when(mSearchApi.searchMovies(query)).thenReturn(movieSearchResponseFlowable);

        MovieSearchResponse movieSearchResponse = mNetworkManagerImpl.searchMovies(query);

        UnitTestUtil.assertStandardMovieSearchResponse(movieSearchResponse, 0);
    }

    @Test
    public void testSearchMoviesForRealResults() throws Exception {

        Flowable<MovieSearchResponse> movieSearchResponseFlowable = Flowable.just(UnitTestUtil.generateMovieSearchResponse(5));

        String query = "movies";

        when(mSearchApi.searchMovies(query)).thenReturn(movieSearchResponseFlowable);

        MovieSearchResponse movieSearchResponse = mNetworkManagerImpl.searchMovies(query);

        UnitTestUtil.assertStandardMovieSearchResponse(movieSearchResponse, 5);
    }

    // endregion
}
