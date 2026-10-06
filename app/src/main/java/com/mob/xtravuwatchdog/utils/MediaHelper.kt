package com.mob.xtravuwatchdog.utils

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.fragment.app.Fragment

object MediaHelper {

    const val PICK_IMAGE_FROM_DEVICE = 100
    const val PICK_MEDIA_FROM_DEVICE = 101

    fun openPhoneGalleryForImage(fragment: Fragment){
        Intent(Intent.ACTION_GET_CONTENT).run {
            this.type = "image/*"
            fragment.startActivityForResult(this, PICK_IMAGE_FROM_DEVICE)
        }
    }

    fun openPhoneGalleryForMedia(fragment: Fragment){
        Intent(Intent.ACTION_GET_CONTENT).run {
            this.type = "*/*"
            fragment.startActivityForResult(this, PICK_MEDIA_FROM_DEVICE)
        }
    }

    fun getMediaType(context: Context, source: Uri): MediaType? {
        val mediaTypeRaw = context.contentResolver.getType(source)
        if (mediaTypeRaw?.startsWith("image") == true)
            return MediaType.Image
        if (mediaTypeRaw?.startsWith("video") == true)
            return MediaType.Video
        return null
    }

    fun getVideoDuration(context: Context,videoPath: String?): Int {
        try {
            val mediaPlayer = MediaPlayer.create(context, Uri.parse(videoPath))
            val duration = mediaPlayer.duration // in milliseconds
            mediaPlayer.release()
            return duration
        } catch (e: java.lang.Exception) {
            // Handle Exception
            return 0
        }
    }

   /* fun getVideoDuration(context: Context, source: Uri): Long? {
        if (getMediaType(context, source) != MediaType.Video)
            return null
        val retriever = MediaMetadataRetriever()
        retriever.setDataSource(context, source)
        val duration = retriever.extractMetadata(METADATA_KEY_DURATION)
        retriever.release()
        return duration?.toLongOrNull()
    }*/
}

enum class MediaType {

    Image {
        override val mimeType: String = "image/jpeg"
        override val fileExtension: String = ".jpg"
    },

    Video {
        override val mimeType: String = "video/mp4"
        override val fileExtension: String = ".mp4"
    };

    abstract val mimeType: String
    abstract val fileExtension: String

}