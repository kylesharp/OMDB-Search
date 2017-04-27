package com.kpsharp.omdbsearch;

import android.app.Application;
import android.content.Context;

public class BaseApplication extends Application {

    private static Context sContext;

    @Override
    public void onCreate() {

        super.onCreate();

        sContext = this;
    }

    public static Context getContext() {

        return sContext;
    }
}
