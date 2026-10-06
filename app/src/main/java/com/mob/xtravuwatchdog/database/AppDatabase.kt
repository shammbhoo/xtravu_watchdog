package com.mob.xtravuwatchdog.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mob.xtravuwatchdog.database.dao.AppDetailsDao
import com.mob.xtravuwatchdog.model.AppDetails

@Database(entities = [AppDetails::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun appDetailsDaoAccess():AppDetailsDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDataseClient(context: Context) : AppDatabase {

            if (INSTANCE != null) return INSTANCE!!

            synchronized(this) {

                INSTANCE = Room.databaseBuilder(context, AppDatabase::class.java, "xtravuWatchdog_DATABASE")
                    .fallbackToDestructiveMigration()
                    .build()

                return INSTANCE!!

            }
        }

    }

}