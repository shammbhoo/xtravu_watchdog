package com.mob.xtravuwatchdog.ui

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.annotation.Nullable
import com.mob.xtravuwatchdog.databinding.ActivitySplashBinding
import com.mob.xtravuwatchdog.services.WakeMonitorService
import com.mob.xtravuwatchdog.ui.xtrvudss.XrtavuDSSActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : BaseActivity() {
    lateinit var binding: ActivitySplashBinding




    override fun init() {

        CoroutineScope(Dispatchers.Main).launch {
            try {
                delay(3000)
                startActivity(Intent(this@SplashActivity, XrtavuDSSActivity::class.java))
                finish()
            } catch (e: Exception) {
                Log.e("SplashActivity", "Error during splash coroutine: ", e)
            }
        }


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val serviceIntent = Intent(this, WakeMonitorService::class.java)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(serviceIntent)
        } else {
            startService(serviceIntent)
        }
        init()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, @Nullable data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == OVERLAY_PERMISSION_REQUEST_CODE) {
            if (Settings.canDrawOverlays(this)) {
                isOverlayPermission = false
                init()
            } else {
                Toast.makeText(this, "Overlay permission not granted.", Toast.LENGTH_SHORT).show()
                isOverlayPermission = false
            }
        }
    }
}
