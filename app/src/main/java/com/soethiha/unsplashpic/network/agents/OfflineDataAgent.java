package com.soethiha.unsplashpic.network.agents;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.soethiha.unsplashpic.data.models.PhotoModel;
import com.soethiha.unsplashpic.data.vos.PhotoVO;
import com.soethiha.unsplashpic.utils.JsonUtils;

import org.json.JSONException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import static com.soethiha.unsplashpic.UnsplashPicApp.TAG;
import static com.soethiha.unsplashpic.network.utils.NetworkConstants.OFFLINE_SAMPLE_UNSPLASH_PHOTO_JSON_PATH;
import static com.soethiha.unsplashpic.network.utils.NetworkConstants.PATH_DUMMY_DATA;

/**
 * UnsplashPic
 *
 * @author SoeThihaTun
 * @version 1.0
 * @since 02/12/2017
 */

public class OfflineDataAgent implements UnsplashPicDataAgent {

    private static OfflineDataAgent objInstance;

    private OfflineDataAgent() {
    }

    public static OfflineDataAgent getObjInstance() {
        if (objInstance == null) {
            objInstance = new OfflineDataAgent();
        }
        return objInstance;
    }

    @Override
    public void loadPhotos(Context context) {
        try {
            // Get the String from Offline Json files
            String jsonStr = JsonUtils.getObjInstance().loadDummyData(context, PATH_DUMMY_DATA,
                    OFFLINE_SAMPLE_UNSPLASH_PHOTO_JSON_PATH);

            // Convert the Json to Value Object Type
            Type listType = new TypeToken<List<PhotoVO>>() {
            }.getType();
            List<PhotoVO> photoList = new Gson().fromJson(jsonStr, listType);

            // If data was loaded
            if (photoList.isEmpty()) {
                // Notify error to model
                PhotoModel.getObjInstance().notifyErrorInLoadingPhotos("Empty photo list");
            } else {
                Log.d(TAG, "loadPhotos: size = " + photoList.size());

                // Notify loaded Photos to model
                PhotoModel.getObjInstance().notifyPhotosLoaded(photoList);
            }
        } catch (IOException e) {
            e.printStackTrace();

            // Notify error to model
            PhotoModel.getObjInstance().notifyErrorInLoadingPhotos(e.getMessage());
        } catch (JSONException e) {
            e.printStackTrace();

            // Notify error to model
            PhotoModel.getObjInstance().notifyErrorInLoadingPhotos(e.getMessage());
        }
    }
}
