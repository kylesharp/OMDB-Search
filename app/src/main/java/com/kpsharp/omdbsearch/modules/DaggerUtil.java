package com.kpsharp.omdbsearch.modules;

public class DaggerUtil {

    private static DaggerUtil sInstance;
    private ApplicationComponent mApplicationComponent;

    private DaggerUtil() {

        if (mApplicationComponent == null) {

            mApplicationComponent = DaggerApplicationComponent.builder().build();
        }
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    //For tests
    public void setApplicationComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }

    public static DaggerUtil getInstance() {

        if (sInstance == null) {
            sInstance = new DaggerUtil();
        }
        return sInstance;
    }
}
