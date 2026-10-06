package com.mob.xtravuwatchdog.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import com.mob.xtravuwatchdog.utils.SessionManager
import com.mob.xtravuwatchdog.ui.SplashActivity


class BootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        println("BootReceiver::onReceive hiiiii")

        val isBootAction = intent.action == Intent.ACTION_BOOT_COMPLETED ||
                intent.action == Intent.ACTION_LOCKED_BOOT_COMPLETED
        if (!isBootAction) return

        val sessionManager = SessionManager(context)
        // On Android 14 (and TV devices like Google/Panasonic), both LOCKED_BOOT_COMPLETED
        // and BOOT_COMPLETED can fire, so we debounce to launch only once per boot.
        if (!sessionManager.shouldLaunchFromBoot()) {
            android.util.Log.d("BootReceiver", "Skipping duplicate boot launch (debounce)")
            return
        }
        sessionManager.setLastBootLaunchTime()

        val launchIntent = Intent(context, SplashActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        context.startActivity(launchIntent)
    }
}