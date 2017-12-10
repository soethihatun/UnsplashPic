package com.soethiha.unsplashpic.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

/**
 * UnsplashPic
 *
 * @author SoeThihaTun
 * @version 1.0
 * @since 06/12/2017
 */
class NetworkUtils {
    companion object {

        fun isOnline(context: Context): Boolean {
            val cm: ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val netInfo: NetworkInfo? = cm.activeNetworkInfo;

            return (netInfo != null && netInfo.isConnected)
        }
    }
}