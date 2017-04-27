package com.kpsharp.omdbsearch.modules;

import com.kpsharp.omdbsearch.util.data.DataManager;
import com.kpsharp.omdbsearch.util.data.DataManagerImpl;
import com.kpsharp.omdbsearch.util.network.NetworkManager;
import com.kpsharp.omdbsearch.util.network.NetworkManagerImpl;

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
}
