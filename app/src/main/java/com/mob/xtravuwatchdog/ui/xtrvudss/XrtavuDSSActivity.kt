package com.mob.xtravuwatchdog.ui.xtrvudss

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.google.gson.Gson
import com.mob.xtravuwatchdog.database.AppDatabase
import com.mob.xtravuwatchdog.databinding.ActivityXtravuDssBinding
import com.mob.xtravuwatchdog.model.AppDetails
import com.mob.xtravuwatchdog.repository.AppDetailViewModelFactory
import com.mob.xtravuwatchdog.repository.AppDetailsRepository
import com.mob.xtravuwatchdog.ui.BaseActivity
import com.mob.xtravuwatchdog.viewmodel.AppDetailsViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class XrtavuDSSActivity : BaseActivity() {
    private var logJob: Job? = null
    private var logList: List<AppDetails> = ArrayList() // Stores log data to save to Excel
    private lateinit var viewModel: AppDetailsViewModel
    private lateinit var binding: ActivityXtravuDssBinding
    private val targetPackageName = "com.signage.gdneombgbw"

    override fun init() {
        // Initialize activity (if necessary)
    }

    /**
     * Launches the target app or brings it to front if already running.
     * Uses FLAG_ACTIVITY_REORDER_TO_FRONT so calling again when app is open brings it to front.
     */
    private fun launchApp() {
        val packageManager = packageManager

        // Check if package is installed
        try {
            packageManager.getPackageInfo(targetPackageName, 0)
        } catch (e: Exception) {
            Log.e("AppLauncher", "Package not installed: $targetPackageName", e)
            Toast.makeText(this, "App not found or not installed", Toast.LENGTH_SHORT).show()
            return
        }

        var launchIntent = packageManager.getLaunchIntentForPackage(targetPackageName)
        if (launchIntent == null) {
            // Fallback: try to resolve MAIN/LAUNCHER activity manually
            launchIntent = packageManager.queryIntentActivities(
                Intent(Intent.ACTION_MAIN).apply { addCategory(Intent.CATEGORY_LAUNCHER) },
                0
            ).firstOrNull { it.activityInfo.packageName == targetPackageName }?.let { resolveInfo ->
                Intent(Intent.ACTION_MAIN).apply {
                    setClassName(targetPackageName, resolveInfo.activityInfo.name)
                }
            }
        }

        try {
            if (launchIntent != null) {
                launchIntent.addFlags(
                    Intent.FLAG_ACTIVITY_NEW_TASK or
                        Intent.FLAG_ACTIVITY_REORDER_TO_FRONT or
                        Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED
                )
                startActivity(launchIntent)
                Log.d("AppLauncher", "Launched or brought to front: $targetPackageName")
                // Finish so the launched app stays on top; otherwise this activity can resurface
                finish()
            } else {
                Toast.makeText(this, "App cannot be launched (no launcher activity)", Toast.LENGTH_SHORT).show()
                Log.e("AppLauncher", "No launcher activity for: $targetPackageName")
            }
        } catch (e: Exception) {
            Log.e("AppLauncher", "Error launching app: ${e.message}", e)
            Toast.makeText(this, "Error launching app: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityXtravuDssBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val deviceDao = AppDatabase.getDataseClient(application).appDetailsDaoAccess()
        val deviceRepository = AppDetailsRepository(deviceDao)
        val factory = AppDetailViewModelFactory(deviceRepository)
        viewModel = ViewModelProvider(this, factory).get(AppDetailsViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

       /* // Start logging when the app is active
        startLogging()

        // Observe live data for changes
        viewModel.appDetails.observe(this) { value ->
            value?.let {
                if (value.isNotEmpty()) {
                    logList = value
                    println("logList:::"+ Gson().toJson(value))
                    saveLogsToExcel() // Save logs to Excel when data changes
                }
            }
        }

        // Fetch logs periodically
        saveLogging()
       */
        // Defer launch until window is ready to improve reliability (fixes "sometimes doesn't launch")
        binding.root.post {
            launchApp()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
      //  stopLogging() // Stop the logging job when the app is closed
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        // Handle new intent when activity is already running (singleTask mode)
        // Don't launch app again if it's already launched
        setIntent(intent)
    }

    private fun isOverlayPermissionGranted(context: Context): Boolean {
        return Settings.canDrawOverlays(context)
    }

    private fun startLogging() {
        logJob = lifecycleScope.launch(Dispatchers.Default) {
            while (isActive) {
                createLog() // Create log every 5 minutes
                delay(5*1000) // Delay for 5 minutes
            }
        }
    }

    private fun saveLogging() {
        logJob = lifecycleScope.launch(Dispatchers.Default) {
            while (isActive) {
                viewModel.getAppDetails() // Fetch app details from Room
                delay(2 * 60 * 1000) // Fetch data every 2 minutes
            }
        }
    }

    private fun stopLogging() {
        logJob?.cancel() // Stop the logging job when app is destroyed
    }

    private fun createLog() {
        val currentTime = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())
        val logLevel = "INFO"
        val logMessage = "Periodic log at $currentTime"

        // Add the log data to the list and insert into Room
        val appLogDetail = AppDetails(logLevel, currentTime, logMessage)
        viewModel.insertAppDetails(appLogDetail)
        Log.d("LogCoroutine", "Log created: $logMessage")
    }

    private fun saveLogsToExcel() {

        if (logList.isEmpty()) return

        val workbook = XSSFWorkbook()
        val sheet = workbook.createSheet("App Logs")

        try {
            // Write header row
            val header = listOf("ID", "Log Level", "Log Time", "Log Message")
            val headerRow: Row = sheet.createRow(0)
            header.forEachIndexed { index, value ->
                val cell: Cell = headerRow.createCell(index)
                cell.setCellValue(value)
            }

            // Populate log data from AppDetails table
            val logData = mutableListOf<List<String>>()
            logList.forEach { appDetail ->
                logData.add(listOf(
                    appDetail.id.toString(),
                    appDetail.logLevel,
                    appDetail.logTime,
                    appDetail.logMessage
                ))
            }

            // Add the log data to the sheet
            for ((rowIndex, logRow) in logData.withIndex()) {
                val row: Row = sheet.createRow(rowIndex + 1) // +1 to skip the header row
                for ((cellIndex, cellValue) in logRow.withIndex()) {
                    val cell: Cell = row.createCell(cellIndex)
                    cell.setCellValue(cellValue)
                }
            }

            // Save the Excel file to the device
            val fileName = "Xtrvu_watch_dog_Logs_${getDevice_Id()}.xlsx"
            val file = File(getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), fileName)
            FileOutputStream(file).use { fos ->
                workbook.write(fos)
            }

            Log.d("LogCoroutine", "Excel file saved: ${file.absolutePath}")

        } catch (e: IOException) {
            Log.e("LogCoroutine", "Error saving Excel file: ${e.message}", e)
        } finally {
            try {
                workbook.close()
            } catch (e: IOException) {
                Log.e("LogCoroutine", "Error closing workbook: ${e.message}", e)
            }
        }
    }

}




