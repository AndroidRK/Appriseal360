package com.rutvik.appraisal360.database

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Manager::class], version = 1)
abstract class AppDatabase:RoomDatabase() {

    abstract  fun getManagerDao():ManagerDao

    companion object{
        @Volatile
        private var INSTANCE:AppDatabase? = null

        fun getDatabase(context:Context):AppDatabase{
            return  INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "apperisal_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}