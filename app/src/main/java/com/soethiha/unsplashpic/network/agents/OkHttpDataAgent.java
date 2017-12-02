package com.soethiha.unsplashpic.network.agents;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * UnsplashPic
 *
 * @author SoeThihaTun
 * @version 1.0
 * @since 02/12/2017
 */

public class OkHttpDataAgent implements UnsplashPicDataAgent {

    private static final int CONNECTION_TIME = 15;
    private static final int READ_TIME = 60;
    private static final int WRITE_TIME = 15;

    private static OkHttpDataAgent objInstance;
    private OkHttpClient okHttpClient;

    private OkHttpDataAgent() {
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(CONNECTION_TIME, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIME, TimeUnit.SECONDS)
                .readTimeout(READ_TIME, TimeUnit.SECONDS)
                .build();
    }

    public static OkHttpDataAgent getObjInstance() {
        if (objInstance == null) {
            objInstance = new OkHttpDataAgent();
        }
        return objInstance;
    }

    @Override
    public void loadPhotos(Context context) {

    }
}
