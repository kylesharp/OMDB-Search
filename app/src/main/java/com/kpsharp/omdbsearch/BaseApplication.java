package com.kpsharp.omdbsearch;

import android.app.Application;
import android.content.Context;

public class BaseApplication extends Application {

    // region Variables

    private static BaseApplication sContext;

    // endregion

    // region Lifecycle

    @Override
    public void onCreate() {

        super.onCreate();

        sContext = this;
    }

    // endregion

    // region Static Accessors

    public static Context getContext() {

        return sContext;
    }

    // endregion
}
