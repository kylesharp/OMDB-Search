package com.kpsharp.omdbsearch.base;

import com.kpsharp.omdbsearch.util.data.DataManager;
import com.kpsharp.omdbsearch.util.image.ImageUtil;
import com.kpsharp.omdbsearch.util.network.NetworkManager;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import android.content.Context;
import android.support.annotation.CallSuper;

import io.reactivex.schedulers.Schedulers;

import static org.mockito.Mockito.when;

public class BaseUnitTest {

    // region Variables
    // region Mocks

    @Mock
    protected Context mContext;
    @Mock
    protected DataManager mDataManager;
    @Mock
    protected NetworkManager mNetworkManager;
    @Mock
    protected ImageUtil mImageUtil;

    // endregion
    // endregion

    // region Lifecycle

    @CallSuper
    @Before
    public void setUp() throws Exception {

        when(mDataManager.getMainThreadScheduler()).thenReturn(Schedulers.single());
        when(mDataManager.getIOThreadScheduler()).thenReturn(Schedulers.single());
    }

    @CallSuper
    @After
    public void tearDown() throws Exception {

    }

    // endregion
}
