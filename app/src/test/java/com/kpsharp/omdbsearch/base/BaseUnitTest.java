package com.kpsharp.omdbsearch.base;

import com.kpsharp.omdbsearch.util.data.DataManager;
import com.kpsharp.omdbsearch.util.image.ImageUtil;
import com.kpsharp.omdbsearch.util.network.NetworkManager;

import org.junit.After;
import org.junit.Before;
import org.mockito.Mock;

import android.support.annotation.CallSuper;

public class BaseUnitTest {

    // region Variables
    // region Mocks

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

    }

    @CallSuper
    @After
    public void tearDown() throws Exception {

    }

    // endregion
}
