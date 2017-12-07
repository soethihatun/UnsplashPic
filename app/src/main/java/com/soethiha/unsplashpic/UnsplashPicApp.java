package com.soethiha.unsplashpic;

import android.app.Application;
import android.widget.Toast;

import com.soethiha.unsplashpic.data.models.PhotoModel;
import com.soethiha.unsplashpic.utils.NetworkUtils;

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

        // TODO: 12/6/17 Test
        Toast.makeText(this, "a = " + NetworkUtils.Companion.hello(), Toast.LENGTH_SHORT).show();

        if (NetworkUtils.Companion.isOnline(getApplicationContext())) {
            Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show();
            PhotoModel.getObjInstance().loadPhotos(getApplicationContext());
        } else {
            Toast.makeText(this, "Connection fail.", Toast.LENGTH_SHORT).show();
        }
    }
}
