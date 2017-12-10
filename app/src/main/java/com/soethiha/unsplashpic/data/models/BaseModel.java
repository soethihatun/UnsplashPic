package com.soethiha.unsplashpic.data.models;

import com.soethiha.unsplashpic.network.agents.OfflineDataAgent;
import com.soethiha.unsplashpic.network.agents.OkHttpDataAgent;
import com.soethiha.unsplashpic.network.agents.UnsplashPicDataAgent;

/**
 * UnsplashPic
 *
 * @author SoeThihaTun
 * @version 1.0
 * @since 02/12/2017
 */
public class BaseModel {

    private static final int INIT_DATA_AGENT_OFFLINE = 1;
    private static final int INIT_DATA_AGENT_OK_HTTP = 2;

    protected UnsplashPicDataAgent dataAgent;

    public BaseModel() {
        initDataAgent(INIT_DATA_AGENT_OK_HTTP);
    }

    private void initDataAgent(int initType) {
        switch (initType) {
            case INIT_DATA_AGENT_OFFLINE:
                dataAgent = OfflineDataAgent.getObjInstance();
                break;
            case INIT_DATA_AGENT_OK_HTTP:
                dataAgent = OkHttpDataAgent.getObjInstance();
                break;
            default:
                break;
        }
    }
}
