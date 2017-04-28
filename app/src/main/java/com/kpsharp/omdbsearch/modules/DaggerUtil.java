package com.kpsharp.omdbsearch.modules;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

public class DaggerUtil {

    // region Variables

    private static DaggerUtil sInstance;
    private ApplicationComponent mApplicationComponent;

    // endregion

    // region Lifecycle

    // Private constructor, use getInstance instead
    private DaggerUtil() {

        if (mApplicationComponent == null) {

            mApplicationComponent = DaggerApplicationComponent.builder().build();
        }
    }

    // endregion

    // region Accessors

    @NonNull
    public static DaggerUtil getInstance() {

        if (sInstance == null) {
            sInstance = new DaggerUtil();
        }
        return sInstance;
    }

    @NonNull
    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    // endregion

    // region Testing

    @VisibleForTesting
    public void setApplicationComponent(@NonNull ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }

    // endregion
}
