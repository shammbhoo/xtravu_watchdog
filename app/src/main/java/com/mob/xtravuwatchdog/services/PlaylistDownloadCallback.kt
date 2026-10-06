package com.mob.xtravuwatchdog.services

interface PlaylistDownloadCallback {
    fun onDownloadFailed(errorMessage: String)
    fun onProgressUpdate(fileName: String, progress: Int, currentIndex: Int, totalFiles: Int)
    fun onOverallProgressUpdate(progress: Int)
    fun onAllDownloadsCompleted()
}