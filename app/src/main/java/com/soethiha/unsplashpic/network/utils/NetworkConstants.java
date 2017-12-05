package com.soethiha.unsplashpic.network.utils;

/**
 * UnsplashPic
 *
 * @author SoeThihaTun
 * @version 1.0
 * @since 02/12/2017
 */

public final class NetworkConstants {

    private NetworkConstants() {
    }

    public static final String PATH_DUMMY_DATA = "dummy_data";
    public static final String OFFLINE_SAMPLE_UNSPLASH_PHOTO_JSON_PATH =
            "sample_unsplash_photos_by_client_id.json";
    public static final String OFFLINE_UNSPLASH_PHOTO_JSON_PATH =
            "unsplash_photos_by_client_id.json";

    public static final String UNSPLASH_API_TEST_URL = "https://api.unsplash.com/photos/?client_id=058d27d7a23d475453a0dc5f145844c3a8fd19fdc47b902086f01bc2c805fb06";
    public static final String UNSPLASH_API_SCHEME = "https";
    public static final String UNSPLASH_API_HOST = "api.unsplash.com";
    public static final String UNSPLASH_API_PATH_SEGMENT = "photos";
    public static final String UNSPLASH_API_QUERY_PARAM_KEY = "client_id";
}
