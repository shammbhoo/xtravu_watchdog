package com.mob.xtravuwatchdog.repository


import android.util.Log
import com.google.gson.Gson
import com.mob.xtravuwatchdog.database.dao.AppDetailsDao
import com.mob.xtravuwatchdog.model.AppDetails


class AppDetailsRepository(private val appDetailsDao: AppDetailsDao) {

    // Get app details (LiveData for observing changes)
    fun getAppDetails(): List<AppDetails>{
        return appDetailsDao.getAppDetails()
    }

    // Insert or update app details
    suspend fun insertAppDetails(appDetails: AppDetails): Long {
        Log.d("insertAppDetails", "Log created: "+ Gson().toJson(appDetails))
        return appDetailsDao.insertAppDetails(appDetails)
    }

    suspend fun updateAppDetails(appDetails: AppDetails) {
        appDetailsDao.update(appDetails)
    }


}
