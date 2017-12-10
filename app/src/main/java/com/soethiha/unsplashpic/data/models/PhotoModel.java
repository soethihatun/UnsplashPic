package com.soethiha.unsplashpic.data.models;

import android.content.Context;
import android.util.Log;

import com.soethiha.unsplashpic.data.models.base.BaseModel;
import com.soethiha.unsplashpic.data.vos.PhotoVO;
import com.soethiha.unsplashpic.events.DataEvent;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import static com.soethiha.unsplashpic.UnsplashPicApp.TAG;

/**
 * UnsplashPic
 *
 * @author SoeThihaTun
 * @version 1.0
 * @since 02/12/2017
 */
public class PhotoModel extends BaseModel {

    private static PhotoModel objInstance;

    private List<PhotoVO> mPhotoList;

    private PhotoModel() {
        super();
        mPhotoList = new ArrayList<>();
    }

    public static PhotoModel getObjInstance() {
        if (objInstance == null) {
            objInstance = new PhotoModel();
        }
        return objInstance;
    }

    public void loadPhotos(Context context) {
        dataAgent.loadPhotos(context);
    }

    public List<PhotoVO> getPhotoList() {
        return mPhotoList;
    }

    public void notifyPhotosLoaded(List<PhotoVO> photoList) {
        if (photoList != null) {
            // Swap new data
            mPhotoList = photoList;

            // Broadcast the event
            DataEvent.PhotoDataLoadedEvent event = new DataEvent.PhotoDataLoadedEvent("Success", photoList);
            EventBus.getDefault().post(event);
        }
    }

    public void notifyErrorInLoadingPhotos(String message) {
        Log.d(TAG, "notifyErrorInLoadingPhotos: " + message);
        DataEvent.PhotoDataLoadedEvent event = new DataEvent.PhotoDataLoadedEvent(message, null);
        EventBus.getDefault().post(event);
    }
}
