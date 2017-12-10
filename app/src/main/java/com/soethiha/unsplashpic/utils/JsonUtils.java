package com.soethiha.unsplashpic.utils;

import android.content.Context;

import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;

/**
 * UnsplashPic
 *
 * @author SoeThihaTun
 * @version 1.0
 * @since 02/12/2017
 */
public class JsonUtils {

    private static JsonUtils objInstance;

    public static JsonUtils getObjInstance() {
        if (objInstance == null) {
            objInstance = new JsonUtils();
        }
        return objInstance;
    }

    private JsonUtils() {
    }

    public String loadDummyData(Context context, String directory, String fileName)
            throws IOException, JSONException {
        // Create full file path
        String fullFilePath = directory + "/" + fileName;

        byte[] buffer = readJsonFile(context, fullFilePath);
        return new String(buffer, "UTF-8");
    }

    private byte[] readJsonFile(Context context, String fullFilePath)
            throws IOException, JSONException {
        // Read file
        InputStream inputStream = context.getAssets().open(fullFilePath);
        int size = inputStream.available();
        byte[] buffer = new byte[size];
        inputStream.read(buffer);
        inputStream.close();
        return buffer;
    }
}
