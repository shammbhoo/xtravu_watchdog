package com.mob.xtravuwatchdog.services
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.content.pm.ServiceInfo
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.mob.xtravuwatchdog.ui.SplashActivity
import com.mob.xtravuwatchdog.utils.SessionManager

class WakeMonitorService : Service() {
    lateinit var sessionManager: SessionManager
    companion object {
        private const val TAG = "WakeMonitorService"
        private const val CHANNEL_ID = "WakeMonitorServiceChannel"
        private const val NOTIFICATION_ID = 1
    }

    private val wakeReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            Log.d(TAG, "Received intent: ${intent.action}")
            try {
                sessionManager=SessionManager(context)
                Log.d(TAG, "Received intent sessionManager.isAutoLunch: ${sessionManager.isAutoLunch()}")
                if (sessionManager.isAutoLunch()){
                    if (intent.action == Intent.ACTION_SCREEN_ON || intent.action == Intent.ACTION_USER_PRESENT) {
                        // On Android 10+ background activity launches are restricted.
                        // Show a notification the user can select to open the app.
                        showBringToFrontNotification()
                    }
                }

            } catch (e: Exception) {
                Log.e(TAG, "Error handling broadcast: ${e.message}", e)
            }
        }
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "Service created.")

        // Create and show a foreground notification
        createNotificationChannel()
        val notification = buildForegroundNotification()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            startForeground(
                NOTIFICATION_ID,
                notification,
                ServiceInfo.FOREGROUND_SERVICE_TYPE_DATA_SYNC
            )
        } else {
            startForeground(NOTIFICATION_ID, notification)
        }

        // Register the broadcast receiver
        val filter = IntentFilter().apply {
            addAction(Intent.ACTION_SCREEN_ON)
            addAction(Intent.ACTION_USER_PRESENT)
        }
        registerReceiver(wakeReceiver, filter)
        Log.d(TAG, "Receiver registered.")
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(wakeReceiver)
        Log.d(TAG, "Receiver unregistered.")
    }

    override fun onBind(intent: Intent?): IBinder? = null

    private fun showBringToFrontNotification() {
        val intent = Intent(this, SplashActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
        }
        val pending = android.app.PendingIntent.getActivity(
            this,
            0,
            intent,
            (if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) android.app.PendingIntent.FLAG_IMMUTABLE else 0) or android.app.PendingIntent.FLAG_UPDATE_CURRENT
        )

        val manager = getSystemService(NotificationManager::class.java)
        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("XtrAVU Ready")
            .setContentText("Select to open the app")
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pending)
            .setAutoCancel(true)
            .build()
        manager?.notify(NOTIFICATION_ID + 1, notification)
    }

    /**
     * Creates the notification channel for foreground service (Android 8.0+).
     */
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Wake Monitor Service",
                NotificationManager.IMPORTANCE_LOW
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager?.createNotificationChannel(channel)
        }
    }

    /**
     * Builds the notification to show for the foreground service.
     */
    private fun buildForegroundNotification(): Notification {
        return NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Wake Monitor Service")
            .setContentText("Monitoring wake events.")
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .build()
    }
}
