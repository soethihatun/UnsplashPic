package com.soethiha.unsplashpic.data.models;

import android.content.Context;
import android.util.Log;

import com.soethiha.unsplashpic.data.vos.Category;
import com.soethiha.unsplashpic.data.vos.CurrentUserCollection;
import com.soethiha.unsplashpic.data.vos.PhotoVO;

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

            Log.d(TAG, "notifyPhotosLoaded: " + mPhotoList.size());
            PhotoVO photo = mPhotoList.get(0);
            Log.d(TAG, "notifyPhotosLoaded: PhotoVO = " + photo.toString());
            Log.d(TAG, "notifyPhotosLoaded: User = " + photo.getUser().toString());
            Log.d(TAG, "notifyPhotosLoaded: UserProfileImage = " + photo.getUser().getProfileImage().toString());
            Log.d(TAG, "notifyPhotosLoaded: UserLinks = " + photo.getUser().getLinks().toString());
            Log.d(TAG, "notifyPhotosLoaded: PhotoLinks = " + photo.getLinks().toString());
            Log.d(TAG, "notifyPhotosLoaded: PhotoUrls = " + photo.getUrls().toString());
            CurrentUserCollection currentUser = photo.getCurrentUserCollections().get(0);
            Log.d(TAG, "notifyPhotosLoaded: CurrentUserCollection = " + currentUser.toString());
            Log.d(TAG, "notifyPhotosLoaded: CollectionUser = " + currentUser.getUser().toString());
            Log.d(TAG, "notifyPhotosLoaded: CollectionUserProfileImage = " + currentUser.getUser().getProfileImage().toString());
            Log.d(TAG, "notifyPhotosLoaded: CollectionUserLinks = " + currentUser.getUser().getLinks().toString());
            Log.d(TAG, "notifyPhotosLoaded: CollectionLinks = " + currentUser.getLinks().toString());
            Log.d(TAG, "notifyPhotosLoaded: CollectionCoverPhoto = " + currentUser.getCoverPhoto().toString());
            Log.d(TAG, "notifyPhotosLoaded: CollectionCoverPhotoLinks = " + currentUser.getCoverPhoto().getLinks().toString());
            Log.d(TAG, "notifyPhotosLoaded: CollectionCoverPhotoUrls = " + currentUser.getCoverPhoto().getUrls().toString());
            Log.d(TAG, "notifyPhotosLoaded: CollectionCoverPhotoUser = " + currentUser.getCoverPhoto().getUser().toString());
            Log.d(TAG, "notifyPhotosLoaded: CollectionCoverPhotoUserLink = " + currentUser.getCoverPhoto().getUser().getLinks().toString());
            Log.d(TAG, "notifyPhotosLoaded: CollectionCoverPhotoProfileImage = " + currentUser.getCoverPhoto().getUser().getProfileImage().toString());
            Category category = currentUser.getCoverPhoto().getCategories().get(0);
            Log.d(TAG, "notifyPhotosLoaded: CollectionCoverPhotoCategory = " + category.toString());
            Log.d(TAG, "notifyPhotosLoaded: CollectionCoverPhotoCategoryLinks = " + category.getLinks().toString());

        }
    }

    public void notifyErrorInLoadingPhotos(String message) {
        Log.d(TAG, "notifyErrorInLoadingPhotos: " + message);
    }
}
