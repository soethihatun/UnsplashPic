package com.soethiha.unsplashpic;

import android.app.Application;

import com.soethiha.unsplashpic.data.models.PhotoModel;

/**
 * UnsplashPic
 *
 * @author SoeThihaTun
 * @version 1.0
 * @since 01/12/2017
 */

public class UnsplashPicApp extends Application {
    public static final String TAG = "UnsplashPicApp";

    @Override
    public void onCreate() {
        super.onCreate();

        PhotoModel.getObjInstance().loadPhotos(getApplicationContext());
    }
}
