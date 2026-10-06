package com.mob.xtravuwatchdog.utils

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.os.SystemClock
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SessionManager(context: Context) {

    // Use device-protected storage context to allow access before user unlock
    // This is necessary for apps that need to run before the device is unlocked (e.g., auto-launch scenarios)
    // Device-protected storage is always available, even when the device is locked
    private val storageContext: Context = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        // Create device-protected storage context - this is always available, even when device is locked
        context.createDeviceProtectedStorageContext()
    } else {
        // For Android versions below N, use regular context (no encryption at this level)
        context
    }

    // SharedPreferences instance - using device-protected storage when available (Android N+)
    // This allows the app to access preferences even before the user unlocks the device
    private val prefs: SharedPreferences = storageContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    companion object {
        private const val PREF_NAME = "deviceSession"
        private const val KEY_IS_DIVICE_ID = "isDeviceID"
        private const val KEY_DEVICE_ID = "deviceId"
        private const val KEY_IS_PLAYLIST = "isPlaylist"
        private const val KEY_IS_AUTOLAUNCH = "isAutoLaunch"
        private const val KEY_IS_REMOTE_ADMIN_ACCESS="isRemoteAccess"
        private const val KEY_IS_LICENCE_KEY = "isLicenceKEy"
        private const val KEY_IS_CLOUD_KEY = "is_cloud_key"
        private const val KEY_IS_APP_INSTALLED = "is_app_installed"
        private const val KEY_PLAYLIST_ID= "playlist_id"
        private const val KEY_PLAYLIST_ASSIGN_TIMESTAMP= "playlist_assign_timestamp"
        private const val KEY_PLAYLIST_UPDATE_TIMESTAMP= "playlist_update_timestamp"
        private const val KEY_CLOUD_PLAYLIST= "cloud_playlist"
        private const val KEY_IS_PAIRED_DEVICE= "is_paired_device"
        private const val KEY_IS_SHOW_PROGRESS_UPDATE= "is_show_progress_update"
        private const val KEY_DEVICE_PLAYER= "device_player"
        private const val KEY_LAST_BOOT_LAUNCH_ELAPSED = "last_boot_launch_elapsed"
        private const val BOOT_LAUNCH_DEBOUNCE_MS = 90_000L // 90 seconds: ignore duplicate intents in same boot

    }

    /**
     * Returns true if we should launch from boot.
     * Uses elapsed realtime so that a device restart (new boot) always gets a launch;
     * only duplicate intents within the same boot (e.g. LOCKED_BOOT + BOOT_COMPLETED) are skipped.
     * Call setLastBootLaunchTime() after starting the activity.
     */
    fun shouldLaunchFromBoot(): Boolean {
        val nowElapsed = SystemClock.elapsedRealtime()
        val lastElapsed = prefs.getLong(KEY_LAST_BOOT_LAUNCH_ELAPSED, 0L)
        if (lastElapsed == 0L) return true
        // After a real reboot, elapsed time resets so nowElapsed < lastElapsed → new boot, launch
        if (nowElapsed < lastElapsed) return true
        // Same boot: skip only if we launched within the debounce window
        return (nowElapsed - lastElapsed) > BOOT_LAUNCH_DEBOUNCE_MS
    }

    fun setLastBootLaunchTime() {
        prefs.edit().putLong(KEY_LAST_BOOT_LAUNCH_ELAPSED, SystemClock.elapsedRealtime()).apply()
    }

    // Function to save login status and token
    fun createLoginSession(deviceId: String) {
        val editor = prefs.edit()
        editor.putBoolean(KEY_IS_DIVICE_ID, true)
        editor.putString(KEY_DEVICE_ID, deviceId)
        editor.apply()
    }
    // Function to save playlist status
    fun createPlaylistSession() {
        val editor = prefs.edit()
        editor.putBoolean(KEY_IS_PLAYLIST, true)
        editor.apply()
    }

    fun createEmptyPlaylistSession() {
        val editor = prefs.edit()
        editor.putBoolean(KEY_IS_PLAYLIST, false)
        editor.apply()
    }
    // Function to check Playlist status
    fun isPlaylist(): Boolean {
        return prefs.getBoolean(KEY_IS_PLAYLIST, false)
    }

    fun isLicenceKey(): Boolean {
        return prefs.getBoolean(KEY_IS_LICENCE_KEY, false)
    }

    fun isDevicePaired() : Boolean {
        return prefs.getBoolean(KEY_IS_PAIRED_DEVICE, false)
    }

    fun setDevicePaired(value:Boolean) {
        val editor = prefs.edit()
        editor.putBoolean(KEY_IS_PAIRED_DEVICE, value)
        editor.apply()
    }



    fun isShowProgressUpdate() : Boolean {
        return prefs.getBoolean(KEY_IS_SHOW_PROGRESS_UPDATE, false)
    }

    fun setProgressUpdate(value:Boolean) {
        val editor = prefs.edit()
        editor.putBoolean(KEY_IS_SHOW_PROGRESS_UPDATE, value)
        editor.apply()
    }


    fun isCloudKey() : Boolean {
        return prefs.getBoolean(KEY_IS_CLOUD_KEY, false)
    }

    fun setCloudKey(value:Boolean) {
        val editor = prefs.edit()
        editor.putBoolean(KEY_IS_CLOUD_KEY, value)
        editor.apply()
    }


    fun isAppInstalledKey() : Boolean {
        return prefs.getBoolean(KEY_IS_APP_INSTALLED, false)
    }

    fun setIsAppInstalledKey(value:Boolean) {
        val editor = prefs.edit()
        editor.putBoolean(KEY_IS_APP_INSTALLED, value)
        editor.apply()
    }

    fun setLicenceKey(value:Boolean) {
        val editor = prefs.edit()
        editor.putBoolean(KEY_IS_LICENCE_KEY, value)
        editor.apply()
    }

    fun isAutoLunch(): Boolean {
        return prefs.getBoolean(KEY_IS_AUTOLAUNCH, true)
    }

    fun setAutoLunch(value:Boolean) {
        val editor = prefs.edit()
        editor.putBoolean(KEY_IS_AUTOLAUNCH, value)
        editor.apply()
    }

    fun getDevicePlayer(): String? {
        return prefs.getString(KEY_DEVICE_PLAYER,"")
    }

    fun setDevicePlayer(value:String) {
        val editor = prefs.edit()
        editor.putString(KEY_DEVICE_PLAYER, value)
        editor.apply()
    }



    fun getPlaylistId(): String? {
        return prefs.getString(KEY_PLAYLIST_ID,"")
    }

    fun setPlaylistId(value:String) {
        val editor = prefs.edit()
        editor.putString(KEY_PLAYLIST_ID, value)
        editor.apply()
    }

    fun getPlaylistAssignTimestamp(): String? {
        return prefs.getString(KEY_PLAYLIST_ASSIGN_TIMESTAMP,"")
    }

    fun setPlaylistAssignTimestamp(value:String) {
        val editor = prefs.edit()
        editor.putString(KEY_PLAYLIST_ASSIGN_TIMESTAMP, value)
        editor.apply()
    }





    fun getPlaylistUpdateTimestamp(): String? {
        return prefs.getString(KEY_PLAYLIST_UPDATE_TIMESTAMP,"")
    }

    fun setPlaylistUpdateTimestamp(value:String) {
        val editor = prefs.edit()
        editor.putString(KEY_PLAYLIST_UPDATE_TIMESTAMP, value)
        editor.apply()
    }


    fun isRemoteAccess(): Boolean {
        return prefs.getBoolean(KEY_IS_REMOTE_ADMIN_ACCESS, true)
    }

    fun setRemoteAccess(value:Boolean) {
        val editor = prefs.edit()
        editor.putBoolean(KEY_IS_REMOTE_ADMIN_ACCESS, value)
        editor.apply()
    }



    // Function to check login status
    fun isDeviceId(): Boolean {
        return prefs.getBoolean(KEY_IS_DIVICE_ID, false)
    }

    // Function to retrieve the stored token
    fun getDeviceId(): String? {
        return prefs.getString(KEY_DEVICE_ID, "")
    }

    // Function to clear session data (e.g., on logout)
    fun logoutDevice() {
        val editor = prefs.edit()
        editor.clear()
        editor.apply()
    }
}
