package com.mob.xtravuwatchdog.services

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.File
import java.io.FileOutputStream
import java.util.concurrent.TimeUnit

class FileDownloadWorker(context: Context, params: WorkerParameters) :
    Worker(context, params) {

    companion object {
        private const val TAG = "FileDownloadWorker"
    }

    override fun doWork(): Result {
        Log.d(TAG, "doWork() started with id $id")
        // Get the parameters
        val url = inputData.getString("url") ?: return Result.failure()
        val fileName = inputData.getString("fileName") ?: "default_file"
        val currentIndex = inputData.getInt("currentIndex", 0)
        val totalFiles = inputData.getInt("totalFiles", 1)
        Log.d(
            TAG,
            "FileDownloadWorker: url: $url, file name: $fileName, currentIndex: $currentIndex, totalFiles: $totalFiles"
        )

        // Configure OkHttpClient with timeouts
        val client = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

        val request = Request.Builder().url(url).build()
        Log.d(TAG, "FileDownloadWorker: beginning request")

        return try {
            val response = client.newCall(request).execute()
            Log.d(TAG, "FileDownloadWorker: received response ${response.code}")
            if (!response.isSuccessful) {
                Log.e(TAG, "FileDownloadWorker: response was not successful")
                sendProgressBroadcast(
                    fileName,
                    0,
                    currentIndex + 1,
                    totalFiles,
                    "failed",
                    false,
                    false
                )
                return Result.failure()
            }

            response.body?.byteStream()?.use { inputStream ->
                val contentLength = response.body?.contentLength() ?: -1L
                val file = File(applicationContext.filesDir, fileName)
                Log.d(TAG, "FileDownloadWorker: beginning file download to ${file.absolutePath}")

                FileOutputStream(file).use { outputStream ->
                    var bytesRead: Long = 0
                    val buffer = ByteArray(2048)
                    var read: Int

                    while (inputStream.read(buffer).also { read = it } != -1) {
                        // Check if we have been asked to stop the work.
                        if (isStopped) {
                            Log.d(TAG, "FileDownloadWorker has been stopped")
                            sendProgressBroadcast(
                                fileName,
                                0,
                                currentIndex + 1,
                                totalFiles,
                                "stopped",
                                true,
                                false
                            )
                            return Result.failure()
                        }

                        outputStream.write(buffer, 0, read)
                        bytesRead += read

                        val progress =
                            if (contentLength > 0) ((bytesRead * 100) / contentLength).toInt() else 0
                        sendProgressBroadcast(
                            fileName,
                            progress,
                            currentIndex + 1,
                            totalFiles,
                            "downloading",
                            false,
                            false
                        )
                    }
                    Log.d(TAG, "FileDownloadWorker: file downloaded successfully")
                }
                sendProgressBroadcast(
                    fileName,
                    100,
                    currentIndex + 1,
                    totalFiles,
                    "completed",
                    false,
                    true
                )
                Result.success(Data.Builder().putString("filePath", file.absolutePath).build())
            } ?: run {
                Log.e(TAG, "FileDownloadWorker: inputStream is null")
                sendProgressBroadcast(
                    fileName,
                    0,
                    currentIndex + 1,
                    totalFiles,
                    "failed",
                    false,
                    false
                )
                Result.failure()
            }

        } catch (e: Exception) {
            // Handle all exceptions.
            Log.e(TAG, "Exception: ${e.message}", e)
            sendProgressBroadcast("", 0, 0, 0, "failed", false, false)
            return Result.retry()
        }
    }

    private fun sendProgressBroadcast(
        fileName: String,
        progress: Int,
        currentIndex: Int,
        totalFiles: Int,
        status: String,
        isStopped: Boolean,
        isCompleted: Boolean
    ) {
        try {
            val intent = Intent("DOWNLOAD_PROGRESS_UPDATE").apply {
                putExtra("fileName", fileName)
                putExtra("progress", progress)
                putExtra("currentIndex", currentIndex)
                putExtra("totalFiles", totalFiles)
                putExtra("status", status)
                putExtra("isStopped", isStopped)
                putExtra("isCompleted", isCompleted)
            }
            applicationContext.sendBroadcast(intent)
        } catch (e: Exception) {
            Log.e(TAG, "Exception: ${e.message}", e)
        }
    }
}