package com.mob.xtravuwatchdog.services

import android.accessibilityservice.AccessibilityService
import android.content.Intent
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import com.mob.xtravuwatchdog.ui.SplashActivity


class AutoLaunchService : AccessibilityService() {

    override fun onServiceConnected() {
        super.onServiceConnected()

        Log.d("AutoLaunchService", "Accessibility Service Connected")
        launchApp()

    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        // Optional: Kiosk Mode (keep app open)
        // If you want app to relaunch whenever user exits
        /*
        if (event?.eventType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
            launchApp()
        }
        */
    }

    override fun onInterrupt() {}

    private fun launchApp() {
        val intent = Intent(this, SplashActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }
}
