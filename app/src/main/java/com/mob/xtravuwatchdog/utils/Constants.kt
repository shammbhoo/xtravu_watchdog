package com.mob.xtravuwatchdog.utils

import android.graphics.Bitmap
import android.net.Uri
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.qrcode.QRCodeWriter
import com.mob.xtravuwatchdog.MyApp
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

object Constants {
   const val rootDirectory="xtravu"
   const val myVideosDir= rootDirectory+"/my_videos"
   const val myImageDir= rootDirectory+"/my_images"
   const val myThumbImageDir= rootDirectory+"/my_thumb_images"
   const val action="action"
   const val callFrom="callFrom"
   const val IMAGE="image"
   const val VIDEO="video"
   const val WEBPAGE="webpage"
   const val HDMI="hdmi"
   const val data="data"
   const val AUTOLAUNCH="auto_launch"
   const val port=2323
   const val customFolderPath = "/storage/emulated/0/Download/xtravu"
   const val apkfileName="xtravu"
   const val cloudBaseUrl="http://192.168.31.96:3005"//local server
  // const val cloudBaseUrl="http://143.110.188.148:3009"

   const val endUrl="/api/v1/app"
   const val version= endUrl+"/version"
   const val auth= endUrl+"/auth"
   const val registerDevice= endUrl+"/register/device"
   const val deviceplayer= endUrl+"/deviceplayer"
   const val autolaunch= endUrl+"/autolaunch"
   const val progressbar= endUrl+"/progressbar"
   const val setting = endUrl+"/setting"


   const val regenratePairedNo= endUrl+"/pair/otp"
   const val apkUrl = cloudBaseUrl + endUrl+"/" // Replace with your APK URL



   // Fill in your Solace Cloud PubSub+ Broker's 'MQTT Host' and 'Password' options.
   // This information can be found under:
   // https://console.solace.cloud/services/ -> <your-service> -> 'Connect' -> 'MQTT'
   const val SOLACE_CLIENT_USER_NAME = "admin"
   const val SOLACE_CLIENT_PASSWORD = "public"
   const val SOLACE_MQTT_HOST = "tcp://192.168.31.96:1883"

   // Other options
   const val SOLACE_CONNECTION_TIMEOUT = 3
   const val SOLACE_CONNECTION_KEEP_ALIVE_INTERVAL = 60
   const val SOLACE_CONNECTION_CLEAN_SESSION = true
   const val SOLACE_CONNECTION_RECONNECT = true

   // mqtt subscribe
   const val Topic_Playlist_Assign = "playlist/assign/"
   const val Topic_Playlist_Update = "playlist/update/"
   const val Topic_Device="device/"






  // const val apkUrl = "http://192.168.31.32:2323/" // Replace with your APK URL
   fun prepareFilePart(partName: String, filePath: String): MultipartBody.Part {
      val file = File(filePath!!)  // Make sure this file exists
      // Create request body for the file
      val requestFile = RequestBody.create(
         MyApp.appContext.contentResolver.getType(Uri.fromFile(file))?.toMediaTypeOrNull(),
         file
      )
      // MultipartBody.Part is used to send also the actual file name
      return MultipartBody.Part.createFormData(partName, file.name, requestFile)
   }
   fun generateQRCode(text: String): Bitmap? {
      val writer = QRCodeWriter()
      try {
         val bitMatrix = writer.encode(text, BarcodeFormat.QR_CODE, 512, 512)
         val width = bitMatrix.width
         val height = bitMatrix.height
         val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)
         for (x in 0 until width) {
            for (y in 0 until height) {
               bitmap.setPixel(x, y, if (bitMatrix.get(x, y)) -0x1000000 else -0x1) // Set black and white pixels
            }
         }
         return bitmap
      } catch (e: WriterException) {
         e.printStackTrace()
      }
      return null
   }
}

enum class ActionType{
   INSERT,
   UPDATE,
   DELETE
}

enum class PlayerType{
   EXOPLAYER,
   MEDIAPLAYER
}