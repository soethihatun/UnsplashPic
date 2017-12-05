package com.soethiha.unsplashpic.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.soethiha.unsplashpic.UnsplashPicApp;

import org.greenrobot.eventbus.EventBus;

/**
 * UnsplashPic
 *
 * @author SoeThihaTun
 * @version 1.0
 * @since 01/12/2017
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();

        EventBus eventBus = EventBus.getDefault();
        if (!eventBus.isRegistered(this)) {
        Log.d(UnsplashPicApp.TAG, "onStart: ");
            eventBus.register(this);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        EventBus eventBus = EventBus.getDefault();
        if (eventBus.isRegistered(this)) {
            eventBus.unregister(this);
        }
    }
}
