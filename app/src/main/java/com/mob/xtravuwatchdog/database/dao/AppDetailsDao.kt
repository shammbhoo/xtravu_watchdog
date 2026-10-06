package com.mob.xtravuwatchdog.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.mob.xtravuwatchdog.model.AppDetails

@Dao
interface AppDetailsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAppDetails(appDetails: AppDetails): Long

    @Update
    fun update(appDetails: AppDetails)

  /*  @Query("SELECT * FROM AppDetails WHERE id = :id")
    fun getAppDetailsDeviceById(id: String): AppDetails?*/


    @Query("SELECT * FROM AppDetails")
    fun getAppDetails(): List<AppDetails>


}