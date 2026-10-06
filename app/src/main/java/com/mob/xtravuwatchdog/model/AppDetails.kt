package com.mob.xtravuwatchdog.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "AppDetails")
data class AppDetails(
    @ColumnInfo(name = "logLevel")
    var logLevel:String,
    @ColumnInfo(name = "logTime")
    var logTime: String,
    @ColumnInfo(name = "logMessage")
    var logMessage:String){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id:Int=0

}


