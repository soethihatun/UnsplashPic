package com.soethiha.unsplashpic.utils

import android.content.Context
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
        println("This ($this) is a singleton")
    }

    private object Holder {
        val INSTANCE = JsonUtils()
    }

    companion object {
        val instance: JsonUtils by lazy { Holder.INSTANCE }
    }

    fun hello() = "Hello JsonUtils"

    fun loadDummyData(context: Context, directory: String, fileName: String): String {
        val fullFilePath = directory + "/" + fileName
        val buffer: ByteArray = readJsonFile(context, fullFilePath)
        return String(buffer, charset("UTF-8"))
    }

    private fun readJsonFile(context: Context, fullFilePath: String): ByteArray {
        // Read file
        val inputStream: InputStream = context.assets.open(fullFilePath)
        val size: Int = inputStream.available()
        val buffer: ByteArray = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        return buffer
    }
}