package com.kpsharp.omdbsearch.base;

import com.kpsharp.omdbsearch.modules.DaggerEspressoTestComponent;
import com.kpsharp.omdbsearch.modules.DaggerUtil;
import com.kpsharp.omdbsearch.modules.EspressoTestComponent;
import com.kpsharp.omdbsearch.modules.EspressoTestModule;
import com.kpsharp.omdbsearch.util.data.DataManager;
import com.kpsharp.omdbsearch.util.image.ImageUtil;
import com.kpsharp.omdbsearch.util.network.NetworkManager;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

import android.support.annotation.CallSuper;

import javax.inject.Inject;

import static android.support.test.InstrumentationRegistry.getTargetContext;

public class BaseEspressoTest {

    // region Variables

    @Inject
    protected DataManager mDataManager;

    @Inject
    protected NetworkManager mNetworkManager;

    @Inject
    protected ImageUtil mImageUtil;

    // endregion

    // region Lifecycle

    @BeforeClass
    public static void beforeTests() throws Exception {

        EspressoTestComponent espressoTestComponent = DaggerEspressoTestComponent.builder()
                .espressoTestModule(new EspressoTestModule(getTargetContext()))
                .build();

        // Set our application's component for injections
        DaggerUtil.getInstance().setApplicationComponent(espressoTestComponent);
    }

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
