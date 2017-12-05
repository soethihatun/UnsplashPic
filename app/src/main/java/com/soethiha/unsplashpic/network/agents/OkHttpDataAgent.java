package com.soethiha.unsplashpic.network.agents;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.soethiha.unsplashpic.data.models.PhotoModel;
import com.soethiha.unsplashpic.data.vos.PhotoVO;
import com.soethiha.unsplashpic.network.utils.NetworkConstants;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.soethiha.unsplashpic.UnsplashPicApp.TAG;

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
        new AsyncTask<Void, Void, List<PhotoVO>>() {
            @Override
            protected List<PhotoVO> doInBackground(Void... voids) {
                Request request = new Request.Builder()
                        .url(NetworkConstants.UNSPLASH_API_BASE_URL)
                        .build();

                try {
                    Response response = okHttpClient.newCall(request).execute();
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            String responseString = response.body().string();
                            Log.d(TAG, "doInBackground: " + responseString);

                            // Convert the Json to Value Object Type
                            Type listType = new TypeToken<List<PhotoVO>>() {
                            }.getType();
                            List<PhotoVO> photoList = new Gson().fromJson(responseString, listType);
                            return photoList;
                        }
                    } else {
                        PhotoModel.getObjInstance().notifyErrorInLoadingPhotos(response.message());
                    }
                } catch (IOException ioe) {
                    Log.e(TAG, ioe.getMessage());
                    PhotoModel.getObjInstance().notifyErrorInLoadingPhotos(ioe.getMessage());
                }
                return null;
            }

            @Override
            protected void onPostExecute(List<PhotoVO> photoList) {
                super.onPostExecute(photoList);
                if (photoList != null && photoList.size() > 0) {
                    Log.d(TAG, "onPostExecute: photoList.size() = " + photoList.size());
                    PhotoModel.getObjInstance().notifyPhotosLoaded(photoList);
                } else {
                    PhotoModel.getObjInstance().notifyErrorInLoadingPhotos("Empty Photo List");
                }
            }
        }.execute();
    }
}
