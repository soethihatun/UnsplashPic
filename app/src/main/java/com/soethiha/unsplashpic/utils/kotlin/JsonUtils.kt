package com.soethiha.unsplashpic.utils.kotlin

import android.content.Context
import org.json.JSONException
import java.io.IOException
import java.io.InputStream

/**
 * UnsplashPic
 *
 * @author SoeThihaTun
 * @version 1.0
 * @since 08/12/2017
 */
class JsonUtils private constructor() {
    init {
    }

    private object Holder {
        val INSTANCE = JsonUtils()
    }

    companion object {
        val instance: JsonUtils by lazy { Holder.INSTANCE }
    }

    @Throws(JSONException::class, IOException::class)
    fun loadDummyData(context: Context, directory: String, fileName: String) : String {
        val fullFilePath = directory + "/" + fileName
        val buffer: ByteArray = readJsonFile(context, fullFilePath)
        return String(buffer, charset("UTF-8"))
    }

    private fun readJsonFile(context: Context, fullFilePath: String): ByteArray {
        // Read file
        val inputStream: InputStream = context.assets.open(fullFilePath)
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        return buffer
    }
}