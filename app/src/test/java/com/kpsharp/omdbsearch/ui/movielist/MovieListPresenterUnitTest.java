package com.kpsharp.omdbsearch.ui.movielist;

import com.kpsharp.omdbsearch.base.BaseUnitTest;
import com.kpsharp.omdbsearch.base.UnitTestUtil;
import com.kpsharp.omdbsearch.models.Movie;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.List;

import io.reactivex.subjects.BehaviorSubject;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class MovieListPresenterUnitTest extends BaseUnitTest {

    // region Variables

    private MovieListPresenter mMovieListPresenter;
    private MovieListMvp.View mView;

    private BehaviorSubject<List<Movie>> mBehaviorSubject;

    // endregion

    // region Lifecycle

    @Override
    public void setUp() throws Exception {

        super.setUp();

        mMovieListPresenter = new MovieListPresenter(mDataManager);
        mView = mock(MovieListMvp.View.class);

        mMovieListPresenter.attachView(mView);

        mBehaviorSubject = BehaviorSubject.create();
        when(mDataManager.getSearchSubscription()).thenReturn(mBehaviorSubject);

        mMovieListPresenter.subscribeToObservables();
    }

    @Override
    public void tearDown() throws Exception {

        mMovieListPresenter.unsubscribeFromObservables();

        super.tearDown();
    }

    // endregion

    // region Tests

    @Test
    public void testUserSearchedForMovieForRealResults() throws Exception {

        String query = "movie";

        final List<Movie> movieList = UnitTestUtil.generateMovieList(5);

        doAnswer(new Answer() {

            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {

                mBehaviorSubject.onNext(movieList);
                return null;
            }
        }).when(mDataManager).searchForMovies(query);


        mMovieListPresenter.userSearchedForMovie(query);

        verify(mDataManager, times(1)).searchForMovies(query);

        verify(mView, times(1)).updateMovieList(movieList);
    }

    // endregion
}
