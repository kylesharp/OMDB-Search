package com.kpsharp.omdbsearch.modules;

import com.kpsharp.omdbsearch.base.EspressoTestUtil;
import com.kpsharp.omdbsearch.models.Movie;
import com.kpsharp.omdbsearch.ui.movielist.MovieListPresenter;
import com.kpsharp.omdbsearch.util.data.DataManager;
import com.kpsharp.omdbsearch.util.image.ImageUtil;
import com.kpsharp.omdbsearch.util.image.ImageUtilImpl;
import com.kpsharp.omdbsearch.util.network.NetworkManager;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import android.content.Context;
import android.os.Looper;

import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Module
public class EspressoTestModule {

    // region Variables
    // region Real

    private Context mContext;

    // endregion

    // region Mocked
    // region Utils

    private DataManager mDataManager;
    private NetworkManager mNetworkManager;
    private ImageUtil mImageUtil;

    // endregion

    // region Presenters

    private MovieListPresenter mMovieListPresenter;

    // endregion

    // region Local Mocks

    private BehaviorSubject<List<Movie>> behaviorSubject;

    // endregion
    // endregion

    // region Lifecycle

    public EspressoTestModule(Context context) {

        mContext = context;

        mDataManager = mock(DataManager.class);
        mNetworkManager = mock(NetworkManager.class);
        mImageUtil = new ImageUtilImpl(mContext);

        mMovieListPresenter = new MovieListPresenter(mDataManager);

        mockDataManager();
    }

    // region Lifecycle Helpers

    private void mockDataManager() {

        behaviorSubject = BehaviorSubject.create();

        when(mDataManager.getSearchSubscription()).thenReturn(behaviorSubject);
        when(mDataManager.getMainThreadScheduler()).thenReturn(AndroidSchedulers.from(Looper.getMainLooper()));
        when(mDataManager.getIOThreadScheduler()).thenReturn(Schedulers.single());

        doAnswer(new Answer() {

            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {

                behaviorSubject.onNext(EspressoTestUtil.generateMovieList(5));

                return null;
            }
        }).when(mDataManager).searchForMovies(anyString());
    }
    // endregion
    // endregion

    // region Provides
    // region Context

    @Provides
    public Context provideContext() {

        return mContext;
    }

    // endregion

    // region Utils

    @Provides
    @Singleton
    public DataManager provideDataManager() {

        return mDataManager;
    }

    @Provides
    @Singleton
    public NetworkManager provideNetworkManager() {

        return mNetworkManager;
    }

    @Provides
    @Singleton
    public ImageUtil provideImageUtil() {

        return mImageUtil;
    }

    // endregion

    // region Presenters

    @Provides
    public MovieListPresenter provideMovieListPresenter() {

        return mMovieListPresenter;
    }

    // endregion

    // endregion
}
