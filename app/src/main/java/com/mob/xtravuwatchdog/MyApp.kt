package com.mob.xtravuwatchdog

import android.app.Application
import android.content.Context
import android.graphics.Bitmap
import android.media.MediaMetadataRetriever
import com.mob.xtravuwatchdog.utils.Constants
import com.mob.xtravuwatchdog.utils.SessionManager
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class MyApp : Application() {


    companion object{
       lateinit var appContext: Context
       lateinit var deviceID:String

        // Generates a thumbnail from the video at the specified path
         fun generateThumbnail(videoPath: String): Bitmap? {
            val retriever = MediaMetadataRetriever()
            try {
                retriever.setDataSource(videoPath)
                // Retrieve the frame at 1 second into the video (1000000 microseconds)
                return retriever.getFrameAtTime(1000000)
            } catch (e: Exception) {
                e.printStackTrace()
                return null
            } finally {
                retriever.release()
            }
        }
        // Saves the generated thumbnail to internal cache and returns the file path
         fun saveThumbnail(bitmap: Bitmap?): String? {
            if (bitmap == null) return null

            val storageDir: File = File(appContext.getFilesDir(), Constants.myThumbImageDir)
            if (!storageDir.exists()) {
                storageDir.mkdirs()
            }
            val fileName="thumbnail_"+System.currentTimeMillis()+".png"
            val file = File(storageDir, fileName)

            try {
                val out = FileOutputStream(file)
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
                out.flush()
                out.close()
                return file.absolutePath
            } catch (e: IOException) {
                e.printStackTrace()
            }

            return null
        }


    }

    override fun onCreate() {
        super.onCreate()
        appContext = this
        
        // Initialize SessionManager - it now uses device-protected storage
        // which is available even before the user unlocks the device
        try {
            val sessionManager = SessionManager(this)
        } catch (e: Exception) {
            // Log error but don't crash - SessionManager will be initialized when needed
            android.util.Log.e("MyApp", "Error initializing SessionManager: ${e.message}", e)
        }
    }

}