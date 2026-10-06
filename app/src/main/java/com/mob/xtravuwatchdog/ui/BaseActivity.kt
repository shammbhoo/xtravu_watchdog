package com.mob.xtravuwatchdog.ui

import android.app.Activity
import android.app.Dialog
import android.app.ProgressDialog
import android.content.ActivityNotFoundException
import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.ServiceConnection
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.provider.Settings
import android.util.Log
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import com.mob.xtravuwatchdog.services.DownloadCallback
import com.mob.xtravuwatchdog.utils.Constants.apkUrl
import com.mob.xtravuwatchdog.utils.Constants.apkfileName
import com.mob.xtravuwatchdog.utils.CustomDialogBuilder
import com.mob.xtravuwatchdog.utils.GeneralUtils
import com.mob.xtravuwatchdog.utils.OnDismissListener
import com.mob.xtravuwatchdog.utils.SessionManager
import java.io.File
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.TimeZone


abstract class BaseActivity :AppCompatActivity() , DownloadCallback {


    val OVERLAY_PERMISSION_REQUEST_CODE: Int = 1000

    lateinit var sessionManager: SessionManager
    // private var downloadDialog: Dialog? = null
    private lateinit var handler: Handler
    var isOverlayPermission = false
    private val REQUEST_CODE_INSTALL: Int = 1011



    private val REQUEST_INSTALL_PACKAGES_PERMISSION_CODE = 1234

    //    protected Intent downloadService;
    lateinit var downloadProgressBar: ProgressBar
    lateinit var progressPercentage: TextView
    lateinit var ll_cancel: LinearLayout


    private var downloadBound = false
    private var downloadDialog: AlertDialog? = null
    lateinit var pairedDialog: Dialog
    var mProgressDialog: ProgressDialog? = null
    var isUpdateVersionDialogShow=false
    private var downloadCompleteReceiver: BroadcastReceiver? = null
    var licenceKeylogo:ImageView?=null

    lateinit var tvProgressbar:TextView
    lateinit var playlistDownloadProgressbar:ProgressBar

    fun getProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = ProgressDialog(this)
            Log.e("context", "progress initialized")
        }
    }

    fun isTimeExpiredIST(dateString: String): Boolean {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        dateFormat.timeZone = TimeZone.getTimeZone("Asia/Kolkata") // Use IST timezone

        return try {
            // Parse the given time in IST
            val givenTimeMillis = dateFormat.parse(dateString)?.time ?: 0L

            // Fetch the current time in IST
            val currentTimeMillis = System.currentTimeMillis()

            // Convert current time to IST for comparison
            val currentTimeIST = Calendar.getInstance(TimeZone.getTimeZone("Asia/Kolkata")).timeInMillis

            // Debug logs for offline troubleshooting
            println("Current system time (IST): ${Date(currentTimeIST)}")
            println("Parsed given time (IST): ${Date(givenTimeMillis)}")

            // Return comparison result
            currentTimeIST > givenTimeMillis
        } catch (e: Exception) {
            e.printStackTrace()
            false // Default to not expired if parsing fails
        }
    }

    fun isExpiredLegacy(dateString: String): Boolean {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        dateFormat.timeZone = TimeZone.getTimeZone("UTC") // Ensure UTC parsing

        return try {
            // Parse the given time in UTC
            val givenTimeMillis = dateFormat.parse(dateString)?.time ?: 0L

            // Fetch the current time in UTC (system time)
            val currentTimeMillis = System.currentTimeMillis()

            // Debug logs for offline troubleshooting
            println("Current system time (UTC): ${Date(currentTimeMillis)}")
            println("Parsed given time (UTC): ${Date(givenTimeMillis)}")

            // Return comparison result
            currentTimeMillis > givenTimeMillis
        } catch (e: Exception) {
            e.printStackTrace()
            false // Default to not expired if parsing fails
        }
    }

    fun isTimeExpired(utcTimestamp: String): Boolean {
        return try {
            // Define the input format (UTC time)
            val utcFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
            utcFormat.timeZone = TimeZone.getTimeZone("UTC") // Parse as UTC

            // Parse the UTC timestamp to a Date object
            val expiryDate = utcFormat.parse(utcTimestamp)

            // Get the current time in UTC
            val currentDate = Date()

            // Compare current time with expiry date
            currentDate.after(expiryDate)
        } catch (e: Exception) {
            // Handle any parsing errors gracefully
            println("Error parsing date: ${e.message}")
            false
        }
    }

    /*  fun isExpiredLegacy(expiryTimestamp: String): Boolean {
          // Parse the expiry timestamp string to Date in UTC
          val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
          format.timeZone = TimeZone.getTimeZone("UTC")
          val expiryDateUTC = format.parse(expiryTimestamp)

          // Convert the expiry date to IST
          val istTimeZone = TimeZone.getTimeZone("Asia/Kolkata")
          val formatIST = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.getDefault())
          formatIST.timeZone = istTimeZone
          val expiryDateIST = formatIST.parse(formatIST.format(expiryDateUTC!!))

          // Get the current time in IST
          val currentDate = Date()
          val currentDateIST = formatIST.parse(formatIST.format(currentDate))

          // Compare current date with expiry date in IST
          return currentDateIST!!.after(expiryDateIST!!)
      }*/

    abstract fun init()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sessionManager=SessionManager(this)
        handler = Handler(Looper.getMainLooper())
        val installedVersionName = getInstalledVersionName(packageName)




        /*if (!canInstallUnknownSources(this@BaseActivity)) {
             // If the app doesn't have permission, request it
             requestInstallPermission(this@BaseActivity);
         }*/
        // Register the receiver to listen for the download completion broadcast
        downloadCompleteReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                if ("com.mob.xtravu.DOWNLOAD_COMPLETE" == intent.action) {
                    // Handle the download completion (e.g., show a Toast, open the install screen, etc.)
                    Log.d("Download", "APK Download Complete!")
                    if (!canInstallUnknownSources(this@BaseActivity)) {
                        // If the app doesn't have permission, request it
                        requestInstallPermission(this@BaseActivity);
                    }
                    else{
                        installApk()
                    }
                }
            }
        }

        val filter = IntentFilter("com.mob.xtravu.DOWNLOAD_COMPLETE")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            registerReceiver(downloadCompleteReceiver, filter, RECEIVER_NOT_EXPORTED)
        }


        /*  baseViewModel.appAuthResponse.observe(this,{
              if (it){
                  // {"status":200,"appVersion":"1.0.1","versionCode":2,"LiencesKey":""}
                  //showToast("Licence has activated successfully!")
                  sessionManager.setLicenceKey(true)
                  if (licenceKeylogo!=null){
                      licenceKeylogo!!.visibility=View.GONE
                  }

              }
              else{
                  sessionManager.setLicenceKey(false)
                  if (licenceKeylogo!=null){
                      licenceKeylogo!!.visibility=View.VISIBLE
                  }
              }
          })*/
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.R) {
           init()
        }
        else {
            appNeccessaryPermission()
        }



    }
    fun showToast(message: String?) {
        val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
    }
    fun getDevice_Id():String{

        /*
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
             deviceId.toString()
         } else{
             Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
         }*/
        return Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
        //  val deviceIds = UUID.randomUUID().toString();
    }

    fun getDevice_Name():String{
        return Build.MODEL
    }

    fun getFileDirectory(): File? {
        return getExternalFilesDir(Environment.DIRECTORY_PICTURES)
    }


    fun getInstalledVersionCode(packageName: String): Long {
        val packageInfo: PackageInfo? = try {
            packageManager.getPackageInfo(packageName, 0)
        } catch (e: PackageManager.NameNotFoundException) {
            null
        }

        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            packageInfo?.longVersionCode ?: -1
        } else {
            packageInfo?.versionCode?.toLong() ?: -1
        }
    }

    fun getApkVersionCode(apkFile: File): Long {
        val packageInfo = packageManager.getPackageArchiveInfo(apkFile.absolutePath, 0)
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            packageInfo?.longVersionCode ?: -1
        } else {
            packageInfo?.versionCode?.toLong() ?: -1
        }
    }

    fun getInstalledVersionName(packageName: String): String? {
        val packageInfo: PackageInfo? = try {
            packageManager.getPackageInfo(packageName, 0)
        } catch (e: PackageManager.NameNotFoundException) {
            null
        }
        return packageInfo?.versionName
    }

    fun getApkVersionName(apkFile: File): String? {
        val packageInfo = packageManager.getPackageArchiveInfo(apkFile.absolutePath, 0)
        return packageInfo?.versionName
    }

    // Usage example
    fun isUpdateAvailable(apkFile: File, packageName: String): Boolean {
        val installedVersionCode = getInstalledVersionCode(packageName)
        val apkVersionCode = getApkVersionCode(apkFile)

        return apkVersionCode > installedVersionCode // If the APK version code is higher, update is available
    }

    fun isVersionNameNewer(installedVersionName: String, newVersionName: String): Boolean {
        val installedParts = installedVersionName.split(".")
        val newParts = newVersionName.split(".")

        val maxLength = maxOf(installedParts.size, newParts.size)

        for (i in 0 until maxLength) {
            val installedPart = installedParts.getOrNull(i)?.toIntOrNull() ?: 0
            val newPart = newParts.getOrNull(i)?.toIntOrNull() ?: 0

            if (newPart > installedPart) return true
            if (newPart < installedPart) return false
        }
        return false // Versions are equal
    }

    fun showUpdateDialog(newVersionName: String, apkUrl: String) {
        CustomDialogBuilder(this).showSimpleDialog("Update Available",
            "A new version ($newVersionName) is available. Would you like to update now?","Cancel","Ok",
            object : CustomDialogBuilder.OnDismissListener{
                override fun onPositiveDismiss() {
                    // checkStoragePermission()
                    isUpdateVersionDialogShow=false
                    launchPlayStore(this@BaseActivity,packageName)
                }

                override fun onNegativeDismiss() {
                    isUpdateVersionDialogShow=false
                    //throw RuntimeException("Test Crash") // Force a crash
                }

            })

    }


    fun showCloudAccessDialog(onDismissListener:OnDismissListener) {
        CustomDialogBuilder(this).showSimpleDialog("Cloud Access",
            "The Playlist will be accessed from the cloud","No, Keep it Local","Yes",
            object : CustomDialogBuilder.OnDismissListener{
                override fun onPositiveDismiss() {
                    // checkStoragePermission()
                    sessionManager.setCloudKey(true)
                    onDismissListener.onPositiveDismiss()

                }

                override fun onNegativeDismiss() {
                    sessionManager.setCloudKey(false)
                    onDismissListener.onNegativeDismiss()
                }

            })

    }



    fun openAppSettings() {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
            data = Uri.parse("package:$packageName")
        }
        startActivity(intent)
    }

    override fun updateProgress(progress: Int) {
        runOnUiThread {
            downloadProgressBar.setProgress(progress)
            progressPercentage.setText("$progress%")

        }
    }

    override fun onResume() {
        super.onResume()

    }

    override fun onDestroy() {
        super.onDestroy()
        if (downloadDialog != null) if (downloadDialog!!.isShowing) {
            downloadDialog!!.dismiss()
        }
        if (downloadCompleteReceiver != null) {
            unregisterReceiver(downloadCompleteReceiver);
        }
    }




    fun appNeccessaryPermission(){
        if (this is SplashActivity) {
            return
        }
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(this)) {
                if (!isOverlayPermission) {
                    isOverlayPermission = true
                    requestOverlayPermission()
                } else {
                    init()
                }
            } else {
                init()
            }
        } catch (e: Exception) {
            Log.e("BaseActivity", "Error during permission checks: ", e)
        }
    }

    val activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val data: Intent? = result.data
            // Handle the result here, e.g., extract data from the intent
            // Toast.makeText(this, "Activity Result: ${data?.getStringExtra("result")}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun requestOverlayPermission() {
        val intent = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:$packageName"))
        startActivityForResult(intent, OVERLAY_PERMISSION_REQUEST_CODE)
    }

    private fun installApk() {
        val toInstall = File(
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
            apkfileName + ".apk"
        )
        val apkUri = FileProvider.getUriForFile(
            this,
            "$packageName.provider", toInstall
        )

        val installIntent = Intent(Intent.ACTION_VIEW)
        installIntent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_ACTIVITY_NEW_TASK)
        installIntent.setDataAndType(apkUri, "application/vnd.android.package-archive")

        startActivity(installIntent)
        finish()
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            REQUEST_CODE_INSTALL -> {
                if (canInstallUnknownSources(this)) {
                    //  installApk()
                } else {
                    // Permission denied, handle accordingly
                }

            }
            OVERLAY_PERMISSION_REQUEST_CODE -> {
                if (Settings.canDrawOverlays(this)) {
                    isOverlayPermission = false
                    init()
                } else {
                    Toast.makeText(this, "Overlay permission not granted.", Toast.LENGTH_SHORT).show()
                    isOverlayPermission = false
                }
            }


            // Handle other request codes if needed
        }
    }
    private fun canInstallUnknownSources(context: Context): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.packageManager.canRequestPackageInstalls()
        } else {
            true // On versions below Android 8.0, this permission isn't needed
        }
    }
    private fun requestInstallPermission(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Request permission to install from unknown sources
            val intent = Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES)
            intent.data = Uri.parse("package:$packageName")
            requestPermissionLauncher.launch(intent)
        }
    }
    open fun launchPlayStore(context: Context, packageName: String) {
        var intent: Intent? = null
        try {
            intent = Intent(Intent.ACTION_VIEW)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.data = Uri.parse("market://details?id=$packageName")
            context.startActivity(intent)
        } catch (anfe: ActivityNotFoundException) {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=$packageName")
                )
            )
        }
    }
    fun loadPlaylistJsonFromAssets(context:Context, fileName: String = "playlist.json"): String? {
        return try {
            val inputStream = context.assets.open(fileName)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            kotlin.text.String(buffer, Charsets.UTF_8)
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            null
        }
    }
    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                // Permission granted, proceed with installation
                // installApk()
            } else {
                // Permission denied, show a message to the user
                Toast.makeText(this, "Permission to install from unknown sources is required", Toast.LENGTH_LONG).show()
            }
        }




    /*   fun showLicenceUpdateDialog(){
           val binding= LicenceActivateDialogBinding.inflate(layoutInflater)
           val loginDialog=CustomDialogBuilder(this).getSimpleDialog(this@BaseActivity, binding.root, false)
           loginDialog.show()
           binding.viewModel=baseViewModel
           binding.lifecycleOwner=this

           baseViewModel.appAuthResponse.observe(this,{
               if (it){
                   loginDialog.dismiss()
               }

              }
           )

           binding.closeDialogIcon.setOnClickListener{
               loginDialog.dismiss()
              // onBackPressed()
           }


       }*/
}