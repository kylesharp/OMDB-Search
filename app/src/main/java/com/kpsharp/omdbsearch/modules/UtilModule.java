package com.kpsharp.omdbsearch.modules;

import com.kpsharp.omdbsearch.BaseApplication;
import com.kpsharp.omdbsearch.util.data.DataManager;
import com.kpsharp.omdbsearch.util.data.DataManagerImpl;
import com.kpsharp.omdbsearch.util.image.ImageUtil;
import com.kpsharp.omdbsearch.util.image.ImageUtilImpl;
import com.kpsharp.omdbsearch.util.network.NetworkManager;
import com.kpsharp.omdbsearch.util.network.NetworkManagerImpl;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UtilModule {

    public UtilModule() {
    }

    @Provides
    @Singleton
    public NetworkManager provideNetworkManager() {

        return new NetworkManagerImpl();
    }

    @Provides
    @Singleton
    public DataManager provideDataManager(NetworkManager networkManager) {

        return new DataManagerImpl(networkManager);
    }

    @Provides
    @Singleton
    public ImageUtil provideImageUtil(Context context) {

        return new ImageUtilImpl(context);
    }

    @Provides
    @Singleton
    public Context provideContext() {

        return BaseApplication.getContext();
    }
}
