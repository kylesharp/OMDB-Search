package com.kpsharp.omdbsearch.util.data;

import com.kpsharp.omdbsearch.util.network.NetworkManager;

public class DataManagerImpl implements DataManager {

    private NetworkManager mNetworkManager;

    public DataManagerImpl(NetworkManager networkManager) {

        mNetworkManager = networkManager;
    }

}
